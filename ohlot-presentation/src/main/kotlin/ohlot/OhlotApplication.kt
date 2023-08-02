package ohlot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OhlotApplication

fun main(args: Array<String>) {
    runApplication<OhlotApplication>(*args)
}
