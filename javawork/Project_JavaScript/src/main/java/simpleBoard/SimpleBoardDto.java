package simpleBoard;

import java.sql.Timestamp;

public class SimpleBoardDto {

    private String num;
    private String writer;
    private String subject;
    private String content;
    private String photo;
    private int readcount;
    private Timestamp writeday;

    public String getNum() {
        return num;
    }

    public String getWriter() {
        return writer;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getPhoto() {
        return photo;
    }

    public int getReadcount() {
        return readcount;
    }

    public Timestamp getWriteday() {
        return writeday;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    public void setWriteday(Timestamp writeday) {
        this.writeday = writeday;
    }
}
