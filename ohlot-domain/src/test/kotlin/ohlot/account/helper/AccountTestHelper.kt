package ohlot.account.helper

import ohlot.account.model.Account
import ohlot.account.port.AccountPort
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
abstract class AccountTestHelper {
    @Mock
    lateinit var mockAccountPort: AccountPort
    @Captor
    lateinit var accountCaptor: ArgumentCaptor<Account>

    @BeforeEach
    fun setUp() {
        Mockito.lenient().`when`(mockAccountPort.obtainSecureId()).thenReturn("TEST")
    }

    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()

    fun <T> any(): T {
        Mockito.any<T>()
        return null as T
    }
}
