dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    //h2 - local running
    runtimeOnly("com.h2database:h2")
    testRuntimeOnly("com.h2database:h2")

    implementation(project(":ohlot-domain"))
    implementation(project(":ohlot-infrastructure"))
}
