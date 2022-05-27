package ir.akharinkhabar.card_type.feature.card.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardListResultModel(
    @SerializedName("simple")
    val simple: CardModel? = null,
    @SerializedName("wide")
    val wide: CardModel? = null,
    @SerializedName("video")
    val video: CardModel? = null,
) : Parcelable