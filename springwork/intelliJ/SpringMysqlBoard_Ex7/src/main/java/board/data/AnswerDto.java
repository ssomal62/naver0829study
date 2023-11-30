package board.data;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class AnswerDto {

    private int idx;
    private int num;
    private String nickname;
    private String content;
    private Timestamp writeday;


}
