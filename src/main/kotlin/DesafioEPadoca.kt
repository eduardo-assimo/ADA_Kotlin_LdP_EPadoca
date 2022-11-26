import java.text.DecimalFormat

fun main() {

    val comandaCliente = mutableListOf<Triple<String, Double, Int>>()
    var opcaoMenuPrincipal: Int = 0
    val menu = """
        
    Digite a opção desejada:
    
    1..................Pães
    2..................Salgados
    3..................Doces
    4..................Sucos
    5..................Cafés
    0..................Finalizar compra
""".trimIndent()

    val listaPaes = inicializaListaPaes()
    val listaSalgados = inicializaListaSalgados()
    val listaDoces = inicializaListaDoces()
    val listaSucos = inicializaListaSucos()
    val listaCafes = inicializaListaCafes()

    do{
        println(menu)
        opcaoMenuPrincipal = readlnOrNull()?.toIntOrNull() ?: 0
        when(opcaoMenuPrincipal) {
            1 -> {
                val itemEscolhido = imprimeMenu(listaPaes)
                itemEscolhido?.let {
                    retornaItemComanda(itemEscolhido)?.let {
                        comandaCliente.add(it)
                    }
                }
            }
            2 -> {
                val itemEscolhido = imprimeMenu(listaSalgados)
                itemEscolhido?.let {
                    retornaItemComanda(itemEscolhido)?.let {
                        comandaCliente.add(it)
                    }
                }
            }
            3 -> {
                val itemEscolhido = imprimeMenu(listaDoces)
                itemEscolhido?.let {
                    retornaItemComanda(itemEscolhido)?.let {
                        comandaCliente.add(it)
                    }
                }
            }
            4 -> {
                val itemEscolhido = imprimeMenu(listaSucos)
                itemEscolhido?.let {
                    retornaItemComanda(itemEscolhido)?.let {
                        comandaCliente.add(it)
                    }
                }
            }
            5 -> {
                val itemEscolhido = imprimeMenu(listaCafes)
                itemEscolhido?.let {
                    retornaItemComanda(itemEscolhido)?.let {
                        comandaCliente.add(it)
                    }
                }
            }
        }
    } while (opcaoMenuPrincipal != 0)

    if(!comandaCliente.isEmpty()){
        imprimeComanda(comandaCliente)
    }
}

fun imprimeComanda(listaComanda: MutableList<Triple<String, Double, Int>>) {
    var contItem = 1
    var totalCompra = 0.0
    val dec = DecimalFormat("#,##0.00")
    var totalFormat: String
    var valFormat: String
    println("====================Comanda E-padoca=======================")
    listaComanda.forEach {
        totalCompra+=(it.third * it.second)
        valFormat = dec.format(it.second)
        totalFormat = dec.format((it.third * it.second))
        println("N. Item: $contItem --- Descrição:  ${it.first} ...........  Quantidade: ${it.third}.......... Valor: R$ ${valFormat}   TOTAL: .......... R$ ${totalFormat}")
        contItem++
    }
    totalCompra = confereCupom(totalCompra)
    if(totalCompra < 0.0){
        totalCompra = 0.0
    }

    totalFormat = dec.format(totalCompra)
    println("\nTotal ===========================================> R$ $totalFormat \n\n ===================== VOLTE SEMPRE ^-^ ======================")
}

fun retornaItemComanda(item: Triple<Int, String, Double>): Triple<String, Double, Int>? {
    val qtdItem: Int
    println("\nInforme a quantidade do produto que deseja: ")
    qtdItem = readlnOrNull()?.toIntOrNull() ?: 0
    if(qtdItem > 0) {
        return Triple(item.second, item.third, qtdItem)
    }else {
        println("\n Quantidade inválida.")
        return null
    }
}

