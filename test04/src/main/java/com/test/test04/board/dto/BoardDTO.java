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

// 이 클래스가 JPA에서 관리할 엔티티 클래스임을 선언.
// 테이터베이스 테이블과 매핑됨
@Entity(name="Board")

// 실제 매핑될 테이블 이름 지정
@Table(name="board")

// Spring Bean으로 등록
@Component
@Setter
@Getter
@ToString
public class BoardDTO {
	// 해당 필드가 Primary Key 임을 지정
	@Id
	
	// 기본 키 생성 전략 설정. 여기선 SEQUENCE 전략을 사용
	// 시퀀스를 이용한 자동 번호 생성 방식
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="board_articleNo")
	
	// 실제 DB에 존재하는 시퀀스 이름
	// DB에 만들어져 있어야 함
	@SequenceGenerator(name="board_articleNo", sequenceName="board_articleNo", 
	allocationSize=1)
	private int articleNo;
	private String title;
	private String content;
	private Date writeDate;
	private String id;
}