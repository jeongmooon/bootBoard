package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	private int id;
	private String userId;
	private String password;
	private Date regDate;
}
