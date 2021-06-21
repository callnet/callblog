plugins {
    id("org.springframework.boot") version("2.5.1")  apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    java apply true
}


allprojects {

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    group = "callblog"
    version = "1.0.1"
    java.sourceCompatibility = JavaVersion.VERSION_1_8

    // project environment :  ex) prod : -Penv=prod
    val env = project.findProperty("env") ?: "local"
    sourceSets {
        main {
            resources {
                srcDir("src/main/resources")
                srcDir("src/main/resources-${env}")
            }
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")

        // test
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }

        // lombok
        compileOnly("org.projectlombok:lombok:1.16.18")
        annotationProcessor ("org.projectlombok:lombok:1.16.18")
        testAnnotationProcessor ("org.projectlombok:lombok:1.16.18")
        testImplementation ("org.projectlombok:lombok:1.16.18")

    }

    tasks.test {
        useJUnitPlatform()
    }
}


