package kr.co.example.room.dto;

import kr.co.example.room.entity.Room;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 방 응답
 *
 * @author main
 * @see 2020-12-02
 */
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RoomResponse {

    private String seq;

    private String name;

    private boolean stateSecret;

    private LocalDateTime createDate;

    public static RoomResponse from(Room room) {

        return RoomResponse.builder()
                .seq(room.getSeq())
                .name(room.getName())
                .stateSecret(room.isStateSecret())
                .createDate(room.getCreateDate())
                .build();
    }

    public static List<RoomResponse> listFrom(List<Room> roomList) {

        return roomList.stream()
                .map(RoomResponse::from)
                .collect(Collectors.toList());
    }
}
