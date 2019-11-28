package id.masekas.doku.listener

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  ErrorListener.kt
 * (='v')  0.1.0 @ 28 Nov 2019
 * (")(")
 *
 *   Mas Eka Setiawan
 *   github.com/ekamekas
 * ================================================
 */

import java.lang.Exception

/**
 * Interface of error listener
 */
interface ErrorListener {

    /**
     * Will be fired when error occurs
     *
     * @param o_O error
     */
    fun onError(o_O: Exception)

}