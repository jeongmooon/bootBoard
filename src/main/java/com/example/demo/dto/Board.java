package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	private int id;
	private String title;
	private String contents;
	private Date createAt;
	private Date updateAt;
}
