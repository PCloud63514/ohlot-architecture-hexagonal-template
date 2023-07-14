package ohlot.user.port.outbound

import ohlot.user.model.User
import ohlot.user.model.UserPublicId
import ohlot.user.model.UserSecureId
import java.util.*

interface UserPort {
    fun findBy(secureId: UserSecureId) : Optional<User>
    fun findBy(publicId: UserPublicId) : Optional<User>
    fun save(user:User)
}
