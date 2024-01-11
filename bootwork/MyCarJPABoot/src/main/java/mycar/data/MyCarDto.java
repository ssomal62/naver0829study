package mycar.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "mycar")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyCarDto {

    @Id //각 엔터티를 구별할 수 있도록 식별 아이디를 갖도록 설계
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //자동으로 auto increment를 하기 위한 설정
    private Long num;

    @Column(name="carname", length = 30) //변수명과 동일할 경우 name 생략 가능
    private String carname;

    private int carprice;

    @Column(length = 20)
    private String carcolor;

    @Column(length = 30)
    private String carguip;

    @Column(length = 100)
    private String carphoto;

    @Column(updatable = false) //해당 컬럼은 수정시에 제외시킴
    @CreationTimestamp
    private Timestamp writeday;

    @Transient // 테이블의 컬럼으로는 생성되지 않고, 객체에섬난 사용가능한 멤버 변수
    private int commentcount;

    @Transient
    private String message;
}
