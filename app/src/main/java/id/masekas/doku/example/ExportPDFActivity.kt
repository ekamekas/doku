package id.masekas.doku.example

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.files.folderChooser
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import id.masekas.doku.Doku
import id.masekas.doku.example.model.Customer
import id.masekas.doku.example.model.Merchant
import id.masekas.doku.example.model.Order
import id.masekas.doku.example.model.Product
import id.masekas.doku.example.repository.CustomerDefaultRepository
import id.masekas.doku.example.repository.MerchantDefaultRepository
import id.masekas.doku.example.repository.OrderDefaultRepository
import id.masekas.doku.example.repository.ProductDefaultRepository
import id.masekas.doku.listener.ErrorListener
import id.masekas.doku.listener.SuccessListener
import id.masekas.doku.model.PaperSize
import id.masekas.doku.template.ContentTemplate
import id.masekas.doku.template.Template
import kotlinx.android.synthetic.main.activity_export_pdf.*
import java.io.File
import java.lang.Exception
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ExportPDFActivity : AppCompatActivity(), ExportPDFContract.View {

    private val presenter = ExportPDFPresenter(
        this,
        OrderDefaultRepository(),
        MerchantDefaultRepository(),
        CustomerDefaultRepository(),
        ProductDefaultRepository()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attach(presenter)

        setContentView(R.layout.activity_export_pdf)

        bvExport.setOnClickListener { runWithPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE) { openFileChooser() } }
    }

    override fun attach(presenter: ExportPDFContract.Presenter) {
        presenter.onAttach(this)
    }

    override fun onDataLoaded(
        file: File,
        order: Order,
        merchant: Merchant,
        customer: Customer,
        product: List<Product>
    ) {
        bvExport.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        Doku.builder(this)
            .setHeader(mapToHeader())  // Set header template
            .addContent(mapToOrder(order, merchant, customer))  // Add order content template
            .addContent(mapToProductTitle())  // Add product title content template
            .addContent(product.map { mapToProduct(it) })  // Add product content template
            .addContent(
                product
                    .map { it.price }
                    .reduce { acc, bigDecimal -> acc.plus(bigDecimal) }
                    .let { mapToOrderSummary(it) }
            )  // Add order summary content template
            .setFooter(mapToFooter())  // Set footer template
            .setFile(file)  // Set target file
            .setPaperSize(PaperSize.A4)  // Set document paper size
            .addOnSuccessListener(object: SuccessListener {
                override fun onSuccess(file: File) {
                    onExportSuccess()
                    bvExport.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
            })  // Add on success listener
            .addOnErrorListener(object: ErrorListener {
                override fun onError(o_O: Exception) {
                    onExportError()
                    bvExport.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
            })  // Add on error listener
            .start()  // Start process
    }

    override fun onProgressExport(current: Int, total: Int) {
        MaterialDialog(this)
    }

    override fun onExportSuccess() {
        Toast.makeText(this, "Export data success", Toast.LENGTH_SHORT).show()
    }

    override fun onExportError() {
        Toast.makeText(this, "Export data failed", Toast.LENGTH_SHORT).show()
    }

    private fun openFileChooser() {
        MaterialDialog(this).show {
            folderChooser { _, file ->
                presenter.loadData(File(file, "Doku Example.pdf").also { it.createNewFile() })
            }
        }
    }

    private fun mapToHeader(): Template {
        return object: ContentTemplate() {
            override fun setResource(): Int = R.layout.view_example_header

            override fun bindView(view: View) {
                view.findViewById<TextView>(R.id.headerTitle).text = "Transaction Receipt"
                view.findViewById<TextView>(R.id.headerDate).text = SimpleDateFormat(
                    "dd/mm/yyyy",
                    Locale.getDefault()
                ).format(
                    Date(System.currentTimeMillis())
                )
            }
        }
    }

    private fun mapToOrder(order: Order, merchant: Merchant, customer: Customer): Template {
        return object: ContentTemplate() {
            override fun setResource(): Int = R.layout.view_example_order

            override fun bindView(view: View) {
                view.findViewById<TextView>(R.id.tvOrderId).text = "#${order.id}"
                view.findViewById<TextView>(R.id.tvMerchantName).text = merchant.name
                view.findViewById<TextView>(R.id.tvMerchantAddress).text = merchant.address
                view.findViewById<TextView>(R.id.tvCustomerName).text = customer.name
                view.findViewById<TextView>(R.id.tvCustomerAddress).text = customer.address
            }
        }
    }

    private fun mapToProductTitle(): Template {
        return object: ContentTemplate() {
            override fun setResource(): Int = R.layout.view_example_product_title

            override fun bindView(view: View) {}
        }
    }

    private fun mapToProduct(product: Product): Template {
        return object: ContentTemplate() {
            override fun setResource(): Int = R.layout.view_example_product

            override fun bindView(view: View) {
                view.findViewById<TextView>(R.id.tvProductName).text = product.name
                view.findViewById<TextView>(R.id.tvProductDescription).text = product.description
                view.findViewById<TextView>(R.id.tvProductPrice).text = "Rp ${product.price.toInt()}"
            }
        }
    }

    private fun mapToOrderSummary(totalPrice: BigDecimal): Template {
        return object: ContentTemplate() {
            override fun setResource(): Int = R.layout.view_example_order_summary

            override fun bindView(view: View) {
                view.findViewById<TextView>(R.id.tvTotalPrice).text = "Rp ${totalPrice.toInt()}"
            }
        }
    }

    private fun mapToFooter(): Template {
        return object: ContentTemplate() {
            override fun setResource(): Int = R.layout.view_example_footer

            override fun bindView(view: View) {
                view.findViewById<TextView>(R.id.footerDate).text = """
                    Laman @ ${Calendar.getInstance().get(Calendar.YEAR)}
                """.trimIndent()
            }
        }
    }
}
