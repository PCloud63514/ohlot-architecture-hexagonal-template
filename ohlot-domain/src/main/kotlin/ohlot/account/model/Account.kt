package ohlot.account.model

import ohlot.identifier.AccountSecureId

class Account(
    val secureId: AccountSecureId,
    val profile: Profile
)
