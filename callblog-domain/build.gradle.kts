dependencies {
    //DB
    runtimeOnly("com.h2database:h2")
    //jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}
