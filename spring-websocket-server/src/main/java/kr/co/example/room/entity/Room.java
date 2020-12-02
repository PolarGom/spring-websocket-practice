package kr.co.example.room.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 방 엔티티
 *
 * @author main
 * @since 2020-12-01
 */
@Entity
@Table(name = "Room")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Room {

    @Id
    private String seq;

    private String name;

    private String pwd;

    @Column(name = "state_secret")
    private boolean stateSecret;

    @Column(name = "state_delete")
    private boolean stateDelete;

    @CreatedDate
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;
}
