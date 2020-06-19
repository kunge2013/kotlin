/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.mpp

import org.gradle.api.Project
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.FileCollection
import org.gradle.api.file.ProjectLayout
import org.gradle.api.model.ObjectFactory
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilationOutput
import sun.misc.JavaxCryptoSealedObjectAccess
import java.io.File
import java.util.concurrent.Callable

class DefaultKotlinCompilationOutput(
    private val projectLayout: ProjectLayout,
    private val objectFactory: ObjectFactory,
    private val path: String,
    override var resourcesDirProvider: Any //TODO
) : KotlinCompilationOutput, Callable<FileCollection> {

    override val classesDirs: ConfigurableFileCollection = objectFactory.fileCollection()

    override val allOutputs = objectFactory.fileCollection().apply {
        from(classesDirs)
        from(Callable { resourcesDir })
    }

    override val resourcesDir: File
        //TODO
        get() {
            return projectLayout.projectDirectory.file(path).asFile
        }

    override fun call(): FileCollection = allOutputs
}