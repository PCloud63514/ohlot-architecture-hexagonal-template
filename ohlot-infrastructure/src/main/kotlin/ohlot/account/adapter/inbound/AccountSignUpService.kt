package ohlot.account.adapter.inbound

import ohlot.account.model.LoginId
import ohlot.account.model.LoginPassword
import ohlot.account.model.exception.LoginIdExistsException
import ohlot.account.port.inbound.AccountSignUpUseCase
import ohlot.account.port.outbound.AccountPort
import org.springframework.stereotype.Component

@Component
internal class AccountSignUpService(
        private val accountPort: AccountPort
) : AccountSignUpUseCase {
    override fun signUpLoginAccount(loginId: LoginId, password: LoginPassword, nickname: String) {
        // 아이디 중복 여부 검사
        if (accountPort.isLoginIdExists(loginId)) throw LoginIdExistsException()
        // 회원 정보 생성 요청
        // account 정보 생성
        // loginAuthentication 정보 생성
        // 저장 요청
        TODO("Not yet implemented")
    }
}
