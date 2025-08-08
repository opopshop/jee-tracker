# JEE Tracker - Android (Kotlin + Jetpack Compose) Starter Project

This is a starter project scaffold for the JEE Tracker app you requested. It includes:
- Jetpack Compose screens (Dashboard, Log Study, Pomodoro, Manual Test Input)
- Room entities & DAOs (minimal)
- Notification helper and SyncService stub
- Pomodoro timer UI
- Multiple profiles support (DB-ready)
- Subject color scheme (Maths: Yellow, Physics: Blue, Chemistry: Red)

## How to use
1. Download and unzip the project.
2. Open the project in Android Studio (Electric Eel or later recommended).
3. Let Gradle sync. You may need to update Kotlin/Gradle plugin versions depending on your Android Studio setup.
4. Run on an emulator or device (minSdk 24).

## Notes
- This scaffold is intentionally minimal but functional. You will want to add:
  - Database initialization (Room.databaseBuilder in Application class)
  - Dependency injection (Hilt or manual) for Repository/ViewModel
  - Real persistence and UI bindings (ViewModels use repository)
  - Notification permission requests for Android 13+
  - Polishing UI animations and chart libraries (e.g., MPAndroidChart or ComposeCharts)
  - Export/import & backup code


---

## Quick commands to get a ready APK locally

If you want the APK for yourself immediately (one-command):

1. Unzip/Open project in terminal in project root (where `gradlew` is).
2. Make wrapper executable (Linux/macOS):

```bash
chmod +x ./gradlew
```

3. Build debug APK (no signing, ready to install):

```bash
./gradlew assembleDebug
```

4. After build, the APK is at:

```
app/build/outputs/apk/debug/app-debug.apk
```

5. Install via `adb`:

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

Or copy the APK to your phone and open it to install.


If you prefer automatic building via GitHub, push this project to a GitHub repo and GitHub Actions will create `app-debug` artifact on each push to `main` or when you run the workflow manually.
