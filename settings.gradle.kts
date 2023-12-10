import java.net.URI

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            version("compose", "1.5.3")
            version("compose-activity", "1.8.0")
            version("composeTetManifest", "1.6.0-alpha07")
            version("hilt", "2.48")
            version("material3", "1.1.2")
            version("kotlinBom", "1.8.0")
            version("kotlinCoroutines", "1.6.1")
            version("junitKtx", "1.1.5")
            version("junit", "4.13.2")
            version("test-espresso", "3.5.1")
            version("navigation", "2.7.5")


            library("compose-ui", "androidx.compose.ui", "ui").versionRef("compose")
            library("compose-ui-tooling", "androidx.compose.ui", "ui-tooling").versionRef("compose")
            library("compose-ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").versionRef("compose")
            library("compose-ui-graphics", "androidx.compose.ui", "ui-graphics").versionRef("compose")
            library("compose-ui-test", "androidx.compose.ui", "ui-test-junit4").versionRef("compose")
            library("compose-ui-test-manifest", "androidx.compose.ui", "ui-test-manifest").versionRef("compose")
            library("compose-activity", "androidx.activity", "activity-compose").versionRef("compose-activity")

            bundle("compose", listOf("compose-ui", "compose-ui-tooling", "compose-ui-tooling-preview" , "compose-ui-graphics" , "compose-ui-test",
                "compose-ui-test-manifest","compose-activity"))

            library("hilt", "com.google.dagger", "hilt-android").versionRef("hilt")
            library("hilt-compiler", "com.google.dagger", "hilt-android-compiler").versionRef("hilt")
            bundle("hilt", listOf("hilt", "hilt-compiler"))

            library("material3", "androidx.compose.material3", "material3").versionRef("material3")

            library("junit", "junit", "junit").versionRef("junit")

            library("kotlin-bom", "org.jetbrains.kotlin", "kotlin-bom").versionRef("kotlinBom")
            library("kotlin-coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("kotlinCoroutines")
            bundle("kotlin", listOf("kotlin-bom", "kotlin-coroutines"))

            library("test-ktx", "androidx.test.ext", "junit-ktx").versionRef("junitKtx")
            library("test-espresso", "androidx.test.espresso", "espresso-core").versionRef("test-espresso")
            bundle("test", listOf("test-ktx", "test-espresso"))

            library("navigation", "androidx.navigation", "navigation-compose").versionRef("navigation")
            library("navigation-test", "androidx.navigation", "navigation-testing").versionRef("navigation")
            bundle("navigation", listOf("navigation", "navigation-test"))
        }
    }
}

rootProject.name = "TrainingApp"
include(":app")
include(":domain")
include(":data:authorization")
