plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

buildscript {
  repositories {
    google()
    mavenCentral()
  }

  dependencies {
    classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.10")
  }
}

android {
  namespace = "com.example.demo"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.example.demo"
    minSdk = 26
    targetSdk = 34
    vectorDrawables.useSupportLibrary = true
  }

  buildFeatures {
    viewBinding = true
  }

  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_17.toString()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

}

dependencies {
  implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))
  implementation("com.google.android.material:material:1.12.0")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  implementation("androidx.recyclerview:recyclerview:1.3.2")
  implementation("androidx.browser:browser:1.8.0")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
  implementation("com.github.bumptech.glide:glide:4.16.0")
  implementation("dev.hotwire:strada:1.0.0-beta3")
  implementation("dev.hotwire:turbo:7.1.3")
}

repositories {
  google()
  mavenCentral()
}
