plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //
    alias(libs.plugins.kotlin.serialization)
    id("maven-publish")
}

android {
    namespace = "com.github.arshiarahimi.common"
    compileSdk = 36
    
    defaultConfig {
        minSdk = 26
        
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    
    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlin {
        jvmToolchain(8)
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.Arshia-Rahimi"
                artifactId = "Common-Kotlin-Utilities"
                version = "0.1.13"
            }
        }
    }
}

dependencies {
    // compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    // android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.ui.android)
    //
    // navigation Compose
    implementation(libs.androidx.navigation.compose)
    //  serialization
    implementation(libs.kotlinx.serialization.json)
    // dataStore
    implementation(libs.datastore)
}