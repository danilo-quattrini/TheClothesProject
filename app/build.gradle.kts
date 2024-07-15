plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation("org.apache.jena:jena-arq:5.0.0")
    implementation("org.apache.jena:jena-core:5.0.0" )
    implementation("com.github.galigator.openllet:openllet-jena:2.6.5")
    implementation("com.github.galigator.openllet:openllet-owlapi:2.6.5")

}

application {
    // Define the main class for the application.
    mainClass = "it.unicam.cs.mgc.TheClothesProjectConfigurator.App"
}
