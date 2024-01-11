package mycar.repository;


import lombok.AllArgsConstructor;
import mycar.data.MyCarDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarDao {

    //JpaRepository를 상속받을경우 기본적인 SQL을 실행해주는 각종 메서드 호출 가능
    MyCarDaoInter daoInter;

    //전체 갯수 구하기
    public Long getTotalCount() {
        return daoInter.count();
    }

    //db저장
    public void insert(MyCarDto dto) {
        //save : @Id 식별자가 form 안에 없으면 insert 실행, 있으면 update를 수행한다.
        daoInter.save(dto);
    }

    //전체출력
    public Page<MyCarDto> getAllCars(Pageable pageable) {
        //return daoInter.findAll();
        return daoInter.findAll(pageable); //페이지에 필요한만큼 데이터 반환
    }


//    //전체출력
//    public List<MyCarDto> getAllCars() {
//        //return daoInter.findAll();
//        return daoInter.findAll(Sort.by(Sort.Direction.DESC,"carprice")); //가격 내림차순 정렬
//    }

    public MyCarDto getData(Long num) {
        return daoInter.getReferenceById(num);
    }

    @Transactional
    public void delete(Long num) {
        daoInter.deleteById(num);
    }

    public void update(MyCarDto dto) {
        daoInter.save(dto);
    }

    public void updateMyCarNoPhoto(MyCarDto dto) {
//        Long num = dto.getNum();
//        String carname = dto.getCarname();
//        String carcolor = dto.getCarcolor();
//        int carprice = dto.getCarprice();
//
//        daoInter.updateMyCarNoPhoto(num, carname, carprice, carcolor);

        daoInter.updateMycarDtoNoPhoto(dto);
    }


}
