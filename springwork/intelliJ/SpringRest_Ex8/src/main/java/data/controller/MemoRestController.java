package data.controller;

import data.dao.MemoDao;
import data.dto.MemoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class MemoRestController {

    @Autowired
    private MemoDao memoDao;

    private String photo;

    @PostMapping("/memo/upload")
    public String fileUpload(@RequestParam("upload") MultipartFile upload, HttpServletRequest request){
        //파일을 업로드할 위치

        System.out.println("업로드한 파일명 " + upload.getOriginalFilename());

        String path = request.getSession().getServletContext().getRealPath("/resources/upload");
        System.out.println(path);

        //랜덤 파일명
        photo = UUID.randomUUID().toString();

        //업로드

        try {
            upload.transferTo(new File(path + "/" + photo));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return photo;
    }

    @GetMapping("/memo/add")
    public void memoAdd(@RequestParam String nickname, @RequestParam String memo){
        MemoDto dto = new MemoDto();

        dto.setNickname(nickname);
        dto.setMemo(memo);
        dto.setPhoto(photo);

        photo = null;

        //db insert
        memoDao.insertMemo(dto);

    }

    //메모 목록 json으로 반환
    @GetMapping("/memo/view")
    public List<MemoDto> getAllMemo(){

        return memoDao.getAllMemos();
    }


    @GetMapping("/memo/delete")
    public void memoDelete(@RequestParam int num){
        memoDao.deleteMemo(num);
    }

    @GetMapping("/memo/likes")
    public Map<String, Integer> countLikes(@RequestParam int num){
        //좋아요 수 증가
        memoDao.updateLikes(num);

        //증가된 좋아요 수 얻기
        int likes = memoDao.getCountLikes(num);

        Map<String, Integer> map = new HashMap<>();
        map.put("likes", likes);

        return map;
    }


}
