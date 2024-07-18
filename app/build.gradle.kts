/*
 * Copyright (c) 2024 Danilo Quattrini
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

plugins {
    id("java")
    id("application")
}
group ="it.unicam.cs.mgc.TheClothesProjecConfigurator.app"
version = "1.0"

dependencies {
    implementation("org.apache.jena:jena-arq:4.8.0")
    implementation("com.github.galigator.openllet:openllet-jena:2.6.5")
    implementation("com.github.galigator.openllet:openllet-owlapi:2.6.5")
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    // Define the main class for the application.
    mainClass.set(/* value = */ "it.unicam.cs.mgc.TheClothesProjectConfigurator.App")
}


tasks.test {
    useJUnitPlatform()
}
repositories {
    mavenCentral()
}
tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
