package mycar.repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarCommentDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarCommentDao {

    private MyCarCommentDaoInter myCarCommentDaoInter;

    public void insertComment(MyCarCommentDto dto) {
        myCarCommentDaoInter.save(dto);
    }

    public List<MyCarCommentDto> getMyCarCommentList(Long num) {
        return myCarCommentDaoInter.getMyCarCommentList(num);
    }

}
