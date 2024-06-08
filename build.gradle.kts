plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.zaxxer:HikariCP:5.1.0")
    compileOnly("org.projectlombok:lombok:1.18.32")
    implementation("org.postgresql:postgresql:42.7.3")
}

tasks.test {
    useJUnitPlatform()
}