package ohlot.account.service

import ohlot.account.helper.AccountTestHelper
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class AccountSignUpServiceTest : AccountTestHelper() {
    @InjectMocks
    private lateinit var accountSignUpService: AccountSignUpService

    @DisplayName("계정을 저장합니다.")
    @Test
    fun signUpAccount_passes_entity_to_port() {
        val givenSecureId = "givenSecureId"
        val givenNickname = "givenNickname"
        Mockito.`when`(mockAccountPort.obtainSecureId()).thenReturn(givenSecureId)

        accountSignUpService.signUpAccount(givenNickname)

        verify(mockAccountPort, times(1)).save(capture(accountCaptor))
        assertThat(accountCaptor.value).isNotNull
        assertThat(accountCaptor.value.secureId.value).isEqualTo(givenSecureId)
        assertThat(accountCaptor.value.profile.nickname.value).isEqualTo(givenNickname)
    }

    @DisplayName("계정 생성 결과")
    @Test
    fun signUpAccount_return_value() {
        val givenSecureId = "givenSecureId"
        Mockito.`when`(mockAccountPort.obtainSecureId()).thenReturn(givenSecureId)

        val result = accountSignUpService.signUpAccount("givenNickname")

        assertThat(result).isEqualTo(givenSecureId)
    }
}
