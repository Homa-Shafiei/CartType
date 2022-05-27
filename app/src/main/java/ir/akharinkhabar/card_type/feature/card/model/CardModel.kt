package ir.akharinkhabar.card_type.feature.card.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("publishDateFa")
    val publishDateFa: String? = "",
    @SerializedName("categoryName")
    val categoryName: String = "",
    @SerializedName("likeCount")
    val likeCount: Int,
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("viewCount")
    val viewCount: Int,
    @SerializedName("thumb")
    val thumb: String = "",
) : Parcelable