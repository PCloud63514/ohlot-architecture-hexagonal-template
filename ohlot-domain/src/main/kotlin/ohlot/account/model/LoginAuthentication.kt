package ohlot.account.model

class LoginAuthentication(
        val accountSecureId: AccountSecureId,
        val loginId: LoginId,
        val password: LoginPassword
)
