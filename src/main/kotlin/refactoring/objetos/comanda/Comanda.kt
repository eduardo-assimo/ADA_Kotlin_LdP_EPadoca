package refactoring.objetos.comanda

import refactoring.objetos.menu.ItemMenu
import java.text.NumberFormat
import java.util.*

class Comanda {
    var listaItensComanda:  MutableList<ItemComanda>
    val totalComanda: Double
        get() {
            var total = 0.0
            listaItensComanda.forEach {
                total+=it.valorTotalItem
            }
            if(total < 0.0) {
                total = 0.0
            }
            return total
        }
    var cupomDesconto: String? = null
        set(value) {
            field = when (value) {
                "5PADOCA" -> {
                    println("\nCupom válido! Aplicado 5% de desconto no total de suas compras.")
                    "5PADOCA"
                }
                "10PADOCA" -> {
                    println("\nCupom válido! Aplicado 10% de desconto no total de suas compras.")
                    "10PADOCA"
                }
                "5OFF" -> {
                    println("\nCupom válido! Aplicado R$ 5,00 de desconto no total de suas compras.")
                    "5OFF"
                }
                else -> {
                    println("\nCupom inválido. Não foi aplicado nenhum desconto.")
                    null
                }
            }
        }

    val valorDesconto: Double
        get(): Double {
            return when (cupomDesconto) {
                "5PADOCA" -> {
                    totalComanda.times(0.95)
                }
                "10PADOCA" -> {
                    totalComanda.times(0.90)
                }
                "5OFF" -> {
                    if(totalComanda < 5.0)  0.0 else  totalComanda.minus(5.0)
                }
                else -> {
                    totalComanda
                }
            }
        }

    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

    init {
        listaItensComanda = mutableListOf()
    }

    fun incluiItemComanda(item: ItemMenu) {
        val qtdItem: Int
        println("\nInforme a quantidade do produto que deseja: ")
        qtdItem = readlnOrNull()?.toIntOrNull() ?: 0
        if(qtdItem > 0) {
            listaItensComanda.add(ItemComanda(quantidadeItens = qtdItem, itemComanda = item))
        }else {
            println("\n Quantidade inválida.")
        }
    }

    private fun insereCupomDesconto() {
        println("\nDigite o cupom de desconto: ")
        cupomDesconto = readlnOrNull()
    }

    fun imprimirComanda() {
        println("====================Comanda E-padoca=======================")
        listaItensComanda.forEach {
            it.toString()
        }
        insereCupomDesconto()
        println("\nTotal ===========================================> ${currencyFormatter.format(totalComanda)}  \n\nTotal com Desconto: ===========================================> ${currencyFormatter.format(valorDesconto)} \n\nVOLTE SEMPRE ^-^ ======================")
    }
}