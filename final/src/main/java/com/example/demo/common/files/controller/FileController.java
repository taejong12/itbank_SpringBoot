package com.example.demo.common.files.controller;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

@RestController
public class FileController {
	public static final String FILE_REPO = 
			"C:\\Users\\dbxow\\git\\itbank_SpringBoot\\final\\src\\main\\resources\\static\\image";
	
	@GetMapping("/files/{articleNo}/{fileName}")
	public ResponseEntity<Resource> downloadFile(
			@PathVariable("articleNo") String articleNo,
			@PathVariable("fileName") String fileName
			) throws Exception{
		
		// Paths.get(FILE_REPO) -> FILE_REPO 경로를 Path 객체로 만듦 (기본 디렉토리)
		// .resolve(articleNo) -> FILE_REPO/articleNo 폴더로 확장
		// .resolve(fileName) -> FILE_REPO/articleNo/fileName 으로 최종 경로 확장
		// filePath -> 최종 파일 경로 (Path 객체로 저장)
		Path filePath = Paths.get(FILE_REPO).resolve(articleNo).resolve(fileName);
		
		if(!Files.exists(filePath)) {
			throw new FileNotFoundException("파일을 찾을 수 없습니다.");
		}
		
		Resource resource = new UrlResource(filePath.toUri());
		
		// 한글 파일도 처리 가능
		String encodedFileName = UriUtils.encode(resource.getFilename(),
				StandardCharsets.UTF_8);
		// attachment -> 브라우저가 강제로 다운로드하도록 지시
		// filename="..." -> 파일명 명시 (구형 브라우저 호환용)
		// filename*=UTF-8'' -> UTF-8 인코딩된 파일명 (신형 브라우저 호환용)
		String contentDisposition = "attachment;filename=\""+encodedFileName +
				"\";filename*=UTF-8''" + encodedFileName;
		
		return ResponseEntity.ok()
				// 다운로드 헤더 추가 -> 다운로드 지시
				.header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
				// 바이너리 파일 (모든 파일형식 가능) -> 모든 종류의 파일 처리 가능하도록 설정
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				// 실제 파일 데이터 넣기 -> 실제 파일 내용 (Spring이 알아서 스트림으로 전송)
				.body(resource);
	}
}