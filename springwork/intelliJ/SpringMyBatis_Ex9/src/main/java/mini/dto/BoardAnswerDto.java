package mini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardAnswerDto {
    private int ansidx;
    private int num;
    private String ansname;
    private String ansid;
    private String ansphoto;
    private String ansmsg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Timestamp writeday;
}
