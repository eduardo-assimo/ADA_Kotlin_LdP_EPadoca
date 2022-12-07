package refactoring.objetos.menu

class Menu(var listaMenu: MutableList<ItemMenu>) {

    init {
        listaMenu = mutableListOf()
    }

    fun adicionaItemMenu (item: ItemMenu) {
        if (!listaMenu.contains(item)) {
            listaMenu.add(item)
        }
    }

    fun editarItemMenu (item: ItemMenu) {
        listaMenu.forEach {
            if (it==item) {
                it.descricao = item.descricao
                it.preco = item.preco
            }
        }
    }

    fun removeItemMenu (item: ItemMenu) {
        listaMenu.remove(item)
    }
    
   private fun imprimeMenu() {
            println("\nDigite a opção desejada: ")
            listaMenu.forEach { item ->
                println("${item.id} - ${item.descricao}................. ${item.precoFormatado}")
            }
            println("0 - Voltar menu anterior .....................................................................")
    }

    fun  escolheItemMenu() : ItemMenu? {
        var opcaoItem: Int
        do {
            imprimeMenu()
            opcaoItem = readlnOrNull()?.toIntOrNull() ?: 0
            if(opcaoItem != 0) {
                var opcaoValida = ItemMenu(opcaoItem)
                listaMenu.forEach {
                    if(it == opcaoValida){
                        return it
                    }
                }
            }
        } while (opcaoItem != 0)
        return null
    }
}