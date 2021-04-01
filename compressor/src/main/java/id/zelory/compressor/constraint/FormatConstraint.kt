package id.zelory.compressor.constraint

import android.graphics.Bitmap
import id.zelory.compressor.compressFormat
import id.zelory.compressor.loadBitmap
import id.zelory.compressor.overWrite
import java.io.File

/**
 * 图片格式约束
 */
class FormatConstraint(private val format: Bitmap.CompressFormat) : Constraint {

    override fun isSatisfied(imageFile: File): Boolean {
        return format == imageFile.compressFormat()
    }

    override fun satisfy(imageFile: File): File {
        return overWrite(imageFile, loadBitmap(imageFile), format)
    }
}

fun Compression.format(format: Bitmap.CompressFormat) {
    constraint(FormatConstraint(format))
}