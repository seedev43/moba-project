#!/bin/bash
./gradlew installDebug || exit $?
$ANDROID_SDK_ROOT/platform-tools/adb -s emulator-5556 shell am start -a android.intent.action.MAIN -n com.ourteam.project1/.MainActivity
$ANDROID_SDK_ROOT/platform-tools/adb -s emulator-5556 logcat *:S com.ourteam.project1:D