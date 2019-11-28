package id.masekas.doku.example.repository

import id.masekas.doku.example.model.Customer

class CustomerDefaultRepository: Repository.Customer {

    override fun getCustomerByOrder(orderId: String): Customer {
        return Customer(
            name = "Laman",
            address = "Indonesia"
        )
    }
}