package ohlot.account.port.outbound

import ohlot.account.model.LoginId

interface AccountPort {
    fun isLoginIdExists(loginId:LoginId):Boolean
}
