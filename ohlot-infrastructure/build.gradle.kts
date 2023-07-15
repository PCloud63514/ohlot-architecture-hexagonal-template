apply {
    plugin("kotlin-jpa")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation(project(":ohlot-domain"))
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}
