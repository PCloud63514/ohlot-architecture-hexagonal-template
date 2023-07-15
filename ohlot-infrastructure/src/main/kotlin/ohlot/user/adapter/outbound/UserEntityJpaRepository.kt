package ohlot.user.adapter.outbound

import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
internal interface UserEntityJpaRepository : JpaRepository<UserEntity, Long> {
    fun findByPublicId(publicId:String): Optional<UserEntity>
    fun findBySecureId(secureId:String): Optional<UserEntity>
    fun findByNicknameLike(nickname:String, pageable: Pageable)
}
