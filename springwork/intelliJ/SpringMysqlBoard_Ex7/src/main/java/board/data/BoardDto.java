package board.data;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardDto {

    private int num;
    private String writer;
    private String subject;
    private String content;
    private String photo;
    private int readcount;
    private Timestamp writeday;
    private int acount;

}
