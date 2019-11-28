package id.masekas.doku.example.repository

import id.masekas.doku.example.model.Order

class OrderDefaultRepository: Repository.Order {

    override fun getOrder(): Order {
        return Order(
            id = "000-000-00001",
            date = System.currentTimeMillis()
        )
    }
}