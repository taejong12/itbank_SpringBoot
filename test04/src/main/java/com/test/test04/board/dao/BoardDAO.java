package com.test.test04.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.test04.board.dto.BoardDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BoardDAO {
	// EntityManager를 주입받기 위한 어노테이션
	// EntityManager 는 JPA에서 데이터베이스와의 연결 및 쿼리 실행을 담당
	@PersistenceContext
	private EntityManager em;
	
	public List<BoardDTO> boardList(){
		// select b from Board b -> JPA의 JPQL 쿼리. Board는 @Entity(name="Board")에서 지정한 이름
		// 여기서 Board는 실제 DB 테이블 이름 "board"와 다름 -> JPA는 @Entity(name="Board")에 정의된 엔티티 이름을 JPQL에서 사용함
		// BoardDTO.class -> 반환할 객체 타입 (BoardDTO)
		// getResultList() -> 결과를 리스트 형태로 가져옴
		return em.createQuery("select b From Board b", BoardDTO.class)
				.getResultList();
	}
}