plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.training.app.data.authorization"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    flavorDimensions.add("type")
    productFlavors {
        create("api") {
            namespace = "com.training.app.data.authorization"
            dimension = "type"
            buildConfigField("boolean", "IS_MOCKED", false.toString())
        }

        create("mock") {
            namespace = "com.training.app.data.authorization"
            dimension = "type"
            buildConfigField("boolean", "IS_MOCKED", true.toString())
        }
    }

    buildFeatures {
        buildConfig = true
    }

}

dependencies {

    implementation(project(mapOf("path" to ":domain")))

    implementation(libs.kotlin.coroutines)

    implementation(libs.compose.activity)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    testImplementation(libs.test.coroutines)

    androidTestImplementation(libs.test.espresso)
    androidTestImplementation(libs.test.coroutines)
    androidTestImplementation(libs.test.junit)

}