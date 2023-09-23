package com.spring.mvcboard.user.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	
	private String userId;
	private String userPw;
    private String userName;
    private String userEmail;
    private Timestamp userJoinDate;
    private Timestamp userLoginDate;
    private String userSignature;
    private String userImg;
    private int userPoint;

}
