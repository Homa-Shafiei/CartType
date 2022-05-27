package ir.akharinkhabar.card_type.hawk

object Hwk {
    const val cardList = "cardList"

    fun getLogoutFieldsToDelete(): Array<String> {
        return arrayOf(
            cardList,
        )
    }
}

