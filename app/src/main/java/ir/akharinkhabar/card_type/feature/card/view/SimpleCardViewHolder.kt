package ir.akharinkhabar.card_type.feature.card.view

import android.view.View
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewHolder
import com.werb.library.link.RegisterItem
import ir.akharinkhabar.card_type.R
import ir.akharinkhabar.card_type.feature.card.model.CardModel
import kotlinx.android.synthetic.main.simple_card.*

class SimpleCardViewHolder(
    values: MutableMap<String, Any>,
    containerView: View,
) : MoreViewHolder<CardModel>(values, containerView) {

    override fun bindData(data: CardModel, payloads: List<Any>) {
        title.text = data.title
    }

    companion object {
        inline fun register(adapter: MoreAdapter) {
            adapter.register(
                RegisterItem(
                    R.layout.simple_card,
                    SimpleCardViewHolder::class.java,
                )
            )
        }
    }
}