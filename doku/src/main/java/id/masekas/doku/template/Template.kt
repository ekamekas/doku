package id.masekas.doku.template

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  Template.kt
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
 * View template to inflate
 */
abstract class Template {

    internal lateinit var mView: View

    /**
     * Resource of template
     */
    abstract fun setResource(): Int

    /**
     * Populating data to the template
     *
     * @param view inflated view to be populated
     */
    abstract fun bindView(view: View)

    /**
     * Inflate layout
     *
     * @param context context of application
     * @param paperSize document size
     *
     * @return inflated view
     *
     * @see PaperSize
     */
    internal abstract fun inflate(context: Context, paperSize: PaperSize): View

    /**
     * Layout template to the view
     *
     * @param paperSize document size
     *
     * @see PaperSize
     */
    internal abstract fun layout(paperSize: PaperSize)

}