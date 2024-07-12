plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
}

application {
    // Define the main class for the application.
    mainClass = "it.unicam.cs.mgc.TheClothesProjectConfigurator.App"
}
