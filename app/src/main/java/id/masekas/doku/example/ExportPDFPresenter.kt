package id.masekas.doku.example

import android.content.Context
import id.masekas.doku.example.repository.Repository
import java.io.File

class ExportPDFPresenter(
    private val context: Context,
    private val orderRepository: Repository.Order,
    private val merchantRepository: Repository.Merchant,
    private val customerRepository: Repository.Customer,
    private val productRepository: Repository.Product
): ExportPDFContract.Presenter {

    private lateinit var view: ExportPDFContract.View

    override fun onAttach(view: ExportPDFContract.View) {
        this.view = view
    }

    override fun loadData(file: File) {
        val order = orderRepository.getOrder()
        val merchant = merchantRepository.getMerchantByOrder(order.id)
        val customer = customerRepository.getCustomerByOrder(order.id)
        val product = productRepository.getProductByOrder(order.id)

        view.onDataLoaded(file, order, merchant, customer, product)
    }
}