plugins {
    id("java")
    id("org.flywaydb.flyway") version "10.13.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.flywaydb:flyway-core:10.13.0")
    implementation("com.h2database:h2:2.2.220")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}



tasks.test {
    useJUnitPlatform()
}