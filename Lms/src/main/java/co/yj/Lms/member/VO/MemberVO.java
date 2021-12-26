package co.yj.Lms.member.VO;

public class MemberVO { // member table과 컬럼명 및 타입이 일치하도록
	private String id;
	private String password;
	private String name;
	private String author;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


}
