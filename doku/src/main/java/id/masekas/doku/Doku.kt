package id.masekas.doku

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  Doku
 * (='v')  0.1.0 @ 28 Nov 2019
 * (")(")
 *
 *   Mas Eka Setiawan
 *   github.com/ekamekas
 * ================================================
 */

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import id.masekas.doku.document.DocumentCreatorFactory
import id.masekas.doku.listener.SuccessListener
import id.masekas.doku.listener.ErrorListener
import id.masekas.doku.model.PaperSize
import id.masekas.doku.template.PageTemplate
import id.masekas.doku.template.Template
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.util.*

/**
 * Build document based on template
 *
 * @param mContext context of application
 */
class Doku internal constructor(private val mContext: Context) {

    private var mHeader: Template? = null
    private var mContents: List<Template> = listOf()
    private var mFooter: Template? = null
    private var mSize: PaperSize = PaperSize.A4
    private var mFile: File? = null
    private var mSuccessListener: List<SuccessListener> = listOf()
    private var mErrorListener: List<ErrorListener> = listOf()

    // API function sets
    /**
     * Set header of each pages of the document
     */
    fun setHeader(header: Template): Doku {
        mHeader = header

        return this
    }

    /**
     * Add content of the document
     */
    fun addContent(content: Template): Doku {
        mContents = mContents.plus(content)

        return this
    }

    /**
     * Add content of the document
     */
    fun addContent(content: List<Template>): Doku {
        mContents = mContents.plus(content)

        return this
    }

    /**
     * Set footer of each pages of the document
     */
    fun setFooter(footer: Template): Doku {
        mFooter = footer

        return this
    }

    /**
     * Set paper size for the document
     * Default will be A4 size
     *
     * @see PaperSize
     */
    fun setPaperSize(paperSize: PaperSize): Doku {
        mSize = paperSize

        return this
    }

    /**
     * Set target file for the document
     * Default will set to app fileDir
     */
    fun setFile(file: File): Doku {
        mFile = file

        return this
    }

    /**
     * Add error listener
     *
     * @see ErrorListener
     */
    fun addOnErrorListener(listener: ErrorListener): Doku {
        mErrorListener = mErrorListener.plus(listener)

        return this
    }

    /**
     * Add success Listener
     *
     * @see SuccessListener
     */
    fun addOnSuccessListener(listener: SuccessListener): Doku {
        mSuccessListener = mSuccessListener.plus(listener)

        return this
    }

    /**
     * Start process to generate document based on template from builder
     */
    fun start() {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    // Prepare target file
                    val file = prepareFile()
                    if(!file.exists()) throw NoSuchFileException(file)

                    DocumentCreatorFactory.create()
                        .generateDocument(
                            context = mContext,
                            size = mSize,
                            file = file,
                            header = mHeader,
                            content = mContents,
                            footer = mFooter
                        )

                    withContext(Dispatchers.Main) {
                        mSuccessListener.forEach { it.onSuccess(file) }  // Fire listener
                    }
                } catch (o_O: Exception) {
                    Log.e(id.masekas.doku.constant.Doku.TAG, o_O.localizedMessage ?: "Error occurs")
                    withContext(Dispatchers.Main) {
                        mErrorListener.forEach { it.onError(o_O) }  // Fire listener
                    }
                }
            }
        }
    }
    // End of API sets

    // Get target file for document
    private fun prepareFile(): File {
        return mFile ?: File(mContext.filesDir, "DOKU_${UUID.randomUUID()}.pdf").also {
            mFile = it

            it.createNewFile()  // Create default file
        }
    }

    companion object {
        /**
         * Builder to create document
         *
         * @param context context of application
         */
        fun builder(context: Context): Doku = Doku(context)  // Builder
    }

}