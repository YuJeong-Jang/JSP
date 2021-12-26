package com.dbal.app.book.model;

import java.util.Date;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookVO {
	private Integer bookNo;
	private String bookName;
	private String bookCoverImg;
	private Date bookDate;
	@NumberFormat(pattern = "###,###")
	private Integer bookPrice;
	private String bookPublisher;
	private String bookInfo;
}
