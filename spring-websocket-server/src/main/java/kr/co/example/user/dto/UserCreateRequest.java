package kr.co.example.user.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 사용자 생성 요청
 *
 * @author main
 * @since 2020-11-17
 */
@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserCreateRequest {

    @NotBlank(message = "아이디를 입력해 주세요.")
    @Pattern(regexp = "[a-zA-Z1-9]{6,12}", message = "아이디는 영문 및 숫자로 포함해서 1 ~ 50자리 이내로 입력해 주세요.")
    private String userId;
}
