package ohlot.user.model.exception

private const val MSG:String = "사용자 정보가 존재하지 않습니다."

class UserNotFoundException : RuntimeException(MSG)
