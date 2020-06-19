/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.dom

import org.w3c.dom.*
import kotlin.internal.LowPriorityInOverloadResolution
import kotlinx.dom.createElement
import kotlin.internal.InlineOnly

/**
 * Creates a new element with the specified [name].
 *
 * The element is initialized with the speicifed [init] function.
 */
@LowPriorityInOverloadResolution
@Deprecated(
    message = "This API is moved to another package, use 'kotlinx.dom.createElement' instead.",
    replaceWith = ReplaceWith("this.createElement(name, init)", "kotlinx.dom.createElement")
)
public fun Document.createElement(name: String, init: Element.() -> Unit): Element = createElement(name).apply(init)

/**
 * Appends a newly created element with the specified [name] to this element.
 *
 * The element is initialized with the speicifed [init] function.
 */
@LowPriorityInOverloadResolution
@Deprecated(
    message = "This API is moved to another package, use 'kotlinx.dom.appendElement' instead.",
    replaceWith = ReplaceWith("this.appendElement(name, init)", "kotlinx.dom.appendElement")
)
public fun Element.appendElement(name: String, init: Element.() -> Unit): Element =
    ownerDocument!!.createElement(name, init).also { appendChild(it) }

