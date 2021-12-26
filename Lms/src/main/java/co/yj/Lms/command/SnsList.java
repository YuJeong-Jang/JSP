package co.yj.Lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.Lms.sns.service.SnsService;
import co.yj.Lms.sns.serviceImpl.SnsServiceImpl;
import co.yj.Lms.sns.vo.SnsVO;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// SNS List 가져오기
		SnsService snsDao = new SnsServiceImpl();
		List<SnsVO> list = new ArrayList<SnsVO>();
		list = snsDao.snsSelectlist();
		request.setAttribute("list", list);
		return "main/snsList";
	}

}
