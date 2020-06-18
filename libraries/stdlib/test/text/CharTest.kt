/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package test.text

import kotlin.test.*

class CharTest {
    @Test
    fun multiCharUpperCase() {
        val ffi = 'ﬃ'
        assertEquals("FFI", ffi.toString().toUpperCase())
        assertEquals(ffi, ffi.toUpperCase())
    }

    @Test
    fun equalsIgnoreCase() {
        val dzChars = listOf('ǳ', 'ǲ', 'Ǳ')
        for (c in dzChars) {
            assertEquals('ǳ', c.toLowerCase())
            assertEquals('Ǳ', c.toUpperCase())
        }

        for (c1 in dzChars) {
            for (c2 in dzChars) {
                assertTrue(c1.equals(c2, ignoreCase = true))
            }
        }
    }
}