package data.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShopDto {

    String name;
    String color;
    int ea;
    int price;

}
