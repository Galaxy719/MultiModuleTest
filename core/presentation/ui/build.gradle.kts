plugins {
    alias(libs.plugins.multimodule.android.library.compose)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
}

android {
    namespace = "uz.developersdreams.core.presentation.ui"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.ui)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.kotlinx.serialization.json)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(projects.core.presentation.designsystem)
}