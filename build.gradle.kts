plugins {
    id("java")
    id("org.sonarqube") version "4.2.1.3168"
    id("org.owasp.dependencycheck") version "7.3.0"
    jacoco
}

sonar{
    properties{
        property("sonar.projectKey", "BakedGoodSorting")
        property("sonar.projectName", "BakedGoodSorting")
        property("sonar.host.url", "http://localhost:9000")
        println("Sonarqube token " + System.getenv("SONARQUBE_TOKEN"))
        property("sonar.token", System.getenv("SONARQUBE_TOKEN"))
        property("sonar.dependencyCheck.htmlReportPath", "dependency-check-report.html")
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.owasp:dependency-check-gradle:8.4.0")
    implementation(group = "javax.servlet", name = "javax.servlet-api", version = "3.1.0")
    //implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:4.2.1.3168")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport{
    dependsOn(tasks.test)

    reports {
        //xml.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
        xml.required.set(true)
        csv.required.set(false)
        html.required.set(false)
    }
}

jacoco {
    toolVersion = "0.8.9"
    reportsDirectory.set(layout.buildDirectory.dir("customJacocoReportDir"))
}

tasks.jar {
    manifest {
        attributes(
                "Main-Class" to "Main"
        )
    }
}

apply(plugin = "org.owasp.dependencycheck")