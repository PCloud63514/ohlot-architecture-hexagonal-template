package ohlot.account.usecase

interface AccountSignUpUseCase {
    fun signUpAccount(command: AccountSignUpCommand) : String
}
