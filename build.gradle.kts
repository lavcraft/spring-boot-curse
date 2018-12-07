plugins {
    java
    id("org.springframework.boot") version ("2.1.1.RELEASE") apply (false)
}

allprojects {
    group = "org.spring.boot.test.curse"
    version = "1.0"

    repositories {
        jcenter()
    }
}

subprojects {
    apply(plugin = "java")

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dependencies {
        listOf(
                enforcedPlatform("org.springframework.boot:spring-boot-starter:2.1.1.RELEASE"),
                enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:Finchley.SR1"),
                "org.springframework:spring-context",
                "org.projectlombok:lombok:1.18.4"
        ).onEach(::implementation)

        listOf(
                platform("org.junit:junit-bom:5.3.2"),
                "org.junit.platform:junit-platform-launcher",
                "org.junit.jupiter:junit-jupiter-engine"
        ).onEach(::testRuntime)

        listOf(
                "org.junit.jupiter:junit-jupiter-api",
                "org.hamcrest:hamcrest-all:1.3",
                "org.springframework.boot:spring-boot-starter-test"
        ).onEach(::testImplementation)

        annotationProcessor("org.projectlombok:lombok:1.18.4")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.4")
    }

    tasks {
        test {
            useJUnitPlatform()
        }
    }
}

configure(subprojects - project(":common")) {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        listOf(
                project(":common"),
                "org.yaml:snakeyaml",
                "org.springframework.boot:spring-boot-starter",
                "org.springframework.boot:spring-boot-starter-web",
                "org.springframework.cloud:spring-cloud-starter-openfeign"
        ).onEach { implementation(it) }

        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }
}

configure(listOf(project(":assistant"))) {
    dependencies {
        listOf(
                "org.codehaus.groovy:groovy-templates:2.5.4",
                "org.springframework.boot:spring-boot-starter-data-jpa",
                "com.h2database:h2:1.4.194"
        ).onEach { implementation(it) }
    }
}
