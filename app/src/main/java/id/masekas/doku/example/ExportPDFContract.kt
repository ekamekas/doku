package id.masekas.doku.example

import id.masekas.doku.example.model.Customer
import id.masekas.doku.example.model.Merchant
import id.masekas.doku.example.model.Order
import id.masekas.doku.example.model.Product
import java.io.File

interface ExportPDFContract {
    interface View {
        fun attach(presenter: Presenter)
        fun onDataLoaded(file: File, order: Order, merchant: Merchant, customer: Customer, product: List<Product>)
        fun onProgressExport(current: Int, total: Int)
        fun onExportSuccess()
        fun onExportError()
    }

    interface Presenter {
        fun onAttach(view: View)
        fun loadData(file: File)
    }
}