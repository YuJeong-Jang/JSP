package co.micol.member.vo;

public class MemberVO { // member table과 컬럼명 및 타입이 일치하도록
	private String id;
	private String password;
	private String name;
	private int age;
	private String hobby;
// 자바에서는 언더바로 네이밍안함 메소드나 변수에는 소문자, 연결문자면 대문자
// 우리가 안만들면 jvm이 만들어주긴하지만 이게 더 깔끔함

	public MemberVO() {
		// 생성자
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
