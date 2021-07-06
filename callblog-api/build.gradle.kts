dependencies {
    implementation(project(":callblog-domain"))
    //DB
    runtimeOnly("com.h2database:h2")

    implementation("org.springframework.boot:spring-boot-starter-web")
    //validation
    implementation("org.springframework.boot:spring-boot-starter-validation")
    //jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
