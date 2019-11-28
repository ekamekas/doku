package id.masekas.doku.document

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  PDFDocumentCreator.kt
 * (='v')  0.1.0 @ 28 Nov 2019
 * (")(")
 *
 *   Mas Eka Setiawan
 *   github.com/ekamekas
 * ================================================
 */

import android.graphics.pdf.PdfDocument
import android.util.Log
import android.view.View
import java.io.File

/**
 * Create document to PDF file from template
 */
class PDFDocumentCreator: DocumentCreator() {

    /**
     * Generate document to PDF file from pages
     */
    override fun generateDocument(pages: List<View>, file: File) {
        // Prepare to generate PDF
        val document = PdfDocument()
        // Build page
        pages.forEachIndexed { index, page ->
            Log.d(id.masekas.doku.constant.Doku.TAG, "Generate page ${index + 1}")
            val pageInfo = PdfDocument.PageInfo.Builder(page.measuredWidth, page.measuredHeight, index).create()
            val documentPage = document.startPage(pageInfo)
            page.draw(documentPage.canvas)
            document.finishPage(documentPage)
        }

        // Write content to file
        Log.d(id.masekas.doku.constant.Doku.TAG, "Prepare to write PDF to ${file.path}")
        document.writeTo(file.outputStream())  // Write to file
        document.close()
    }
}