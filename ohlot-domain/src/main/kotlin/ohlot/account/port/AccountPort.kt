package ohlot.account.port

import ohlot.account.model.Account

interface AccountPort {
    fun save(account: Account)
    fun obtainSecureId(): String
}
