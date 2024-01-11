package myshop.mapper;


import myshop.data.MyShopDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyShopMapper {

    // 방법 #1 : 쿼리를 직접 작성
    //@Select("SELECT COUNT(*) FROM myshop")
    //public int getTotalCount();

    // 방법 #2 : 쿼리를 xml에서 작성
    public int getTotalCount();

    @Insert("""
            INSERT INTO myshop (sangpum, color, photo, price, writeday)
            VALUES (#{sangpum}, #{color}, #{photo}, #{price}, NOW())
            """)
    public void insertShop(MyShopDto dto);

    @Select("SELECT * FROM myshop ORDER BY num desc")
    public List<MyShopDto> getSangpumList();

    //xml 연결
    public MyShopDto getData(int num);

    @Delete("DELETE FROM myshop WHERE num = #{num}")
    public void delete(int num);

}
