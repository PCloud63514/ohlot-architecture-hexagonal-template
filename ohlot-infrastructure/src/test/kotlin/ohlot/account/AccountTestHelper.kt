package ohlot.account

import ohlot.account.port.outbound.AccountPort
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
abstract class AccountTestHelper {
    @Mock
    lateinit var mockAccountPort:AccountPort

    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
}
