package ohlot.user.model

import ohlot.user.model.exception.InvalidUserFormatException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowableOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class UserModelTest {

    @DisplayName("User Nickname 정규식 예외처리 검사")
    @CsvSource(
            "!",
            "!@#!@$",
            "12345678910"
    )
    @ParameterizedTest
    fun generated_UserNickname_throw_InvalidUserFormat_exception(nickname:String) {
        assertThat(catchThrowableOfType({
            UserNickname(nickname)
        }, InvalidUserFormatException::class.java)).isNotNull()
    }
}
