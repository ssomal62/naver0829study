package bit701.day0914;


class Box<T>{
    private  T content;
    public void setContent(T content){
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class Ex2_Generics {

    public static void main(String[] args) {

        Box<String> box1 = new Box<>();
        box1.setContent("Hello 방가방가");
        System.out.println(box1.getContent());

        Box<Double> box2 = new Box<Double>();
        box2.setContent(23.8);
        System.out.println(box2.getContent());

    }


}
