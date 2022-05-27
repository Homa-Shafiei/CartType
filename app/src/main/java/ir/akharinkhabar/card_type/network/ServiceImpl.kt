package ir.akharinkhabar.card_type.network

class ServiceImpl : BaseService() {

    fun cardService(): CardInterface =
        getRetrofit().create(CardInterface::class.java)

}