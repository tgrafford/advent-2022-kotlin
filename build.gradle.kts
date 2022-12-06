import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.22"
    id("me.champeau.jmh") version "0.6.8"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(platform("io.kotest:kotest-bom:5.5.4"))
    testImplementation("io.kotest:kotest-runner-junit5")
}

jmh {
    fork.set(3)
    warmupIterations.set(3)
    iterations.set(5)
    timeOnIteration.set("5s")
    timeUnit.set("ms")
}