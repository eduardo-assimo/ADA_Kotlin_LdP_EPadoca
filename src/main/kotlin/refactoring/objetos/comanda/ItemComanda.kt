package refactoring.objetos.comanda

import refactoring.objetos.menu.ItemMenu
import java.text.NumberFormat
import java.util.*

class ItemComanda (
    var quantidadeItens: Int,
    var itemComanda: ItemMenu
) {
    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
    val valorTotalItem: Double
        get(): Double {
          return  quantidadeItens * itemComanda.preco
        }
    var valorTotalFormatado: String = ""
        get() {
            return currencyFormatter.format(valorTotalItem)
        }

    override fun toString(): String {
        return ("Id. Item: ${itemComanda.id} --- Descrição:  ${itemComanda.descricao} ...........  Quantidade: $quantidadeItens.......... Valor: ${itemComanda.precoFormatado}   TOTAL: .......... $valorTotalFormatado")
    }

}