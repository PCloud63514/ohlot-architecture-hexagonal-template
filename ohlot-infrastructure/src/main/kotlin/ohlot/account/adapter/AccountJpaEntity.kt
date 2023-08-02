package ohlot.account.adapter

import ohlot.account.model.Account
import ohlot.account.model.Nickname
import ohlot.account.model.Profile
import ohlot.account.model.StateMessage
import ohlot.identifier.AccountSecureId
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
@Table(
    name = "OHLOT_ACCOUNT",
    indexes = [
        Index(name = "IDX_ACCOUNT_SECURE_ID", columnList = "secure_id"),
    ]
)
@Entity
internal class AccountJpaEntity(
    @Column(name = "secure_id", nullable = false, unique = true)
    val secureId: String,
    @Column(name = "nickname", nullable = false)
    var nickname: String,
    @Column(name = "state_message")
    var stateMessage: String,
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime? = null,
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)

internal fun Account.toEntity(): AccountJpaEntity {
    return AccountJpaEntity(
        secureId = this.secureId.value,
        nickname = this.profile.nickname.value,
        stateMessage = this.profile.stateMessage.value,
    )
}

internal fun AccountJpaEntity.toModel(): Account {
    return Account(
        secureId = AccountSecureId(this.secureId),
        profile = Profile(
            nickname = Nickname(this.nickname),
            stateMessage = StateMessage(this.stateMessage)
        )
    )
}
