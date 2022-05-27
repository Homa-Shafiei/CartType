package ir.akharinkhabar.card_type

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.werb.library.MoreAdapter
import ir.akharinkhabar.card_type.feature.card.adapter.CardViewHolder
import ir.akharinkhabar.card_type.feature.card.viewModel.CardViewModel
import ir.akharinkhabar.card_type.feature.card.viewModel.getCardViewModel
import ir.akharinkhabar.card_type.utils.EventObserver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: CardViewModel by viewModels {
        getCardViewModel()
    }

    private val cardAdapter by lazy {
        MoreAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getCardList()
        eventObserver()
    }

    private fun eventObserver() {
        viewModel.onLoading.observe(this, EventObserver {
            loadingProgress.isVisible = it
        })

        viewModel.cardList.observe(this, EventObserver {
            if (it.isNotEmpty()) {
                setCardAdapter()
                cardAdapter.loadData(it)
            }
        })

        viewModel.onError.observe(this, EventObserver {
            Toast.makeText(
                this,
                it,
                Toast.LENGTH_SHORT
            ).show()
        })
    }


    private fun setCardAdapter() {
        cardAdapter.removeAllData()
        rvCardList.adapter = cardAdapter
        rvCardList.layoutManager = LinearLayoutManager(this)
        cardAdapter.apply {
            CardViewHolder.register(this)
            attachTo(rvCardList)
        }
    }
}