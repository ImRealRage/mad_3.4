plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.mad_34"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mad_34"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "2024.04.18:01:16::author:kanishk"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}