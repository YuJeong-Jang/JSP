package co.yj.prj.member.vo;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String hobby;
	private String author;
	private char state;
	// VO에는 테이블의 컬럼과 1:1로 상응되게 만들어야 한다.
	// 대소문자는 구분하지 않음(칼럼전체를 대문자로 쓰든, 칼럼전체를 소문자로 쓰든 한다)

	public MemberVO() {

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

}
