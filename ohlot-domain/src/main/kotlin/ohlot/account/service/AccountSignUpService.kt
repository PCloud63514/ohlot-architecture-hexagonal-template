package ohlot.account.service

import ohlot.account.model.Account
import ohlot.account.model.Nickname
import ohlot.account.model.Profile
import ohlot.account.model.StateMessage
import ohlot.account.port.AccountPort
import ohlot.account.usecase.AccountSignUpCommand
import ohlot.account.usecase.AccountSignUpUseCase
import ohlot.identifier.AccountSecureId
import org.springframework.stereotype.Service

@Service
internal class AccountSignUpService(
    private val accountPort: AccountPort
) : AccountSignUpUseCase {
    override fun signUpAccount(command: AccountSignUpCommand): String {
        val account = generate(command)
        accountPort.save(account)
        return account.secureId.value
    }

    private fun generate(command: AccountSignUpCommand): Account {
        return Account(
            secureId = AccountSecureId(accountPort.obtainSecureId()),
            profile = Profile(
                nickname = Nickname(command.nickname),
                stateMessage = StateMessage("")
            )
        )
    }
}

