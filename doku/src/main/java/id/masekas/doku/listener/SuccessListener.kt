package id.masekas.doku.listener

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  SuccessListener.kt
 * (='v')  0.1.0 @ 28 Nov 2019
 * (")(")
 *
 *   Mas Eka Setiawan
 *   github.com/ekamekas
 * ================================================
 */

import java.io.File

/**
 * Interface of success listener
 */
interface SuccessListener {

    /**
     * Will be fired when process is success
     *
     * @param file file of the document
     */
    fun onSuccess(file: File)
}