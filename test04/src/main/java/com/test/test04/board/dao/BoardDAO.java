package com.test.test04.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.test04.board.dto.BoardDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BoardDAO {
	@PersistenceContext
	private EntityManager em;
	
	public List<BoardDTO> boardList(){
		return em.createQuery("select b From Board b", BoardDTO.class)
				.getResultList();
	}
}