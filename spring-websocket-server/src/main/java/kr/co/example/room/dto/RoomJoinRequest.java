package kr.co.example.room.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 방 입장 요청
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
public class RoomJoinRequest {

    @NotEmpty(message = "방 키가 존재하지 않습니다.")
    private String seq;

    @Size(min = 1, max = 255, message = "비밀번호는 1 ~ 255자 이하 입니다.")
    @Builder.Default
    private String pwd = "";
}
