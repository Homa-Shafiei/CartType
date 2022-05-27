package ir.akharinkhabar.card_type.feature.card.adapter

import android.view.View
import com.werb.library.MoreAdapter
import com.werb.library.MoreViewHolder
import com.werb.library.link.RegisterItem
import ir.akharinkhabar.card_type.R
import ir.akharinkhabar.card_type.feature.card.model.CardListResultModel
import ir.akharinkhabar.card_type.utils.setImageLink
import kotlinx.android.synthetic.main.card_list_row.*
import kotlinx.android.synthetic.main.simple_card.view.*
import kotlinx.android.synthetic.main.video_card.view.*
import kotlinx.android.synthetic.main.wide_card.view.*

class CardViewHolder(values: MutableMap<String, Any>, containerView: View) :
    MoreViewHolder<CardListResultModel>(values, containerView) {

    override fun bindData(data: CardListResultModel, payloads: List<Any>) {
        when {
            data.simple != null -> {
                simple.visibility = View.VISIBLE
                wide.visibility = View.GONE
                video.visibility = View.GONE

                simple.title.text = data.simple.title
                simple.category.text = data.simple.categoryName
                simple.description.text = data.simple.desc
                simple.time.text = data.simple.publishDateFa

                simple.title.setVisibility(data.simple.title)
                simple.category.setVisibility(data.simple.categoryName)
                simple.description.setVisibility(data.simple.desc)
                simple.categoryTime.setVisibility(data.simple.publishDateFa ?: "")
                simple.image.setImageLink(data.simple.thumb)
            }
            data.wide != null -> {
                simple.visibility = View.GONE
                wide.visibility = View.VISIBLE
                video.visibility = View.GONE

                wide.wideTitle.text = data.wide.title
                wide.wideCategory.text = data.wide.categoryName
                wide.wideTime.text = data.wide.publishDateFa

                wide.wideTitle.setVisibility(data.wide.title)
                wide.wideCategory.setVisibility(data.wide.categoryName)
                wide.wideCategoryTime.setVisibility(data.wide.publishDateFa ?: "")
                wide.wideImage.setImageLink(data.wide.thumb)
            }

            data.video != null -> {
                simple.visibility = View.GONE
                wide.visibility = View.GONE
                video.visibility = View.VISIBLE

                video.videoTitle.text = data.video.title
                video.videoImage.setImageLink(data.video.thumb)
            }
        }
    }

    private fun View.setVisibility(text: String) {
        visibility = if (text.isEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
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