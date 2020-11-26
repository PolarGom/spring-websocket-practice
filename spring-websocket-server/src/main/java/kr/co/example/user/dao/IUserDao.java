package kr.co.example.user.dao;

import kr.co.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 사용자 리포지토리
 *
 * @author main
 * @since 2020-11-17
 * @see {@link JpaRepository}
 */
@Repository
public interface IUserDao extends JpaRepository<User, String> {
}