fun imprimeMenu(listaMenu: MutableList<Triple<Int,String, Double>>): Triple<Int,String, Double>? {
    var opcaoItem: Int
    val dec = DecimalFormat("#,##0.00")
    var valFormat: String
    do {
        println("\nDigite a opção desejada: ")
        listaMenu.forEach { item ->
            valFormat = dec.format(item.third)
            println("${item.first} - ${item.second}..................R$ $valFormat")
        }
        println("0 - Voltar menu anterior .....................................................................")
        opcaoItem = readlnOrNull()?.toIntOrNull() ?: 0
        if(opcaoItem != 0 && opcaoItem <= listaMenu.size) {
            return listaMenu[opcaoItem.dec()]
        }
    } while (opcaoItem != 0)
    return null
}

fun inicializaListaCafes():  MutableList<Triple<Int,String, Double>> {
    var listaCafes = mutableListOf<Triple<Int,String, Double>>()

    listaCafes.add(Triple(1,"Expresso", 1.5))
    listaCafes.add(Triple(2,"Capuccino", 3.0))
    listaCafes.add(Triple(3,"Canela", 3.5))
    listaCafes.add(Triple(4,"Pingado", 2.0))
    listaCafes.add(Triple(5,"Média", 2.5))

    return listaCafes
}

fun inicializaListaSucos():  MutableList<Triple<Int,String, Double>> {
    var listaSucos = mutableListOf<Triple<Int,String, Double>>()

    listaSucos.add(Triple(1,"Suco de Laranja", 2.5))
    listaSucos.add(Triple(2,"Suco de Caju", 3.5))
    listaSucos.add(Triple(3,"Suco de Maracujá", 2.9))
    listaSucos.add(Triple(4,"Suco de Limão", 2.0))
    listaSucos.add(Triple(5,"Suco de Abacaxi", 2.7))

    return listaSucos
}

fun inicializaListaDoces():  MutableList<Triple<Int,String, Double>> {
    var listaDoces = mutableListOf<Triple<Int,String, Double>>()

    listaDoces.add(Triple(1,"Quindim", 2.0))
    listaDoces.add(Triple(2,"Casadinho", 1.7))
    listaDoces.add(Triple(3,"Brigadeiro", 2.5))
    listaDoces.add(Triple(4,"Beijinho", 1.8))
    listaDoces.add(Triple(5,"Cajuzinho", 1.6))

    return listaDoces
}

fun inicializaListaSalgados():  MutableList<Triple<Int,String, Double>> {
    var listaSalgados = mutableListOf<Triple<Int,String, Double>>()

    listaSalgados.add(Triple(1,"Coxinha", 1.5))
    listaSalgados.add(Triple(2,"Risoles", 1.3))
    listaSalgados.add(Triple(3,"Kibe", 2.0))
    listaSalgados.add(Triple(4,"Esfiha", 1.8))
    listaSalgados.add(Triple(5,"Empada", 1.7))

    return listaSalgados
}

fun inicializaListaPaes(): MutableList<Triple<Int,String, Double>> {
    var listaPaes = mutableListOf<Triple<Int,String, Double>>()

    listaPaes.add(Triple(1,"Pão Francês", 0.5))
    listaPaes.add(Triple(2,"Pão Doce", 0.7))
    listaPaes.add(Triple(3,"Pão de Leite", 0.6))
    listaPaes.add(Triple(4,"Pão de Ló", 0.8))
    listaPaes.add(Triple(5,"Pão de Milho", 0.9))

    return listaPaes
}


fun confereCupom(totalCompra: Double): Double {
    println("\nDigite o cupom de desconto: ")
    when(readln()) {
        "5PADOCA" -> {
            println("\nCupom válido! Aplicado 5% de desconto no total de suas compras.")
            return totalCompra.times(0.95)
        }
        "10PADOCA" -> {
            println("\nCupom válido! Aplicado 10% de desconto no total de suas compras.")
            return totalCompra.times(0.90)
        }
        "5OFF" -> {
            println("\nCupom válido! Aplicado R$ 5,00 de desconto no total de suas compras.")
            return totalCompra.minus(5.0)
        }
        else -> {
            println("\nCupom inválido. Não foi aplicado nenhum desconto.")
            return totalCompra
        }
    }
}