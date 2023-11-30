package thisIsJava.chapter16;

public class Ex6_Member {
	private String id;
	private String name;
	
	
	public Ex6_Member(String id) {
		this.id = id;
	}
	
	public Ex6_Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ex6_Member [id=" + id + ", name=" + name + "]";
	}


	
}
