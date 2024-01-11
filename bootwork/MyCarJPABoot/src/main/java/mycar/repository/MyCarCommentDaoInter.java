package mycar.repository;

import mycar.data.MyCarCommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyCarCommentDaoInter extends JpaRepository<MyCarCommentDto, Integer> {

    //num에 해당하는 댓글 목록 출력하는 메서드를 직접 만들어보자

    @Query(value =
            "SELECT * FROM mycar_comment WHERE num =:num ORDER BY idx DESC",
            nativeQuery = true)
    public List<MyCarCommentDto> getMyCarCommentList(Long num);

}
