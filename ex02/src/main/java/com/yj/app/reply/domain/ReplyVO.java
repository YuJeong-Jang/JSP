package com.yj.app.reply.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReplyVO {
private long rno;
private long bno;
private String reply;
private String replyer;
@JsonFormat(pattern = "yyyy/MM/dd")
private Date replyDate;
private Date updateDate;
}