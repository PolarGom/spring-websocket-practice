package kr.co.example.user.controller;

import kr.co.example.CommonTest;
import kr.co.example.user.dto.UserCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 사용자 컨트롤러 테스트
 *
 * @author main
 * @since 2020-11-18
 * @see {@link CommonTest}
 */
public class UserControllerTest extends CommonTest {

    @DisplayName("사용자 생성 요청")
    @Test
    public void testCreateUser() throws Exception {

        String userId = "HelloWorld";

        String content = this.objectMapper.writeValueAsString(UserCreateRequest.builder()
                .userId(userId)
                .build());

        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(document("create-user",
                        requestFields(
                                fieldWithPath("userId").type(JsonFieldType.STRING).description("사용자 아이디")
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("성공 유무"),
                                fieldWithPath("errMsg").type(JsonFieldType.STRING).description("실패시 에러 메시지"),
                                fieldWithPath("body").type(JsonFieldType.OBJECT).description("성공에 대한 바디 정보").optional()
                        )
                ))
                .andExpect(status().isOk());
    }

    @DisplayName("사용자 생성 시 요청 바디를 누락하여 에러")
    @Test
    public void testFailEmptyBodyCreateUser() throws Exception {

        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errMsg").value("이름을 입력해 주세요."));

    }

    @DisplayName("사용자 생성 시 이름 정규식으로 인한 에러")
    @Test
    public void testFailRegexpCreateUser() throws Exception {

        String userId = "HelloWorld 안녕";

        String content = this.objectMapper.writeValueAsString(UserCreateRequest.builder()
                .userId(userId)
                .build());

        this.mockMvc.perform(RestDocumentationRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errMsg").value("아이디는 영문 및 숫자로 포함해서 1 ~ 50자리 이내로 입력해 주세요."));

    }

    @DisplayName("사용자 삭제")
    @Test
    public void testDeleteUser() throws Exception {

        String userId = "honggildong";

        this.mockMvc.perform(RestDocumentationRequestBuilders.delete("/users/{userId}", userId))
                .andDo(document("delete-user",
                        pathParameters(
                            parameterWithName("id").description("삭제 할 사용자 아이디")
                        ),
                        responseFields(
                                fieldWithPath("success").type(JsonFieldType.BOOLEAN).description("성공 유무"),
                                fieldWithPath("errMsg").type(JsonFieldType.STRING).description("실패시 에러 메시지"),
                                fieldWithPath("body").type(JsonFieldType.OBJECT).description("성공에 대한 바디 정보").optional()
                        ))
                )
                .andExpect(status().isOk());
    }

    @DisplayName("존재하지 않는 사용자 삭제")
    @Test
    public void testFailDeleteUser() throws Exception {

        String userId = "HelloWorld";

        this.mockMvc.perform(RestDocumentationRequestBuilders.delete("/users/{userId}", userId))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.errMsg").value("아이디가 존재하지 않습니다."));
    }
}
