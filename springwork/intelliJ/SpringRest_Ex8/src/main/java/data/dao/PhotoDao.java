package data.dao;


import data.dto.PhotoDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoDao {

    @Autowired
    SqlSession session;

    private String namespace = "data.dao.PhotoDao.";

    public void insertPhoto(PhotoDto dto){
        session.insert(namespace + "insertPhoto", dto);
    }

    public List<PhotoDto> getAllPhotos(){
        return session.selectList(namespace + "selectAllPhotos");
    }

    public void deletePhoto(int num){
        session.delete(namespace + "deletePhoto");
    }


}
