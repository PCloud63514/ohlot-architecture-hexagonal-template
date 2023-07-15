package ohlot.account.model

import ohlot.account.model.exception.InvalidUserAccountFormatException

private val VALID_PASSWORD_REGEX = Regex("^(?=.*[A-Z])(?=.*[!@#\$%^&*()/?~])[a-z|A-Z|0-9|!@#\$%^&*()/?~]{8,25}\$")


data class LoginPassword(val value:String) {
    init {
        if (!VALID_PASSWORD_REGEX.matches(value)) throw InvalidUserAccountFormatException()
    }
}
