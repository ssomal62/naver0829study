package mini.dao;

import mini.dto.GuestDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestDao {

    @Autowired
    private SqlSession session;

    private String nameSpace = "mini.dao.GuestDao.";

    public List<GuestDto> getAllGuestBook(){
        return session.selectList(nameSpace + "selectAllGuest");
    }

    public void insertGuest(GuestDto dto){
        session.insert(nameSpace + "insertGuest",dto);
    }
    public void deleteGuest(int guest_num){
        session.delete(nameSpace + "deleteGuest", guest_num);
    }
}
