package com.anthony.mykeyboard

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.View

class MyKeyboardService : InputMethodService(), KeyboardView.OnKeyboardActionListener {

    private lateinit var keyboardView: KeyboardView
    private lateinit var keyboard: Keyboard
    private var isSymbols = false

    override fun onCreateInputView(): View {
        try {
            keyboardView = layoutInflater.inflate(R.layout.keyboard_view, null) as KeyboardView
            keyboard = Keyboard(this, R.xml.simple_keyboard)
            keyboardView.keyboard = keyboard
            keyboardView.setOnKeyboardActionListener(this)
            return keyboardView
        } catch (e: Exception) {
            e.printStackTrace()
            return View(this) // fallback so IME doesn't crash
        }
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val ic = currentInputConnection

        when (primaryCode) {

            -5 -> ic.deleteSurroundingText(1, 0)

            -2 -> { // Letters → Symbols1
                keyboard = Keyboard(this, R.xml.symbols_keyboard_1)
                keyboardView.keyboard = keyboard
                return
            }

            -12 -> { // Symbols1 → Symbols2
                keyboard = Keyboard(this, R.xml.symbols_keyboard_2)
                keyboardView.keyboard = keyboard
                return
            }

            -10 -> { // Symbols2 → Letters
                keyboard = Keyboard(this, R.xml.simple_keyboard)
                keyboardView.keyboard = keyboard
                return
            }

            else -> ic.commitText(primaryCode.toChar().toString(), 1)
        }
    }


    override fun onPress(primaryCode: Int) {}
    override fun onRelease(primaryCode: Int) {}
    override fun onText(text: CharSequence?) {}
    override fun swipeLeft() {}
    override fun swipeRight() {}
    override fun swipeDown() {}
    override fun swipeUp() {}
}
