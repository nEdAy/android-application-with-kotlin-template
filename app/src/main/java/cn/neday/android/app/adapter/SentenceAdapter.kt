//package cn.neday.android.template.adapter
//
//import androidx.recyclerview.widget.RecyclerView
//import cn.neday.android.template.R
//import cn.neday.android.template.network.response.SentenceResponse
//
///**
// * Adapter for the [RecyclerView]
// *
// * @author nEdAy
// */
//class SentenceAdapter :
//    BaseQuickAdapter<SentenceResponse, BaseViewHolder>(R.layout.list_item_sentence, null) {
//
//    override fun convert(holder: BaseViewHolder, item: SentenceResponse) {
//        holder.setText(R.id.tv_title, item.content)
//    }
//}