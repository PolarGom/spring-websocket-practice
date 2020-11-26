package kr.co.example.user.service;

import kr.co.example.common.CommonException;
import kr.co.example.user.dto.UserCreateRequest;
import kr.co.example.user.entity.User;
import kr.co.example.user.dao.IUserDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 사용자 서비스
 *
 * @author main
 * @see 2020-11-17
 * @see {@link IUserService}
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserDao userDaoImpl;

    @Override
    public void createUser(UserCreateRequest request) throws CommonException {

        try {

            log.info("생성 할 사용자 정보: {}", request.toString());

            userDaoImpl.save(User.builder()
                    .userId(request.getUserId())
                    .build());
        } catch ( Exception e ) {

            throw new CommonException(e, "사용자 생성 중 오류가 발생하였습니다.");
        }
    }

    @Override
    public void deleteUser(String id) throws CommonException {

        try {

            log.info("삭제 할 사용자 아이디: {}", id);

            User user = userDaoImpl.findById(id).orElseThrow(() -> {
                String errMsg = "아이디가 존재하지 않습니다.";

                return new CommonException(new NullPointerException(errMsg), errMsg);
            });

            userDaoImpl.delete(user);
        } catch ( CommonException e ) {

            throw e;
        } catch ( Exception e ) {

            throw new CommonException(e, "사용자 삭제 중 오류가 발생하였습니다.");
        }
    }
}
