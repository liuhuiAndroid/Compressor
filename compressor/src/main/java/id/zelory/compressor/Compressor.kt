package id.zelory.compressor

import android.content.Context
import id.zelory.compressor.constraint.Compression
import id.zelory.compressor.constraint.default
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.coroutines.CoroutineContext

/**
 * Created on : January 22, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
object Compressor {
    suspend fun compress(
            context: Context,
            imageFile: File,
            coroutineContext: CoroutineContext = Dispatchers.IO,
            compressionPatch: Compression.() -> Unit = { default() }
    ) = withContext(coroutineContext) {
        // 收集约束条件
        val compression = Compression().apply(compressionPatch)
        // copy一份原图片
        var result = copyToCache(context, imageFile)
        // 对copy图片进行压缩
        compression.constraints.forEach { constraint ->
            while (constraint.isSatisfied(result).not()) {
                result = constraint.satisfy(result)
            }
        }
        return@withContext result
    }
}