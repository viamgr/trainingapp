plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.training.app.trainingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.training.app.trainingapp"

        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    testOptions {
        packagingOptions {
            jniLibs {
                useLegacyPackaging = true
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    packaging {
        resources {
            resources.excludes.add("META-INF/*")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    flavorDimensions.add("type")
    productFlavors {
        create("api") {
        }

        create("mock") {
        }
    }

}

dependencies {
    implementation(platform(libs.kotlin.bom))

    implementation(libs.compose.ui)
    implementation(libs.compose.activity)
    implementation(libs.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.ui.graphics)

    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

    implementation(libs.test.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.test.espresso)
    androidTestImplementation(libs.test.ktx)
    androidTestImplementation(libs.compose.ui.test)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    androidTestImplementation(libs.navigation.test)
    implementation(libs.navigation)

    implementation(libs.kotlin.test)
    androidTestImplementation(libs.kotlin.test)


    testImplementation(libs.jupiter)
    testRuntimeOnly(libs.jupiter.engine)

    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data:authorization")))

    testImplementation(libs.test.mockk)
    androidTestImplementation(libs.test.mockk.android)
    testImplementation(libs.test.coroutines)
    testImplementation(libs.test.turbine)
    androidTestImplementation(libs.test.hilt)
}

kapt {
    correctErrorTypes = true
}