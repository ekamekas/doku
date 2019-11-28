package id.masekas.doku.example.repository

import id.masekas.doku.example.model.Merchant

class MerchantDefaultRepository: Repository.Merchant {

    override fun getMerchantByOrder(orderId: String): Merchant {
        return Merchant(
            id = "000-023-040-23442",
            name = "Mas Eka Setiawan",
            address = "Indonesia"
        )
    }
}