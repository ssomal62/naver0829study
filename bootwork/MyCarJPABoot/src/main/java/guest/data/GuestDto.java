package guest.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "guest")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int gnum;

    @Column(length = 100)
    private String photo;

    @Column(length = 1000)
    private String content;

    @Column
    private String nickName;

    @Column(updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeDay;



}
