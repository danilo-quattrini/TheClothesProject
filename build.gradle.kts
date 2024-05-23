plugins {
    id("java")
}

group = "it.unicam.cs"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    //That's the implementation of the jena ARQ
    implementation("org.apache.jena:jena-arq:5.0.0")
    //That's the implementation of the jena CORE
    implementation("org.apache.jena:jena-core:5.0.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}