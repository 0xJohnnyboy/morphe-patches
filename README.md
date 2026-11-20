# Pixel Camera

[![Add to Morphe](https://img.shields.io/badge/Add%20to-Morphe%20Manager-4285f4?logo=android)](https://morphe.software/add-source?github=0xJohnnyboy/Pixel-Camera)

Open the last photo from the Pixel Camera thumbnail in [Immich](https://github.com/immich-app/immich).

The **Replace Google Photos with Immich** switch is at the end of **Settings → General**. It is off by default and translated into English and French. When enabled, tapping the thumbnail sends the media directly to Immich. Pixel Camera uses its original review flow when the switch is off, on the lock screen, or when Immich cannot open the media. Immich may briefly show its home screen before its viewer opens.

## Compatibility

- Target build: Pixel Camera `11.1.040.982810059.19` (version code `69703284`).
- The Immich patch keeps Pixel Camera’s name and package ID (`com.google.android.GoogleCamera`). It adds a package-visibility entry for Immich so Android can find its viewer.
- Tested in a cloned build on a Pixel 10 Pro with Immich 3.4.2.

## Use with Morphe

The badge points to this repository’s intended Morphe source. Remote installation requires a published Morphe bundle. Until one is available, import a locally built `.mpp` via **Sources → + → Local** in [Morphe Manager](https://github.com/MorpheApp/morphe-manager). Open the matching Pixel Camera APK or APKM and select **Pixel Camera Gallery Target Settings**. It includes the bytecode patch automatically.

## Build locally

Use JDK 21. Gradle resolves Morphe dependencies from GitHub Packages. Set `GITHUB_ACTOR` and `GITHUB_TOKEN`, or configure `gpr.user` and `gpr.key` in your user-level Gradle properties.

```sh
./gradlew :patches:build
```

Import `patches/build/libs/patches-0.1.0.mpp` into Morphe. Supply your own compatible Pixel Camera APK or APKM.

## Credits

- [Akshayykadam/Pixel-Camera](https://github.com/Akshayykadam/Pixel-Camera) provided a reference for settings injection and the optional patches used on the test device.
- [Paresh-Maheshwari/morphe-ai](https://github.com/Paresh-Maheshwari/morphe-ai) provided the APK analysis and patch development workflow.
- [Morphe Patcher](https://github.com/MorpheApp/morphe-patcher), [Morphe Manager](https://github.com/MorpheApp/morphe-manager), and [Morphe Desktop](https://github.com/MorpheApp/morphe-desktop) provide the patching toolchain.
- [google-pixel-camera-to-immich](https://github.com/skyracer2012/google-pixel-camera-to-immich) documented the Pixel Camera review intent and the Immich viewer entry point.
