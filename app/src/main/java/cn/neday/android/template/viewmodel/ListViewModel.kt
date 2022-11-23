package cn.neday.android.template.viewmodel

import androidx.lifecycle.viewModelScope
import cn.neday.android.template.network.entity.ApiResponse
import cn.neday.android.template.network.repository.WanAndroidRepository
import cn.neday.android.template.network.response.ArticleListResponse
import cn.neday.android.template.network.response.BannerResponse
import cn.neday.base.network.requestAsync
import cn.neday.base.network.then
import cn.neday.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ListViewModel
 *
 * @author nEdAy
 */
class ListViewModel(private val repository: WanAndroidRepository) : BaseViewModel() {

    private val _article = MutableStateFlow(ApiResponse<ArticleListResponse>())
    val article: StateFlow<ApiResponse<ArticleListResponse>> = _article

    private val _banner = MutableStateFlow(ApiResponse<List<BannerResponse>>())
    val banner: StateFlow<ApiResponse<List<BannerResponse>>> = _banner

    fun getArticleList() {
        requestAsync {
            repository.articleList()
        }.then(viewModelScope, {
            _article.value = it
        }, {
            errorMessage.value = it
        }, {
            onComplete.call()
        })
    }

    fun getBanner() {
        requestAsync {
            repository.banner()
        }.then(viewModelScope, {
            _banner.value = it
        }, {
            errorMessage.value = it
        }, {
            onComplete.call()
        })
    }
}