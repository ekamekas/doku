package id.masekas.doku.example.repository

import id.masekas.doku.example.model.Customer
import id.masekas.doku.example.model.Merchant
import id.masekas.doku.example.model.Order
import id.masekas.doku.example.model.Product

interface Repository {

    interface Merchant {
        fun getMerchantByOrder(orderId: String): id.masekas.doku.example.model.Merchant
    }

    interface Customer {
        fun getCustomerByOrder(orderId: String): id.masekas.doku.example.model.Customer
    }

    interface Product {
        fun getProductByOrder(orderId: String): List<id.masekas.doku.example.model.Product>
    }

    interface Order {
        fun getOrder(): id.masekas.doku.example.model.Order
    }

}