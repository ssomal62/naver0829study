package mycar.repository;

import mycar.data.MyCarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long> {

    //직접 쿼리문을 이용해서 수정하는 메서드를 추가

    // 1. 자동차명, 가격, 색상만 수정하는 메서드만들기

    //nativeQuery = true : JPA에서 지정한 규칙을 모두 무시할 수 있는 속성

    @Query(value =
            """
                UPDATE mycar SET carname=:carname, carprice=:carprice, carcolor=:carcolor
                WHERE num=:num
            """, nativeQuery = true)
    @Modifying
    @Transactional
    public void updateMyCarNoPhoto(Long num,
                                   String carname,
                                   int carprice,
                                   String carcolor
    );


    @Modifying
    @Query(value =
            """ 
            UPDATE mycar SET carname=:#{#dto.carname}, carprice=:#{#dto.carprice}, carcolor=:#{#dto.carcolor} 
            WHERE num=:#{#dto.num} 
            """, nativeQuery = true)
    @Transactional
    void updateMycarDtoNoPhoto(MyCarDto dto);
}
