package ohlot.account.model.exception

private const val MSG:String = "잘못된 계정 형식 입니다."

class InvalidUserAccountFormatException : RuntimeException(MSG)
