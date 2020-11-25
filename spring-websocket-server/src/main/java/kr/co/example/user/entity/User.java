package kr.co.example.user.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 사용자 엔티티
 *
 * @author main
 * @since 2020-11-17
 */
@Entity
@Table(name = "USER")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @NonNull
    private String id;

    @NonNull
    private String name;
}
