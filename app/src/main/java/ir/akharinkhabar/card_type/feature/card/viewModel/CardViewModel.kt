package ir.akharinkhabar.card_type.feature.card.viewModel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import ir.akharinkhabar.card_type.feature.card.model.CardListResultModel
import ir.akharinkhabar.card_type.feature.card.repository.CardRepository
import ir.akharinkhabar.card_type.feature.card.repository.DefaultCardRepository
import ir.akharinkhabar.card_type.hawk.Cards
import ir.akharinkhabar.card_type.network.Result
import ir.akharinkhabar.card_type.utils.Event
import ir.akharinkhabar.card_type.utils.defaultSavedStateViewModelFactory
import kotlinx.coroutines.launch

class CardViewModel(
    savedState: SavedStateHandle,
    private val repository: CardRepository
) : ViewModel() {

    private val _onLoading = MutableLiveData<Event<Boolean>>()
    val onLoading: LiveData<Event<Boolean>> = _onLoading

    private val _cardList = MutableLiveData<Event<List<CardListResultModel>>>()
    val cardList: LiveData<Event<List<CardListResultModel>>> = _cardList

    private val _onError = MutableLiveData<Event<String>>()
    val onError: LiveData<Event<String>> = _onError


    fun getCardList() {
        viewModelScope.launch {
            _onLoading.postValue(Event(true))
            val result = repository.getCardList()
            when (result) {
                is Result.Error -> {
                    _onLoading.postValue(Event(false))
                    if (Cards.get() != null) {
                        _cardList.postValue(Event(Cards.get()!!))
                    } else {
                        _onError.postValue(Event(result.error))
                    }
                }
                is Result.Success -> {
                    _onLoading.postValue(Event(false))
                    Cards.set(result.data)
                    _cardList.postValue(Event(result.data))
                }
            }
        }
    }

}

fun AppCompatActivity.getCardViewModel(
    repository: CardRepository = DefaultCardRepository()
) = defaultSavedStateViewModelFactory(this) { savedState ->
    CardViewModel(savedState, repository)
}