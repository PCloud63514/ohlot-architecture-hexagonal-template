package ohlot.account.model.exception

private const val MSG: String = "이미 존재하는 아이디 입니다."
class LoginIdExistsException: RuntimeException(MSG)
