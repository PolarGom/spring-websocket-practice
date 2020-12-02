package kr.co.example.room.service;

import kr.co.example.common.CommonException;
import kr.co.example.room.dto.RoomCreateRequest;
import kr.co.example.room.dto.RoomJoinRequest;
import kr.co.example.room.dto.RoomResponse;

import java.util.List;

/**
 * 방 서비스 인터페이스
 *
 * @author main
 * @see 2020-12-01
 */
public interface IRoomService {

    /**
     * 모든 방 목록 조회
     *
     * @return results 방 목록
     * @throws CommonException
     */
    List<RoomResponse> selectRoomList() throws CommonException;

    /**
     * 방 생성
     *
     * @param roomCreateRequest 방 생성 정보
     * @return result 방 생성 정보
     * @throws CommonException
     */
    RoomResponse createRoom(RoomCreateRequest roomCreateRequest) throws CommonException;

    /**
     * 방 입장
     *
     * @param roomJoinRequest 방에 입장 할 정보
     * @throws CommonException
     */
    void joinRoom(RoomJoinRequest roomJoinRequest) throws CommonException;
}
