package refactoring.programa

import refactoring.objetos.menu.ItemMenu
import refactoring.objetos.menu.Menu

class MenuInitializer {

    companion object {
        fun inicializaListaCafes(): Menu {
            var listaCafes = Menu(mutableListOf())

            listaCafes.adicionaItemMenu(ItemMenu(1, "Expresso", 1.5))
            listaCafes.adicionaItemMenu(ItemMenu(2, "Capuccino", 3.0))
            listaCafes.adicionaItemMenu(ItemMenu(3, "Canela", 3.5))
            listaCafes.adicionaItemMenu(ItemMenu(4, "Pingado", 2.0))
            listaCafes.adicionaItemMenu(ItemMenu(5, "Média", 2.5))

            return listaCafes
        }

        fun inicializaListaSucos(): Menu {
            var listaSucos = Menu(mutableListOf())

            listaSucos.adicionaItemMenu(ItemMenu(1, "Suco de Laranja", 2.5))
            listaSucos.adicionaItemMenu(ItemMenu(2, "Suco de Caju", 3.5))
            listaSucos.adicionaItemMenu(ItemMenu(3, "Suco de Maracujá", 2.9))
            listaSucos.adicionaItemMenu(ItemMenu(4, "Suco de Limão", 2.0))
            listaSucos.adicionaItemMenu(ItemMenu(5, "Suco de Abacaxi", 2.7))

            return listaSucos
        }

        fun inicializaListaDoces(): Menu {
            var listaDoces = Menu(mutableListOf())

            listaDoces.adicionaItemMenu(ItemMenu(1, "Quindim", 2.0))
            listaDoces.adicionaItemMenu(ItemMenu(2, "Casadinho", 1.7))
            listaDoces.adicionaItemMenu(ItemMenu(3, "Brigadeiro", 2.5))
            listaDoces.adicionaItemMenu(ItemMenu(4, "Beijinho", 1.8))
            listaDoces.adicionaItemMenu(ItemMenu(5, "Cajuzinho", 1.6))

            return listaDoces
        }

        fun inicializaListaSalgados(): Menu {
            var listaSalgados = Menu(mutableListOf())

            listaSalgados.adicionaItemMenu(ItemMenu(1, "Coxinha", 1.5))
            listaSalgados.adicionaItemMenu(ItemMenu(2, "Risoles", 1.3))
            listaSalgados.adicionaItemMenu(ItemMenu(3, "Kibe", 2.0))
            listaSalgados.adicionaItemMenu(ItemMenu(4, "Esfiha", 1.8))
            listaSalgados.adicionaItemMenu(ItemMenu(5, "Empada", 1.7))

            return listaSalgados
        }

        fun inicializaListaPaes(): Menu {
            var listaPaes = Menu(mutableListOf())

            listaPaes.adicionaItemMenu(ItemMenu(1, "Pão Francês", 0.5))
            listaPaes.adicionaItemMenu(ItemMenu(2, "Pão Doce", 0.7))
            listaPaes.adicionaItemMenu(ItemMenu(3, "Pão de Leite", 0.6))
            listaPaes.adicionaItemMenu(ItemMenu(4, "Pão de Ló", 0.8))
            listaPaes.adicionaItemMenu(ItemMenu(5, "Pão de Milho", 0.9))

            return listaPaes
        }
    }
}