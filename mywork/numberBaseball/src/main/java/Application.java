import controller.GameController;


public class Application {

    static GameController controller = new GameController();

    public static void main(String[] args) {

        System.out.println("뭐가문제야");

        controller.run();

    }
}