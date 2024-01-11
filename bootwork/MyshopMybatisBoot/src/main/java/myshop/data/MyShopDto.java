package myshop.data;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("MyShopDto")
public class MyShopDto {
    private int num;
    private String sangpum;
    private String photo;
    private String color;
    private int price;
    private Timestamp writeday;


}