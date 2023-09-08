package com.spring.mvcboard.reply.domain;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
	
	 private Integer replyNo;
	 private Integer articleNo;
	 private String replyText;
	 private String replyWriter;
	 private Date regDate;
	 private Date updateDate;

}
