package co.yj.prj.member.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
 //@NoArgsConstructor //빈 생성자

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String hobby;
	private String author;
	private String state;

	private String check; // 로그인 or 검색 상태를 체크함

}
