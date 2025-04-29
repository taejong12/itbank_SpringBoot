package com.test.test04.board.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="Board")
@Table(name="board")
@Component
@Setter
@Getter
@ToString
public class BoardDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="board_articleNo")
	@SequenceGenerator(name="board_articleNo", sequenceName="board_articleNo", 
	allocationSize=1)
	private int articleNo;
	private String title;
	private String content;
	private Date writeDate;
	private String id;
}