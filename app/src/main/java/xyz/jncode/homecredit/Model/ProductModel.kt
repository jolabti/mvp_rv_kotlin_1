package xyz.jncode.homecredit.Model

class ProductModel {

    var image: String? = null
    var name: String? = null

    constructor(name: String, image: String) {
        this.name = name
        this.image = image
    }
}