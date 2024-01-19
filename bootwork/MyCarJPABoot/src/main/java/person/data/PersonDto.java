package person.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pnum;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String photo;

    @Column(length = 5)
    private String mbti;

    private int age;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeDay;

}
