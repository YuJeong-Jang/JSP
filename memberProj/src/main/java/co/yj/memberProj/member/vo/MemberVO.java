package co.yj.memberProj.member.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
private String email;
private String name;
private String tel;
private Date birth;
private String addr;
@Override
public String toString() {
	return "MemberVO [email=" + email + ", name=" + name + ", tel=" + tel + ", birth=" + birth + ", addr=" + addr + "]";
}


}
