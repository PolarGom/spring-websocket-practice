package kr.co.example.room.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 방 생성 요청
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
public class RoomCreateRequest {

    @NotEmpty(message = "방 이름을 입력해 주세요.")
    @Size(min = 1, max = 255, message = "방 이름은 1 ~ 255자 이하 입니다.")
    private String name;

    @Size(min = 1, max = 255, message = "비밀번호는 1 ~ 255자 이하 입니다.")
    @Builder.Default
    private String pwd = "";

    @Builder.Default
    private boolean stateSecret = false;
}
