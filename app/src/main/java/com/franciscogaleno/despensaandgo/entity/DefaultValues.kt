package com.franciscogaleno.despensaandgo.entity

class DefaultValues {

    public fun getProducts(): MutableList<Product> {
        return mutableListOf(
            Product(
                "Huevos Grandes Blancos Yemita 12 unidades",
                "",
                3890,
                "Unimarc Centro",
                1
            ),
            Product(
                "Leche Entera Soprole 1L",
                "",
                1249,
                "Cugat",
                1
            ),
            Product(
                "Monster Energy Taurina Guaraná 473ml",
                "",
                1690,
                "Cugat",
                1
            ),
            Product(
                "Avena Integral Quaker 700g",
                "",
                2590,
                "Lider Centro",
                1
            )
        )
    }

    public fun getShops(): MutableList<Shop>
    {
        return mutableListOf(
            Shop(
                "Unimarc Centro",
                8, 30,
                21, 0,
                "1 Sur 1531"
            ),
            Shop(
                "Cugat",
                8, 0,
                21, 0,
                "Av. Lircay 2455"
            ),
            Shop(
                "Lider Centro",
                8, 0,
                21, 30,
                "2 Norte 1422"
            )
        )
    }
}