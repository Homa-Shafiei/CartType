package ir.akharinkhabar.card_type.feature.card.repository

import ir.akharinkhabar.card_type.feature.card.model.CardListResultModel
import ir.akharinkhabar.card_type.network.Result
import ir.akharinkhabar.card_type.network.ServiceImpl

class DefaultCardRepository : CardRepository {

    override suspend fun getCardList(): Result<List<CardListResultModel>> {
        return ServiceImpl().apiCall(
            call = {
                ServiceImpl()
                    .cardService()
                    .getCardList()
            })
    }
}