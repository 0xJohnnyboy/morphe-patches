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

### Pixel 10 photo saving and optional cloning

[Add Akshayykadam’s Pixel Camera patches to Morphe](https://morphe.software/add-source?github=Akshayykadam/Pixel-Camera)

**Pixel 10 Photo Saving Fix** is a separate upstream patch from [Akshayykadam/Pixel-Camera](https://github.com/Akshayykadam/Pixel-Camera/releases). Select it from that source if this Pixel Camera build fails to save captures on your Pixel 10 or 10 Pro. The Immich patch works independently and does not bundle the fix.

On our Pixel 10 Pro, a clone-only build reproduced the saving failure without Immich installed as a patch. With **Pixel 10 Photo Saving Fix** enabled alongside the Immich patch, photos saved successfully. This test covered the cloned build.

**Pixel Camera Clone (Non-Root)** is another optional patch from the upstream source. It changes the package to `com.google.android.GoogleCamera.morphe` so the patched APK can be installed alongside the Google-signed app. Enable it only for a side-by-side install.

To reproduce the tested setup in Morphe Manager, enable [Expert mode](https://github.com/MorpheApp/morphe-manager/blob/main/docs/patching-expert-mode.md), add both sources, and select **Pixel Camera Gallery Target Settings**, **Pixel 10 Photo Saving Fix**, and **Pixel Camera Clone (Non-Root)**. The tested upstream bundle version was `1.1.3`.

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
