plugins {
    id("com.android.application")
}

android {
    namespace = "com.principal.botonmisterioso"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.principal.botonmisterioso"
        minSdk = 24
        targetSdk = 33
        versionCode = 3
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // Define signingConfigs before referencing it in buildTypes
    signingConfigs {
        create("release") {
            storeFile = file("C:/Users/SISPRO3/OneDrive/Escritorio/FirmaDesarrollosPatito.jks")
            storePassword = "Papacolin2"
            keyAlias = "DesarrollosPatito"
            keyPassword = "Papacolin2"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true // Enable code obfuscation and optimization
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.google.android.gms:play-services-ads:22.5.0")
}
