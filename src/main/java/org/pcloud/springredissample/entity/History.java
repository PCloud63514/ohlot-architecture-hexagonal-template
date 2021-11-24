package org.pcloud.springredissample.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "history")
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String publisherAdminId;
    private Long publisherUserId;
    @Column(name = "create_at", updatable = false, insertable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP not null")
    private LocalDateTime createAt;
}
