package id.masekas.doku.template

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  ContentTemplate.kt
 * (='v')  0.1.0 @ 28 Nov 2019
 * (")(")
 *
 *   Mas Eka Setiawan
 *   github.com/ekamekas
 * ================================================
 */

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import id.masekas.doku.model.PaperSize

/**
 * The template of content, including header, footer, and the content it self
 */
abstract class ContentTemplate: Template() {

    override fun inflate(context: Context, paperSize: PaperSize): View {
        mView = LayoutInflater
            .from(context)
            .inflate(setResource(), null, false)
            .also {
                bindView(it)
            }
        return mView
    }

    override fun layout(paperSize: PaperSize) {
        mView.measure(
            View.MeasureSpec.makeMeasureSpec(paperSize.toMeasureSpec().width.toInt(), View.MeasureSpec.EXACTLY),  // Exactly document size
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)  // Height will be based on accumulative of children height
        )   // Measure view
        mView.layout(0, 0, mView.measuredWidth, mView.measuredHeight)  // Layout view
    }
}