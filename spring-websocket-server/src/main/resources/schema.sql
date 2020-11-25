-- 사용자 아이디
CREATE TABLE USER (
    user_id VARCHAR(255) NOT NULL COMMENT '사용자 아이디',
    PRIMARY KEY(user_id)
);

-- 방
CREATE TABLE ROOM (
    seq VARCHAR(255) NOT NULL COMMENT '방 키',
    name VARCHAR(255) NOT NULL COMMENT '방 이름',
    pwd VARCHAR(255) NULL COMMENT '방 비밀번호',
    state_secret TINYINT(1) NULL DEFAULT 0 COMMENT '비밀방 여부(0 일반방, 1 비밀방)',
    state_delete TINYINT(1) NULL DEFAULT 0 COMMENT '삭제 여부(0 삭제 안됨, 1 삭제 됨)',
    create_date DATETIME NOT NULL COMMENT '생성된 날짜',
    delete_date DATETIME NULL COMMENT '삭제된 날짜',
    PRIMARY KEY(seq)
);

-- 채팅
CREATE TABLE ROOM_CHAT (
    room_seq VARCHAR(255) NOT NULL COMMENT '방 키',
    seq INT NOT NULL COMMENT '채팅 키',
    user_id VARCHAR(255) NOT NULL COMMENT '사용자 아이디',
    description TEXT NOT NULL COMMENT '내용',
    state_delete TINYINT(1) NULL DEFAULT 0 COMMENT '삭제 여부(0 삭제 안됨, 1 삭제 됨)',
    create_date DATETIME NOT NULL COMMENT '생성된 날짜',
    PRIMARY KEY(room_seq, seq)
);