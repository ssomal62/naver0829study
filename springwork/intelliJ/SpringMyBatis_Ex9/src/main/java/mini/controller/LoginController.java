package mini.controller;

import mini.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    private MemberDao memberDao;


    @GetMapping("/login/main")
    public String login(){
        return "login/loginmain";
    }


    @GetMapping("/login/process")
    @ResponseBody
    Map<String, Object> login(@RequestParam boolean saveid, @RequestParam String myid, @RequestParam String pass, HttpSession session){

        Map<String, Object> map = new HashMap<>();

        boolean bLogin = memberDao.isLoginCheck(myid, pass);

        if(bLogin){

            //세션 유지시간  (기본 30분)
            session.setMaxInactiveInterval(60*60*60); // 6시간 유지

            //로그인 성공시 세션으로 보낸다.
            session.setAttribute("loginok", "yes");
            session.setAttribute("saveid", saveid ? "yes" : "no");
            session.setAttribute("myid", myid);

            //아이디에 해당하는 이름 얻어서 세션에 저장
            String myname = memberDao.getData(myid).getName();
            session.setAttribute("myname", myname);

            //아이디에 해당하는 사진 얻기
            String myphoto = memberDao.getData(myid).getPhoto();
            session.setAttribute("myphoto", myphoto);

            //map에는 성공인지 실패인지 전달한다.
            map.put("success", true);
        } else {
            //map에는 성공인지 실패인지 전달한다.
            map.put("success", false);
        }

        return map;
    }

    @GetMapping("/login/logout")
    @ResponseBody public void logout(HttpSession session){
        session.removeAttribute("loginok");
    }


    @PostMapping("/login/photochange")
    @ResponseBody Map<String, String> photoChange(@RequestParam MultipartFile upload, HttpSession session, HttpServletRequest request){

        //현재 로그인한 아이디 얻기
        String myid = (String)session.getAttribute("myid");

        //업데이트 사진 보낼
        String path = request.getSession().getServletContext().getRealPath("/resources/upload");

        //랜덤 파일명 얻기
        String fileName = UUID.randomUUID().toString();

        try {
            upload.transferTo(new File(path + "/" + fileName));

        }catch (IllegalStateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        memberDao.updatePhoto(fileName, myid);

        session.setAttribute("myphoto", fileName);

        Map<String, String> map = new HashMap<>();
        map.put("filename", fileName);
        return map;
    }
}
