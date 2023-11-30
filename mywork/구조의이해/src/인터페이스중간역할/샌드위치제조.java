package 인터페이스중간역할;

public class 샌드위치제조 {

	public static void main(String[] args) {
		
		레시피작성 recipe = new 레시피작성();
		
		샌드위치 cooking1 = recipe.오픈샌드위치레시피(샌드위치::new);  	
		샌드위치 cooking2 = recipe.일반샌드위치레시피(샌드위치::new);
		
		System.out.println(cooking1);
		System.out.println(cooking2);
	}

}
