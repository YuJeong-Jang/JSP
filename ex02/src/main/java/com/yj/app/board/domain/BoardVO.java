package com.yj.app.board.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class BoardVO {
//number(10,0)이므로 int가 아닌 long으로 설정
	private long bno; // 게시글 번호
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date regDate; // 작성일자
	@JsonIgnore // 이 필드는 json 적용 안함
	private Date updateDate; // 수정일자
	private int replycnt;

	//게시글하나에 있는 첨부파일 리스트를 가져올거임
	List<BoardAttachVO> attachList;
}
