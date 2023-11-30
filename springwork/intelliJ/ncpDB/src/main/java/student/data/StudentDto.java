package student.data;

import java.sql.Timestamp;

public class StudentDto {

    private int id;
    private String name;
    private int age;
    private String mbti;
    private String phone;
    private Timestamp date;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMbti() {
        return mbti;
    }

    public Timestamp getDate() {
        return date;
    }
}
