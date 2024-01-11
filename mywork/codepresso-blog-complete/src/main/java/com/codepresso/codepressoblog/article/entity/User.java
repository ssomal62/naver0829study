public class User {

    public Long id;
    public String name;
    public String email;
    public String password; //외부에 노출되서는 안 될 정보
    public DetailInformation detailInformation; //외부에 노출되서는 안 될 정보

    //비즈니스 로직, getter, setter 등 생략
}