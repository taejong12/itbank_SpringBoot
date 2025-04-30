-- 사용자 생성
CREATE USER c##boot IDENTIFIED BY 1234;

-- CONNECT: 사용자가 DB에 접속할 수 있는 권한
-- RESOURCE: 데이터를 생성, 수정, 삭제할 수 있는 권한
GRANT CONNECT, RESOURCE TO c##boot;

-- system 에서 유저 권한 줘야 에러 없이 DB 에 저장 가능
-- QUOTA : 테이블 공간 사용
ALTER USER c##boot DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

-------------------------------------------------------------------------

create sequence board_articleNo start with 1;

insert into board values(board_articleNo.nextval, '반갑습니다.처음뵙겠습니다.', 'hong', '안녕하세요', sysdate);
insert into board values(board_articleNo.nextval, '테스트 작성 글 입니다.', 'hong', '테스트글', sysdate);

commit;

create sequence file_imageNo start with 1;