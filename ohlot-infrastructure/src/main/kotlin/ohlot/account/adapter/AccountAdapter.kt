package ohlot.account.adapter

import ohlot.account.model.Account
import ohlot.account.port.AccountPort
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.Base64
import java.util.UUID

@Component
internal class AccountAdapter(
    private val accountJpaRepository: AccountJpaRepository
) : AccountPort {
    override fun save(account: Account) {
        accountJpaRepository.save(account.toEntity())
    }

    override fun obtainSecureId(): String = Base64.getEncoder().encodeToString(UUID.randomUUID().toString().toByteArray(StandardCharsets.UTF_8))
}
