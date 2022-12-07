package refactoring.objetos.menu

import java.text.NumberFormat
import java.util.*

class ItemMenu(val id: Int, var descricao: String, var preco: Double) {

    var precoFormatado: String

    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

    init {
        precoFormatado = "R$ ${currencyFormatter.format(preco)}"
    }

    constructor(id: Int) : this (
        id = id,
        descricao = "",
        preco = 0.0
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ItemMenu

        if (id != other.id) return false

        return true
    }
}