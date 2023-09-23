package com.spring.mvcboard.article.domain;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ArticleVO {

	private Integer articleNo;
    private String title;
    private String content;
    private String writer;
    private Timestamp regDate;
    private int viewCnt;
    private int replyCnt;
    
    // 파일업로드
    private String[] files;
    private int fileCnt;
    
}
