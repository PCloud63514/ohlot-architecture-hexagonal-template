package ohlot.account.api

import ohlot.account.usecase.AccountSignUpCommand
import ohlot.account.usecase.AccountSignUpUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
internal class AccountSignUpApi(
    private val accountSignUpUseCase: AccountSignUpUseCase
) {
    @ResponseStatus(code=HttpStatus.CREATED)
    @PostMapping("accounts/guests")
    fun guestAccountSignUp(@RequestBody command: AccountSignUpCommand, servletResponse: HttpServletResponse)  {
        val account = accountSignUpUseCase.signUpAccount(command)
        servletResponse.addHeader("ACCOUNT-TOKEN", account)
    }
}
