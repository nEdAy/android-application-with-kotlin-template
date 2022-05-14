package cn.neday.android.template.adapter

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import cn.neday.android.template.R
import cn.neday.android.template.network.response.Item
import coil.load
import coil.transform.RoundedCornersTransformation
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * Adapter for the [RecyclerView]
 *
 * @author nEdAy
 */
class UsersAdapter : BaseQuickAdapter<Item, BaseViewHolder>(R.layout.list_item_user, null) {

    override fun convert(holder: BaseViewHolder, item: Item) {
        holder.setText(R.id.tv_title, item.login)
        (holder.getView(R.id.iv_avatar) as? ImageView)?.load(
            item.avatar_url
        ) {
            crossfade(true)
            placeholder(R.drawable.icon_stub)
            error(R.drawable.icon_error)
            transformations(RoundedCornersTransformation(10f))
        }
    }
}