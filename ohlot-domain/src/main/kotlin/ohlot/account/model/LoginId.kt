package ohlot.account.model

import ohlot.account.model.exception.InvalidUserAccountFormatException

private val VALID_LOGIN_ID_REGEX = Regex("^(?=.*[a-z|A-Z])[a-z|A-Z|0-9]{5,20}\$")

data class LoginId(val value:String) {
    init {
        if (!VALID_LOGIN_ID_REGEX.matches(value)) throw InvalidUserAccountFormatException()
    }
}
