package ohlot.user.adapter.outbound

import ohlot.user.model.User
import ohlot.user.model.UserPublicId
import ohlot.user.model.UserSecureId
import ohlot.user.port.outbound.UserPort
import org.springframework.stereotype.Component
import java.util.Optional

@Component
internal class UserAdapter(
        private val userEntityJpaRepository: UserEntityJpaRepository
) : UserPort {
    override fun findBy(secureId: UserSecureId): Optional<User> {
        return userEntityJpaRepository.findBySecureId(secureId.value)
                .map(UserEntity::toUser)
    }

    override fun findBy(publicId: UserPublicId): Optional<User> {
        return userEntityJpaRepository.findByPublicId(publicId.value)
                .map(UserEntity::toUser)
    }

    override fun save(user: User) {
        userEntityJpaRepository.save(user.toEntity())
    }
}
