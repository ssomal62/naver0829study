package mini.service;

import lombok.AllArgsConstructor;
import mini.dao.GuestDao;
import mini.dto.GuestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestBookService {


    private GuestDao guestDao;

    public List<GuestDto> getAllGuestBook(){
        return guestDao.getAllGuestBook();
    }

    public void insertGuest(GuestDto dto){
        guestDao.insertGuest(dto);
    }
    public void deleteGuest(int guest_num){
        guestDao.deleteGuest(guest_num);
    }

}
