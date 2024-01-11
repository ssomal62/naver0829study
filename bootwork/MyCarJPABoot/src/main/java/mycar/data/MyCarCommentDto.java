package mycar.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Timestamp;

/**
 * 은행 서비스에서 사용자(TABLE_USER)가 1개 이상의 계좌 (TABLE_ACCOUNT)를
 * 가질 수 있다고 가정할경우 TABLE_USER 입장에서 보면 OneToMany이고,
 * TABLE_ACCOUNT입장에서 보면 ManyToOne이다.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="mycar_comment")
public class MyCarCommentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment를 하기 위한 설정
    private int idx;

    @ManyToOne  //서브테이블에는 ManyToOne : 하나의 등록글에 여러개의 댓글을 달 수 있음.
    @JoinColumn(name="num") //외래키 설정 컬럼명 지정.
    @OnDelete(action = OnDeleteAction.CASCADE) //부모 데이터를 지우면 댓글도 삭제됨.
    private MyCarDto macar; //join 테이블 선언

    private String comment;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @Column(updatable = false) //수정 시 업데이트 제외
    @CreationTimestamp //엔터티가 생성되는 시점의 시간이 자동등록 == now()
    private Timestamp writeday;
}
