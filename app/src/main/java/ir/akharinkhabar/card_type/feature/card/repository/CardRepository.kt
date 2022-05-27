package ir.akharinkhabar.card_type.feature.card.repository


import ir.akharinkhabar.card_type.feature.card.model.CardListResultModel
import ir.akharinkhabar.card_type.network.Result

interface CardRepository {

    suspend fun getCardList(): Result<List<CardListResultModel>>

}