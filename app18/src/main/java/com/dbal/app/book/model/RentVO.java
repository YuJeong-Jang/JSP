package com.dbal.app.book.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RentVO {
	private Integer rentNo;
	private Integer bookNo;
	private Integer rentPrice;
	private Date rentDate;
	private String rentStatus;
}
