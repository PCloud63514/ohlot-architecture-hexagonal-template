package ohlot.account.model.exception

private const val MSG:String = "사용자 정보가 잘못되었습니다."
class InvalidAccountProfileFormatException : IllegalArgumentException(MSG)
