package com.test.test03.board.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Setter
@Getter
@ToString
public class BoardDTO {
	private int articleNo;
	private String title;
	private String content;
	private Date writeDate;
	private String id;
}
