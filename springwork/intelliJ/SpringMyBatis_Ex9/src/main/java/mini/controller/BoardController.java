package mini.controller;

import mini.dao.BoardAnswerDao;
import mini.dao.MemberDao;
import mini.dto.BoardAnswerDto;
import mini.dto.BoardDto;
import mini.dto.BoardFileDto;
import mini.service.BoardAnswerService;
import mini.service.BoardFileService;
import mini.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardFileService boardFileService;

    @Autowired
    private BoardAnswerService boardAnswerService;

    @Autowired
    private MemberDao memberDao;

    @GetMapping("/board/list")    //currentPage값이 없을 때는 1 페이지로 가도록 설정
    public String list(Model model, @RequestParam(defaultValue = "1") int currentPage) {

        int perPage = 5; //한페이지당 보여지는 게시글의 갯수
        int totalCount = 0; //총 개시글의 개수
        int totalPage; //총페이지수
        int startNum; //각페이지당 보여지는 글의 시작번호
        //int endNum; mysql은 필요없음 (오라클에서만 필요)
        int perBlock = 5; //한블럭당 보여지는 페이지의 개수
        int startPage; //각블럭당 보여지는 페이지의 시작번호
        int endPage;

        //총 글갯수
        totalCount = boardService.getTotalCount();

        //총페이지수,나머지가 있으면 무조건올림
        //총게시글이 37-한페이지 3-12.3333....13페이지
        totalPage = totalCount / perPage + (totalCount % perPage > 0 ? 1 : 0);

        //각블럭의 시작페이지와 끝페이지
        startPage = (currentPage - 1) / perBlock * perBlock + 1;
        endPage = startPage + perBlock - 1;

        //endPage는 totalPage를 넘지않도록 한다
        if (endPage > totalPage){
            endPage = totalPage;
        }

        //각 페이지당 불러올 글의 번호(10개 기준)
        //1페이지:0~9 2페이지:10~19 3페이지:20-29
        startNum = (currentPage - 1) * perPage;

        //각 페이지의 시작 번호
        int no = totalCount - (currentPage - 1) * perPage;

        //해당페이지에 보여줄 게시판 목록  (Mysql은 endNum대신에 perPage를 보내면된다.)
        List<BoardDto> list = boardService.getList(startNum, perPage);

        //각 dto에 첨부된 사진의 갯수 저장
        for(BoardDto dto:list){
            int pcount = boardFileService.getPhotoByNum(dto.getNum()).size();
            System.out.println(dto.getNum() + ":" + pcount);
            dto.setPhotoCount(pcount);

            //댓글 갯수 저장
            int acount = boardAnswerService.getAnswerBoard(dto.getNum()).size();

            dto.setAcount(acount);
        }



        //request 에 담을 값들
        model.addAttribute("list", list);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("no", no);

        return "board/boardlist";
    }

    @GetMapping("/board/form")
    //새글일 경우 기본값이 1로 들어가게
    public String form(Model model,
                       @RequestParam(defaultValue = "1") int currentPage,
                       @RequestParam(defaultValue = "0") int num,
                       @RequestParam(defaultValue = "0") int regroup,
                       @RequestParam(defaultValue = "0") int restep,
                       @RequestParam(defaultValue = "0") int relevel) {

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("num", num);
        model.addAttribute("regroup", regroup);
        model.addAttribute("restep", restep);
        model.addAttribute("relevel", relevel);

        //답글일 경우 제목 가져오기
        String subject = "";
        if (num > 0) {
            subject = boardService.getData(num).getSubject();
        }

        model.addAttribute("subject", subject);

        return "board/boardform";
    }

    @PostMapping("/board/addboard")
    public String addBoard(
            @ModelAttribute BoardDto dto,
            @RequestParam String currentPage,
            @RequestParam List<MultipartFile> upload,
            HttpServletRequest request,
            HttpSession session
    ) {

        String path = request.getSession().getServletContext().getRealPath("resources/upload");

        //boarddb에 저장할 로그인 정도
        String myid = (String) session.getAttribute("myid");
        String writer = (String) session.getAttribute("myname");

        //dto에 넣기
        dto.setMyid(myid);
        dto.setWriter(writer);

        //BoardDto먼저 저장
        boardService.insertBoard(dto);

        //selectKey:num값 넘어왔는지 확인
        System.out.println("num" + dto.getNum());

        //사진 업로드
        //사진 업로드를 안했을 경우 리스트의 첫 데이터의 파일명이 빈문자열이 된다. (NULL이 아님)
        //즉 업로드를 했을 경우에만 db에 저장
        if (!upload.get(0).getOriginalFilename().equals("")) {

            String fileName = "";

            for (MultipartFile multi : upload) {
                fileName = UUID.randomUUID().toString();
                try {
                    multi.transferTo(new File(path + "/" + fileName));

                    BoardFileDto fdto = new BoardFileDto();
                    fdto.setNum(dto.getNum());
                    fdto.setPhotoname(fileName);

                    boardFileService.insertPhoto(fdto);

                } catch (IllegalStateException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //새글인 경우에은 1페이지로, 답글인 경우에는 보던 페이지로 이동한다.
        return "redirect:list?currentPage=" + currentPage;
    }


    @PostMapping("/board/updateboard")
    public String updateBoard(
            @ModelAttribute BoardDto dto,
            @RequestParam String currentPage,
            @RequestParam List<MultipartFile> upload,
            HttpServletRequest request,
            HttpSession session
    ) {

        String path = request.getSession().getServletContext().getRealPath("resources/upload");

        //수정
        boardService.updateBoard(dto);


        //사진 업로드
        //사진 업로드를 안했을 경우 리스트의 첫 데이터의 파일명이 빈문자열이 된다. (NULL이 아님)
        //즉 업로드를 했을 경우에만 db에 저장
        if (!upload.get(0).getOriginalFilename().equals("")) {

            String fileName = "";

            for (MultipartFile multi : upload) {
                fileName = UUID.randomUUID().toString();
                try {
                    multi.transferTo(new File(path + "/" + fileName));

                    BoardFileDto fdto = new BoardFileDto();
                    fdto.setNum(dto.getNum());
                    fdto.setPhotoname(fileName);

                    boardFileService.insertPhoto(fdto);

                } catch (IllegalStateException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //수정 후 내용보기로 이동한다.
        return "redirect:content?currentPage=" + currentPage +"&num=" + dto.getNum();
    }
    @GetMapping("board/content")
    public String getContent(Model model,
                             @RequestParam int num,
                             @RequestParam(defaultValue = "1") int currentPage){


        //조회 수 증가
        boardService.updateReadCount(num);

        //num에 해당하는 dto 얻기
        BoardDto dto = boardService.getData(num);

        //memberDAO에서 photo 정보 가져오기
        String profile_photo = memberDao.getData(dto.getMyid()).getPhoto();

        //사진과 사진 갯수
        List<String> photos = boardFileService.getPhotoByNum(num);


        dto.setPhotoCount(photos.size());
        dto.setPhotoNames(photos);

        model.addAttribute("profile_photo", profile_photo);
        model.addAttribute("dto", dto);
        model.addAttribute("currentPage", currentPage);

        return "board/content";
    }

    @GetMapping("board/delete")
    public String deleteBoard(@RequestParam int num, @RequestParam int currentPage){

        //삭제
        boardService.deleteBoard(num);

        return "redirect:list?currentPage=" + currentPage;
    }

    @GetMapping("/board/updateform")
    public String updateForm(Model model, @RequestParam int num, @RequestParam int currentPage){
        BoardDto dto = boardService.getData(num);
        List<BoardFileDto> flist = boardFileService.getFileDateByNum(num);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("dto", dto);
        model.addAttribute("flist", flist);

        return "board/updateform";
    }

    @GetMapping("/board/delphoto")
    @ResponseBody public void deletePhoto(@RequestParam int idx){
        //해당 사진 삭제
        boardFileService.deletePhoto(idx);
    }

}
