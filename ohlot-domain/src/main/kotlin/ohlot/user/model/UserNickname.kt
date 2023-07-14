package ohlot.user.model

import ohlot.user.model.exception.InvalidUserFormatException
import java.io.Serializable

private val VALID_NICKNAME_REGEX = Regex("^[\\w|가-힣|ㄱ-ㅎ|ㅏ-ㅣ]{1,10}$")

data class UserNickname(val value: String) : Serializable {
    init {
        if (!VALID_NICKNAME_REGEX.matches(value)) throw InvalidUserFormatException()
    }
}
