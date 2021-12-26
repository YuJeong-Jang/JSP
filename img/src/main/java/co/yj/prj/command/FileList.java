package co.yj.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yj.prj.comm.Command;
import co.yj.prj.image.service.FileInforService;

public class FileList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 목록 가져오기
		FileInforService fileDao = new FileInforService();
		request.setAttribute("files", fileDao.FileSelectList());
		return "file/fileList";
	}

}
