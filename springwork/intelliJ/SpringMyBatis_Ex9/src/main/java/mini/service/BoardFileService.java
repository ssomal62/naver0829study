package mini.service;


import lombok.AllArgsConstructor;
import mini.dao.BoardFileDao;
import mini.dto.BoardFileDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardFileService {

    private BoardFileDao boardFileDao;

    public void insertPhoto(BoardFileDto dto){
        boardFileDao.insertPhoto(dto);
    }

    public List<String> getPhotoByNum(int num){
        return boardFileDao.getPhotoByNum(num);
    }

    public List<BoardFileDto> getFileDateByNum(int num) {
        return boardFileDao.getFileDateByNum(num);
    }

    public void deletePhoto(int idx){
        boardFileDao.deletePhoto(idx);
    }


}
