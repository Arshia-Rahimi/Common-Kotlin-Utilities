plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.github.arshiarahimi.common"
    compileSdk = 36
    
    defaultConfig {
        minSdk = 26
        
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        versionCode = 1
        versionName = "0.1.0"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
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
    // media3
    implementation(libs.media3.ui)
    implementation(libs.media3.exoplayer)
    implementation(libs.media3.exoplayer.dash)
    implementation(libs.media3.session)
    implementation(libs.media3.hls)
}