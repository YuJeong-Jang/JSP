package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// main.do 요청시 처리하는 곳
		// DB 작업
		// 결과
		//디스패쳐로 넘기기때문에
		return "Main/Home";
	}

}
