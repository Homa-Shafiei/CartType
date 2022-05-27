package ir.akharinkhabar.card_type.hawk

import com.orhanobut.hawk.Hawk
import ir.akharinkhabar.card_type.feature.card.model.CardListResultModel

object Cards {
    fun set(model: List<CardListResultModel>) {
        Hawk.put(Hwk.cardList, model)
    }

    fun get(): List<CardListResultModel>? {
        return try {
            if (!Hawk.contains(Hwk.cardList))
                throw Exception("")
            Hawk.get(Hwk.cardList)
        } catch (ignored: Exception) {
            null
        }
    }
}