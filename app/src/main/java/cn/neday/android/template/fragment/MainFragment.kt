package cn.neday.android.template.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import cn.neday.android.template.R
import cn.neday.android.template.adapter.UsersAdapter
import cn.neday.android.template.databinding.FragmentMainBinding
import cn.neday.android.template.databinding.IncludeListBinding
import cn.neday.android.template.viewmodel.MainViewModel
import cn.neday.base.fragment.BaseVMFragment
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.ToastUtils
import com.wuhenzhizao.titlebar.widget.CommonTitleBar
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : BaseVMFragment<FragmentMainBinding, MainViewModel>() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private val adapter = UsersAdapter()
    private var keyword = ""

    override val viewModel by viewModel<MainViewModel>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMainBinding.inflate(inflater, container, false)

    override fun initView() {
        initSearchHeader()
        val listBinding = IncludeListBinding.bind(binding?.root!!)
        initAdapter(listBinding)
        initSwipeToRefresh(listBinding)
        viewModel.users.observe(this) {
            adapter.setNewInstance(it)
        }
    }

    private fun initSearchHeader() {
        val searchBar = binding?.titleBarMain;
        searchBar?.centerSearchEditText?.hint = getString(R.string.tx_search_hint)
        searchBar?.setListener { view, action, keyword ->
            if (action == CommonTitleBar.ACTION_SEARCH_SUBMIT) {
                this.keyword = keyword
            }
            if (action == CommonTitleBar.ACTION_RIGHT_BUTTON) {
                this.keyword = searchBar.searchKey.toString()
            }
            KeyboardUtils.hideSoftInput(view)
            searchUsersByKeyword(this.keyword)
        }
    }

    private fun searchUsersByKeyword(keyword: String) {
        viewModel.searchUsersByKeyword(keyword)
    }

    private fun initAdapter(listBinding: IncludeListBinding) {
        listBinding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        listBinding.recyclerView.adapter = adapter
        viewModel.errMsg.observe(this) {
            ToastUtils.showShort(it)
        }
        viewModel.onComplete.observe(this) {
            listBinding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun initSwipeToRefresh(listBinding: IncludeListBinding) {
        listBinding.swipeRefreshLayout.setOnRefreshListener { searchUsersByKeyword(keyword) }
    }
}