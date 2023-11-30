package mini.dto;


import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class BoardDto {

    private int num;
    private String writer;
    private String myid;
    private String subject;
    private String content;
    private int readcount;
    private int regroup;
    private int restep;
    private int relevel;
    private List<String> photoNames;
    private Timestamp writeday;
    private int photoCount;
    private int acount; //댓글 갯수 저장할 변후
}
