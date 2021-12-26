package com.yj.app.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yj.app.board.domain.BoardAttachVO;
import com.yj.app.board.domain.BoardVO;

import lombok.extern.java.Log;

@Log
@Controller
public class UploadController {
	
	  @GetMapping("page2")
	  public ResponseEntity<BoardVO> page2(@RequestParam int h) {
	 //참고페이지 364
		  ResponseEntity<BoardVO> result = null;
		  if(h<10) {
			  result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BoardVO());
		  }else {
			  result = ResponseEntity.status(HttpStatus.OK).body(new BoardVO());
		  }
		  return result;
	 }
	
	
	
	@GetMapping("page1")
	public void page1(HttpServletResponse response) throws IOException {
		String mimeType = "application/xml";
		response.setContentType(mimeType);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<div>안녕하세요</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile) throws IllegalStateException, IOException {
//		multipartResolve -> jsp에 있는 form태그 내의 input 값을 알아서 가져와서 변수(uploadFile)에 넣어줌
		for (int i = 0; i < uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {
				String fileName = ufile.getOriginalFilename();
				String saveName = System.currentTimeMillis() + ""; // "" = toString();
				File file = new File("c:/upload", saveName);
				ufile.transferTo(file);
			}
		}
	}
	
	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public List<BoardAttachVO> uploadAjaxAction(MultipartFile[] uploadFile, BoardVO vo) throws IllegalStateException, IOException {
//	public boolean uploadAjaxAction(MultipartFile[] uploadFile, BoardVO vo) throws IllegalStateException, IOException {
//		multipartResolve -> jsp에 있는 form태그 내의 input 값을 알아서 가져와서 변수(uploadFile)에 넣어줌
//		log.info("boardVO==========" + vo);
//		for (int i = 0; i < uploadFile.length; i++) {
//			MultipartFile ufile = uploadFile[i];
//			if (!ufile.isEmpty() && ufile.getSize() > 0) {
//				String fileName = ufile.getOriginalFilename();
//				
//				log.info("file==========" + fileName);
//				
//				//String saveName = System.currentTimeMillis() + ""; // "" = toString();
////				File file = new File("c:/upload", saveName);
//				//중복파일명을 고유파일명으로 생성
//				UUID uuid = UUID.randomUUID();
//				File file = new File("c:/upload", uuid + fileName);
//				ufile.transferTo(file);
//			}
//		}
//		return true;
		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>();
		String path = "c:/upload";
		for (int i = 0; i < uploadFile.length; i++) {
			MultipartFile ufile = uploadFile[i];
			if (!ufile.isEmpty() && ufile.getSize() > 0) {
				String fileName = ufile.getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				File file = new File("c:/upload", uuid + fileName);
				ufile.transferTo(file);
				// 파일정보
				BoardAttachVO attachvo = new BoardAttachVO();
				attachvo.setUuid(uuid.toString());
				attachvo.setFileName(fileName);
				attachvo.setUploadPath(path);
				list.add(attachvo);
			}
		}
		return list;
	}
}
