package mini.controller;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import mini.dao.MemberDao;
import mini.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @NonNull
    private MemberDao memberDao;//  Service가 있을 경우 이 자리에 Service를 넣어주면 됨.

    @GetMapping("/member/form")
    public String member(){
        return "member/memberform";
    }

    @GetMapping("/member/list")
    public String memberList(Model model){

        //총 멤머수 얻기
        int totalCount = memberDao.getTotalCount();
        model.addAttribute("totalCount", totalCount);
        return "member/memberlist";
    }

    @PostMapping ("/member/addmember")
    public String addMember(
            HttpServletRequest request,
            @ModelAttribute MemberDto dto,
            @RequestParam MultipartFile upload){

        //upload 의 위치를 읽어야하므로 HttpServletRequest가 필요함

        String path = request.getSession().getServletContext().getRealPath("/resources/upload");

        String photo = null;

        if(upload.getOriginalFilename().equals("")){
            photo = "no";
        } else {
            photo = UUID.randomUUID().toString();

            try{
                upload.transferTo(new File(path + "/"+ photo));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        dto.setPhoto(photo);

        memberDao.insertMember(dto);

        return "redirect:./list";
    }

    @GetMapping("/member/idcheck")
    @ResponseBody
    public Map<String, Integer> getIdCount(@RequestParam String myid){
     int count = memberDao.searchIdCount(myid);
     Map<String, Integer> map = new HashMap<>();
     map.put("count", count);
     return map;
    }

    @GetMapping("/member/search")
    @ResponseBody List<MemberDto> getSearchList(@RequestParam String field, @RequestParam String word){
       return memberDao.getSearchMember(field, word);
    }

    @GetMapping("/member/delete")
    @ResponseBody void deleteMember(@RequestParam int num){
        memberDao.deleteMember(num);
    }



}
