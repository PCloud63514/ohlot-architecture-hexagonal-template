package ohlot.user.adapter.outbound

import ohlot.user.model.User
import ohlot.user.model.UserNickname
import ohlot.user.model.UserPublicId
import ohlot.user.model.UserSecureId
import ohlot.user.model.UserStateMessage
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.Table

@EntityListeners(AuditingEntityListener::class)
@Table(name = "OHLOT_USER",
        indexes = [
            Index(name = "IDX_USER_SECURE_ID", columnList = "secure_id"),
            Index(name = "IDX_USER_PUBLIC_ID", columnList = "public_id")
        ])
@Entity
internal class UserEntity(
        @Column(name = "secure_id", nullable = false, unique = true)
        val secureId: String,
        @Column(name = "public_id", nullable = false, unique = true)
        val publicId: String,
        @Column(name = "nickname", nullable = false)
        var nickname: String,
        @Column(name = "state_message")
        var stateMessage: String,
        @CreatedDate
        @Column(name = "created_at", nullable = false)
        val createdAt: LocalDateTime?=null,
        @LastModifiedDate
        @Column(name = "updated_at", nullable = false)
        val updatedAt: LocalDateTime?= null,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
)

internal fun User.toEntity() : UserEntity {
    return UserEntity(
            secureId = this.secureId.value,
            publicId = this.publicId.value,
            nickname = this.nickname.value,
            stateMessage = this.stateMessage.value,
    )
}

internal fun UserEntity.toUser() : User {
    return User(
            secureId = UserSecureId(this.secureId),
            publicId = UserPublicId(this.publicId),
            nickname = UserNickname(this.nickname),
            stateMessage = UserStateMessage(this.stateMessage)
    )
}
