package ohlot.account.model.exception

private const val MSG:String = "잘못된 패스워드를 입력하였습니다."

class InvalidPasswordException : RuntimeException(MSG)
