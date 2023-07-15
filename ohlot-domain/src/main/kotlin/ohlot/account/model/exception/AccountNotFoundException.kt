package ohlot.account.model.exception

private const val MSG:String = "요청한 인증 정보를 찾지 못했습니다."

class AccountNotFoundException : RuntimeException(MSG)
