package com.vasy.security.dto;

import lombok.Data;

@Data
public class UsersDto {
	private long userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private int userAge;

}
