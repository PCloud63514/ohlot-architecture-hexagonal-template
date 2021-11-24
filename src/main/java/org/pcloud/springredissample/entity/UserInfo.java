package org.pcloud.springredissample.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_info")
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
//    @Column(name = "user_id", columnDefinition = "int unsigned, constraint sp_member_user_id_fk FOREIGN KEY (user_id) REFERENCES t_user(id) ON DELETE set null")// ON DELETE CASCADE
//    private Long userId;
//    private String msg;
}
