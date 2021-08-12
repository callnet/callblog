dependencies {
    implementation(project(":callblog-domain"))
    //DB
    runtimeOnly("com.h2database:h2")

    // spring
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    //validation
    implementation("org.springframework.boot:spring-boot-starter-validation")
    //jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
