package id.masekas.doku.document

/* Doku - Android Document Templating
 * ================================================
 * (\__/)  DocumentCreatorFactory.kt
 * (='v')  0.1.0 @ 28 Nov 2019
 * (")(")
 *
 *   Mas Eka Setiawan
 *   github.com/ekamekas
 * ================================================
 */

/**
 * Factory of document creator
 */
class DocumentCreatorFactory {

    companion object {
        /**
         * Create document creator
         */
        fun create(): DocumentCreator {
            return PDFDocumentCreator()
        }
    }

}