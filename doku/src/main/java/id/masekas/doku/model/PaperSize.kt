package id.masekas.doku.model

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  PaperSize.kt
 * (='v')  0.1.0 @ 28 Nov 2019
 * (")(")
 *
 *   Mas Eka Setiawan
 *   github.com/ekamekas
 * ================================================
 */

import id.masekas.doku.constant.Unit

/**
 * Model of paper size of the document
 *
 * @param width width of the document
 * @param height height of the document
 * @param unit measurement unit of the size
 *
 * @see Unit
 */
data class PaperSize(val width: Float, val height: Float, @Unit.Constant val unit: String) {

    /**
     * Convert size of the model to inch measurement unit
     */
    fun toInch(): PaperSize {
        return when(unit) {
            Unit.PX -> PaperSize(width * MM_INCH_RATIO, height * MM_INCH_RATIO, Unit.INCH)
            Unit.PS -> PaperSize(width / INCH_PS_RATIO, height / INCH_PS_RATIO, Unit.INCH)
            else -> this
        }
    }

    /**
     * Convert size of the model to measure spec measurement unit (1/72 inch)
     */
    fun toMeasureSpec(): PaperSize {
        return when(unit) {
            Unit.INCH -> PaperSize(width * INCH_PS_RATIO, height * INCH_PS_RATIO, Unit.PS)
            else -> this.toInch().toMeasureSpec()
        }
    }

    companion object {
        val A4 = PaperSize(210F, 297F, Unit.PX)
        val F4 = PaperSize(210F, 330F, Unit.PX)

        private const val MM_INCH_RATIO = 0.03937F
        private const val INCH_PS_RATIO = 72
    }

}