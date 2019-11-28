package id.masekas.doku.document

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  DocumentCreator.kt
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
import android.widget.TextView
import id.masekas.doku.R
import id.masekas.doku.model.PaperSize
import id.masekas.doku.template.PageTemplate
import id.masekas.doku.template.Template
import java.io.File

abstract class DocumentCreator {

    private lateinit var mContext: Context
    private lateinit var mSize: PaperSize
    private var mHeader: Template? = null
    private var mContents: List<Template> = listOf()
    private var mFooter: Template? = null

    private val mPages = mutableListOf<View>()

    /**
     * Layout views to file document
     */
    abstract fun generateDocument(pages: List<View>, file: File)

    /**
     * Generate document from template
     *
     * @param context context of application
     * @param size size of document
     * @param file document file
     * @param header header of the page
     * @param content content of the page
     * @param footer footer of the page
     */
    fun generateDocument(
        context: Context,
        size: PaperSize,
        file: File,
        header: Template? = null,
        content: List<Template> = listOf(),
        footer: Template? = null
    ) {
        initData(context, size, header, content, footer)
        generatePages(mContents)  // Recursively generate pages
        generateDocument(mPages, file)
    }

    // Initialize data
    private fun initData(
        context: Context,
        size: PaperSize,
        header: Template? = null,
        content: List<Template> = listOf(),
        footer: Template? = null
    ) {
        mContext = context
        mSize = size
        mHeader = header
        mContents = content
        mFooter = footer
    }

    // Recursively generate page from view
    private fun generatePages(
        contents: List<Template>,
        currentPage: Int = 1,
        totalPage: Int = 1
    ) {
        if(contents.isEmpty()) return  // Base condition
        // Initialize
        val mTemplate = createPageTemplate().also { prepareTemplate(it) }  // Create new page from template
        var endIndex = 0  // Start index of current iteration
        mTemplate.mView.findViewById<ViewGroup>(R.id.pageContent).removeAllViews()  // Delete all views so page content start blank
        mTemplate.mView.findViewById<TextView>(R.id.pageNumber).text = currentPage.toString()
        // end of Initialize

        Log.d(id.masekas.doku.constant.Doku.TAG, "Prepare to build page content")
        contents.forEachIndexed { index, content ->
            content.inflate(mContext, mSize)  // Inflate content
            content.layout(mSize)  // Layout content
            mTemplate.layout(mSize)  // Layout template
            // Remaining space to add content
            val remainingHeight = mTemplate.mView.findViewById<View>(R.id.wrapperPageBody).height -
                    mTemplate.mView.findViewById<View>(R.id.pageHeader).height -
                    mTemplate.mView.findViewById<View>(R.id.pageContent).height
            if(content.mView.measuredHeight > remainingHeight) {  // If content is larger then remaining space
                return@forEachIndexed  // Return from iteration
            }

            // Add content to the template
            mTemplate.mView.findViewById<ViewGroup>(R.id.pageContent).apply {
                addView(content.mView, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            }

            endIndex = index  // Assign last iterated index
        }

        // Re-inflate so everything is in good shape
        mTemplate.layout(mSize)

        mPages.add(mTemplate.mView)

        generatePages(
            if(endIndex + 1 > contents.size) listOf() else contents.subList(endIndex + 1, contents.size),  // Prevent out of bound index for last iteration
            currentPage + 1,
            if(currentPage + 1 > totalPage) currentPage + 1 else totalPage
        )  // Call recursive function
    }

    // Prepare all views
    private fun prepareTemplate(template: PageTemplate) {
        inflateTemplate(template)  // Inflate the view
        // If there is no header, then hide
        if (mHeader == null) template.mView.findViewById<View>(R.id.pageHeader).apply {
            visibility = View.GONE
        }
        else {
            mHeader?.mView?.also { header ->
                if(header.measuredHeight > template.mView.measuredHeight) { // If header is has larger height then throw error since we cant write anything
                    throw RuntimeException("Header height has more height then template height")
                }
                template.mView.findViewById<ViewGroup>(R.id.pageHeader).apply {
                    addView(header, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                }
            }
        }
        // If there is no contents, then hide
        if(mContents.isEmpty()) {
            template.mView.findViewById<View>(R.id.pageContent).apply {
                visibility = View.GONE
            }
        }
        // If there is no footer, then hide
        if (mFooter == null) template.mView.findViewById<View>(R.id.pageFooter).apply {
            visibility = View.GONE
        }
        else {
            mFooter?.mView?.also { footer ->
                if(footer.measuredHeight > template.mView.measuredHeight) { // If header is has larger height then throw error since we cant write anything
                    throw RuntimeException("Header height has more height then template height")
                }
                template.mView.findViewById<ViewGroup>(R.id.pageFooter).apply {
                    addView(footer, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                }
            }
        }
    }

    // Inflating the template view
    private fun inflateTemplate(template: PageTemplate) {
        mHeader?.inflate(mContext, mSize)
        mHeader?.layout(mSize)
        mFooter?.inflate(mContext, mSize)
        mFooter?.layout(mSize)
        template.inflate(mContext, mSize)
        template.layout(mSize)
    }

    // Create new page from template
    private fun createPageTemplate(): PageTemplate {
        return object: PageTemplate() {
            override fun setResource(): Int = R.layout.page_template

            override fun bindView(view: View) {
                // No Op
            }
        }
    }

}