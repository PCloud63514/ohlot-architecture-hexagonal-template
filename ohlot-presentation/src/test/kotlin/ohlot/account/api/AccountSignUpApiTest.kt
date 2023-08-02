package ohlot.account.api

import ohlot.account.usecase.AccountSignUpUseCase
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
class AccountSignUpApiTest {
    private lateinit var mockMvc: MockMvc

    @InjectMocks
    private lateinit var accountSignUpApi: AccountSignUpApi

    @Mock
    private lateinit var mockAccountSignUpUseCase: AccountSignUpUseCase

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountSignUpApi).build()
    }

    @Test
    fun guestAccountSignUp_status_is_created() {
        mockMvc.perform(
            post("/accounts/guests")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                    {
                      "nickname": "nickname"
                    }
                    """
                )
        ).andExpect(status().isCreated)
    }

    @Test
    fun guestAccountSignUp_return_value() {
        Mockito.`when`(mockAccountSignUpUseCase.signUpAccount(any())).thenReturn("TEST")

        val response = mockMvc.perform(
            post("/accounts/guests")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    """
                    {
                      "nickname": "nickname"
                    }
                    """
                )
        ).andReturn().response

        assertThat(response.headerNames.contains("ACCOUNT-TOKEN")).isTrue()
    }

    fun <T> any(): T {
        Mockito.any<T>()
        return null as T
    }
}
