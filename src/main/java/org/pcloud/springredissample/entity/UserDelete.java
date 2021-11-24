package org.pcloud.springredissample.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_delete")
@Entity
public class UserDelete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long originalId;
    private String name;

    @Builder
    public UserDelete(Long id, Long originalId, String name) {
        this.id = id;
        this.originalId = originalId;
        this.name = name;
    }
}
