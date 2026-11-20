group = "app.morphe.patches.pixelcamera.gallery"
version = "0.1.4"

patches {
    about {
        name = "Pixel Camera – Immich"
        description = "Adds a setting to open the Pixel Camera thumbnail in Immich."
        source = "https://github.com/0xJohnnyboy/Pixel-Camera"
        author = "0xJohnnyboy"
        contact = "na"
        website = "https://github.com/0xJohnnyboy/Pixel-Camera"
        license = "GPLv3"
    }
}

val patchListGeneratorClasspath = configurations.create("patchListGeneratorClasspath")

dependencies {
    compileOnly(libs.gson)
    compileOnly(libs.morphe.patcher)
    compileOnly(libs.smali)
    patchListGeneratorClasspath(libs.gson)
}

sourceSets.main {
    resources.exclude("TomteInitHelper.dex")
}

tasks.named("jar") { finalizedBy("buildAndroid") }
tasks.named("assemble") { dependsOn("buildAndroid") }
