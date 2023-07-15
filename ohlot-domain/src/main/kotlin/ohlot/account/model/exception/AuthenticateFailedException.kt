package ohlot.account.model.exception

private const val MSG:String = "인증에 실패하였습니다."

class AuthenticateFailedException : RuntimeException(MSG)
