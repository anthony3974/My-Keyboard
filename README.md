# MyKeyboard Project

A simple custom Android Input Method Editor (IME) built with Kotlin, featuring a layout-based keyboard service and a Jetpack Compose testing activity.

---

## Components

### 1. `MyKeyboardService.kt`

The core keyboard service extending `InputMethodService`.

* **Dynamic Layouts:** Switches between alphabetic and symbol layers using specific `primaryCode` triggers (`-2`, `-12`, `-10`).
* **Input Handling:** Uses `InputConnection` to commit text or delete characters (`-5`).

### 2. `MainActivity.kt`

A Jetpack Compose-based UI for testing the keyboard.

* **Scaffold:** Implements Material3 design with edge-to-edge support.
* **MyScreen:** Provides a centered `TextField` to focus and test custom input.

---

## Setup

1. **Register Service:** Add `MyKeyboardService` to your `AndroidManifest.xml` with the `BIND_INPUT_METHOD` permission.
2. **Resources:** Ensure `R.layout.keyboard_view` and the XML keyboard definitions (`simple_keyboard`, `symbols_keyboard_1`, etc.) are present in your `res` folder.
3. **Enable Keyboard:** Activate in **Android Settings > Languages & input > On-screen keyboard**.
