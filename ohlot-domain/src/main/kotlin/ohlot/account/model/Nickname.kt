package ohlot.account.model

import ohlot.account.model.exception.InvalidAccountProfileFormatException
import java.io.Serializable

private val VALID_NICKNAME_REGEX = Regex("^[\\w|가-힣|ㄱ-ㅎ|ㅏ-ㅣ]{1,20}$")

data class Nickname(val value: String) : Serializable {
    init {
        if (!VALID_NICKNAME_REGEX.matches(value)) throw InvalidAccountProfileFormatException()
    }
}
