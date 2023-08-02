package ohlot.account.adapter

import org.springframework.data.jpa.repository.JpaRepository

internal interface AccountJpaRepository : JpaRepository<AccountJpaEntity, Long> {
}
