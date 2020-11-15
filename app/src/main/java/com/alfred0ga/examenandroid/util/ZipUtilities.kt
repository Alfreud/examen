package com.alfred0ga.examenandroid.util

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

/**
 * Utility class providing methods for handling zip archives.
 *
 * @author Konstantin Kopper
 */
object ZipUtilities {
    /**
     * Unzips an archive contained as a resource to a given directory.
     * Inspired by [this tutorial on mkyong.com](https://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/).
     *
     * @param name The name of the archive included as a resource to be unzipped.
     *             The format has to be the same as for getResource().
     *
     * @param target The directory to which the content of the archive should be written.
     */
    @JvmStatic
    fun unzipResource(name: String, target: File) {
        if (!target.exists()) {
            target.mkdir()
        }

        assert(target.isDirectory)

        val buffer = ByteArray(1024)

        val inputStream = ZipInputStream(ZipUtilities::class.java.getResourceAsStream(name))

        try {
            while (true) {
                val entry: ZipEntry = inputStream.nextEntry ?: break
                val fileName = entry.name
                val entryFile = File(target.absolutePath + File.separator + fileName)

                FileOutputStream(entryFile).use { out ->
                    var len: Int = 0
                    while ({ len = inputStream.read(buffer); len }() > 0) {
                        out.write(buffer, 0, len)
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}