package ir.akharinkhabar.card_type.feature.card.adapter

import android.view.View
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewHolder
import com.werb.library.link.RegisterItem
import ir.akharinkhabar.card_type.R
import ir.akharinkhabar.card_type.feature.card.model.CardListResultModel
import kotlinx.android.synthetic.main.card_list_row.*
import kotlinx.android.synthetic.main.simple_card.view.*

class CardViewHolder(values: MutableMap<String, Any>, containerView: View) :
    MoreViewHolder<CardListResultModel>(values, containerView) {

    override fun bindData(data: CardListResultModel, payloads: List<Any>) {
        when {
            data.simple != null -> {
                simple.visibility = View.VISIBLE
                wide.visibility = View.GONE
                video.visibility = View.GONE
                simple.title.text = data.simple.title
            }
            data.wide != null -> {
                simple.visibility = View.GONE
                wide.visibility = View.VISIBLE
                video.visibility = View.GONE
            }
            data.video != null -> {
                simple.visibility = View.GONE
                wide.visibility = View.GONE
                video.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        fun register(adapter: MoreAdapter) {
            adapter.register(
                RegisterItem(
                    R.layout.card_list_row,
                    CardViewHolder::class.java,
                )
            )
        }
    }
}