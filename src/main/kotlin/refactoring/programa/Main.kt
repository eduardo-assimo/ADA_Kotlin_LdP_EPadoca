package refactoring.programa

import refactoring.objetos.comanda.Comanda
import refactoring.objetos.menu.ItemMenu

fun main() {
    var opcaoMenuPrincipal = 0
    val listaCafes = MenuInitializer.inicializaListaCafes()
    val listaSucos = MenuInitializer.inicializaListaSucos()
    val listaDoces = MenuInitializer.inicializaListaDoces()
    val listaSalgados = MenuInitializer.inicializaListaSalgados()
    val listaPaes = MenuInitializer.inicializaListaPaes()
    val comanda = Comanda()
    var itemEscolhido: ItemMenu? = null

    val menu = """
        
    Digite a opção desejada:
    
    1..................Pães
    2..................Salgados
    3..................Doces
    4..................Sucos
    5..................Cafés
    0..................Finalizar compra
""".trimIndent()

    do{
        println(menu)
        opcaoMenuPrincipal = readlnOrNull()?.toIntOrNull() ?: 0
        when(opcaoMenuPrincipal) {
            1 -> {
                itemEscolhido = listaPaes.escolheItemMenu()
            }
            2 -> {
                itemEscolhido = listaSalgados.escolheItemMenu()
            }
            3 -> {
                itemEscolhido = listaDoces.escolheItemMenu()
            }
            4 -> {
                itemEscolhido = listaSucos.escolheItemMenu()
            }
            5 -> {
                itemEscolhido = listaCafes.escolheItemMenu()
            }
        }
        if(opcaoMenuPrincipal != 0) {
            itemEscolhido?.let {
                comanda.incluiItemComanda(it)
            }
        }
    } while (opcaoMenuPrincipal != 0)
    comanda.imprimirComanda()
}