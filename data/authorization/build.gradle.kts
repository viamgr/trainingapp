plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
        create("Api") {
            namespace = "com.training.app.data.authorization"
            dimension = "type"
            buildConfigField("boolean", "IS_MOCKED", false.toString())
        }

        create("Mock") {
            namespace = "com.training.app.data.authorization"
            dimension = "type"
            buildConfigField("boolean", "IS_MOCKED", true.toString())
        }
    }


}

dependencies {

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")

}