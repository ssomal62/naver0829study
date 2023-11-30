package study.spring.project01;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MyshopDto {

    private String sangpum;
    private String color;
    private int price;
    private String ipgoday;
    private MultipartFile photo;
    private String filename;

}
