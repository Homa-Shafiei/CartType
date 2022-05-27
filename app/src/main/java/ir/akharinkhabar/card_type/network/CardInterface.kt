package ir.akharinkhabar.card_type.network

import ir.akharinkhabar.card_type.feature.card.model.CardListResultModel
import retrofit2.Response
import retrofit2.http.GET


interface CardInterface {

    @GET("api/v1/list.php")
    suspend fun getCardList(): Response<List<CardListResultModel>>

}