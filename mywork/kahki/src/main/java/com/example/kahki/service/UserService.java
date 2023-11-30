package com.example.kahki.service;

import com.example.kahki.dao.MemberDao;
import com.example.kahki.dto.MemberDto;

public class UserService {

    public boolean comparePassword(String userId, String loginPW) {

        MemberDao memberDao = new MemberDao();
        MemberDto member = memberDao.getMemberById(userId);

        if (member.getUser_pw().equals(loginPW)) {
            return true;
        }
        return false;
    }

    public boolean compareId(String userId, String loginId) {

        MemberDao memberDao = new MemberDao();
        MemberDto member = memberDao.getMemberById(userId);

        if (member.getUser_id().equals(loginId)) {
            return true;
        }
        return false;
    }


}
