package com.example.myapplication.util.system.lang

import android.content.res.AssetManager
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

object FileUtils {

    fun copyAssets(assetManager: AssetManager, filename: String, outFile: File) {
        val `in`: InputStream
        val out: OutputStream
        try {
            `in` = assetManager.open(filename)
            out = FileOutputStream(outFile)
            copyFile(`in`, out)
            `in`.close()
            out.flush()
            out.close()
        } catch (e: IOException) {
            Timber.e(e, "Failed to copy asset file: $filename")
        }
    }

    private fun copyFile(`in`: InputStream, out: OutputStream) {
        val buffer = ByteArray(1024)
        var read: Int
        while (`in`.read(buffer).also { read = it } != -1) {
            out.write(buffer, 0, read)
        }
    }

}
