package id.zelory.compressor.constraint

import java.io.File

/**
 * 约束
 */
 interface Constraint {
    /**
     * 是否满足
     */
    fun isSatisfied(imageFile: File): Boolean

    /**
     * 使满足
     */
    fun satisfy(imageFile: File): File
}