/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.text

// actually \s is enough to match all whitespace, but \xA0 added because of different regexp behavior of Rhino used in Selenium tests
public actual fun Char.isWhitespace(): Boolean = toString().matches("[\\s\\xA0]")

@kotlin.internal.InlineOnly
public actual inline fun Char.toLowerCase(): Char {
    val lowerCase: String = js("String.fromCharCode")(toInt()).toLowerCase()
    return if (lowerCase.length == 1) lowerCase[0] else this
}

@kotlin.internal.InlineOnly
public actual inline fun Char.toUpperCase(): Char {
    val upperCase: String = js("String.fromCharCode")(toInt()).toUpperCase()
    return if (upperCase.length == 1) upperCase[0] else this
}

/**
 * Returns `true` if this character is a Unicode high-surrogate code unit (also known as leading-surrogate code unit).
 */
public actual fun Char.isHighSurrogate(): Boolean = this in Char.MIN_HIGH_SURROGATE..Char.MAX_HIGH_SURROGATE

/**
 * Returns `true` if this character is a Unicode low-surrogate code unit (also known as trailing-surrogate code unit).
 */
public actual fun Char.isLowSurrogate(): Boolean = this in Char.MIN_LOW_SURROGATE..Char.MAX_LOW_SURROGATE
