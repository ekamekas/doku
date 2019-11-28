package id.masekas.doku.constant

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  Constant.kt
 * (='v')  0.1.0 @ 28 Nov 2019
 * (")(")
 *
 *   Mas Eka Setiawan
 *   github.com/ekamekas
 * ================================================
 */

import androidx.annotation.StringDef

/**
 * Library level constants
 */
object Doku {
    const val TAG = "DOKU"
}

/**
 * Measurement Unit
 */
object Unit {
    const val PX = "PX"
    const val INCH = "INCH"
    const val PS = "PS"

    /**
     * Anotation of Unit enums
     */
    @StringDef(PX, INCH, PS)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Constant
}