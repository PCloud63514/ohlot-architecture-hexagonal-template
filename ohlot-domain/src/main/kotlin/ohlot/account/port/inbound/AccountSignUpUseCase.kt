package ohlot.account.port.inbound

import ohlot.account.model.LoginId
import ohlot.account.model.LoginPassword

interface AccountSignUpUseCase {
    fun signUpLoginAccount(loginId: LoginId,
                           password: LoginPassword,
                           nickname: String)
}
