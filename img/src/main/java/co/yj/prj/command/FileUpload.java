package co.yj.prj.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yj.prj.comm.Command;
import co.yj.prj.image.service.FileInforService;
import co.yj.prj.image.vo.FileInformationVO;

public class FileUpload implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 파일 업로드

		FileInformationVO vo = new FileInformationVO();
		FileInforService fileDao = new FileInforService();
		int maxFileSize = 1024 * 1024 * 100;
//		System.out.println(request.getParameter("subject"));

		try {
			MultipartRequest part = new MultipartRequest(request, "D:/temp/", maxFileSize, "utf-8",
					new DefaultFileRenamePolicy()); // request, 경로, 파일사이즈, 파일타입(한글파일도 깨지지 않게), 폴리시?
//			MultipartRequest part = new MultipartRequest(request, null, 0, "utf-8", new DefaultFileRenamePolicy());
			String upfileName = part.getFilesystemName("fileName"); // 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
			String orgfileName = part.getOriginalFileName("fileName"); // 업로드된 원본파일 이름을 구함(중복 처리 전 이름)

//			System.out.println(part.getParameter("subject"));
//			System.out.println(upfileName);
//			System.out.println(orgfileName);
			vo.setSubject(part.getParameter("subject"));
			vo.setFileName(orgfileName);
			vo.setDownFile(upfileName);

			int n = fileDao.fileInsert(vo);
			if (n != 0) {
				request.setAttribute("message", vo.getFileName() + "파일 업로드 성공");
			} else {
				request.setAttribute("message", orgfileName + "파일 업로드 실패"); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "file/fileUploadResult";
	}

}
