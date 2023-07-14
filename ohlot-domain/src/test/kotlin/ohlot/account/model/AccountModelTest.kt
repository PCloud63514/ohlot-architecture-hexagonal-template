package ohlot.account.model

import ohlot.account.model.exception.InvalidUserAccountFormatException
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class AccountModelTest {
    @DisplayName("LoginId 정규식 예외처리 검사")
    @CsvSource(
            "!@#!@$", // 특수문자
            "qwe12#", // 특수문자
            "12345678910", // 영문자 미포함
            "qqqqqqqqqq11111111111", // 21 글자
    )
    @ParameterizedTest
    fun generated_LoginId_throw_InvalidUserAccountFormat_exception(loginId:String) {
        assertThat(catchThrowableOfType({
            LoginId(loginId)
        }, InvalidUserAccountFormatException::class.java)).isNotNull()
    }

    @DisplayName("LoginPassword 정규식 예외처리 검사")
    @CsvSource(
            "12345678910!", // 영문자 미포함
            "Qwe1234567", // 특수문자 미포함
            "Qwe12!!", // 8 글자 미만
            "Qwe12345678910!@#123123123123r", // 25 글자 초과
            "Qqwenm182-", // !@#$%^&*()/?~ 외 특수문자 안
    )
    @ParameterizedTest
    fun generated_LoginPassword_throw_InvalidUserAccountFormat_exception(loginPassword:String) {
        assertThat(catchThrowableOfType({
            LoginPassword(loginPassword)
        }, InvalidUserAccountFormatException::class.java)).isNotNull()
    }
}
