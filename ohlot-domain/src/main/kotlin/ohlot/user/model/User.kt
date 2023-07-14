package ohlot.user.model

class User(
        val secureId: UserSecureId,
        val publicId: UserPublicId,
        val nickname: UserNickname,
        val stateMessage: UserStateMessage
)
