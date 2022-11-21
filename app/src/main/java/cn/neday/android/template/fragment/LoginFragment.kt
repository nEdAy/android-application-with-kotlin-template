package cn.neday.android.template.fragment

import androidx.recyclerview.widget.GridLayoutManager
import cn.neday.android.template.adapter.SentenceAdapter
import cn.neday.android.template.databinding.FragmentMainBinding
import cn.neday.android.template.databinding.IncludeListBinding
import cn.neday.android.template.viewmodel.ListViewModel
import cn.neday.base.fragment.BaseBindingVMFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseBindingVMFragment<FragmentMainBinding, ListViewModel>() {

    private val adapter = SentenceAdapter()
    private var keyword = ""

    override val viewModel by viewModel<ListViewModel>()

    override fun initView() {
        initSearchHeader()
        val listBinding = IncludeListBinding.bind(binding.root)
        initAdapter(listBinding)
        initSwipeToRefresh(listBinding)
        viewModel.sentence.observe(this) {

        }
    }

    private fun initSearchHeader() {
//        val searchBar = binding?.titleBarMain;
//        searchBar?.centerSearchEditText?.hint = getString(R.string.tx_search_hint)
//        searchBar?.setListener { view, action, keyword ->
//            if (action == CommonTitleBar.ACTION_SEARCH_SUBMIT) {
//                this.keyword = keyword
//            }
//            if (action == CommonTitleBar.ACTION_RIGHT_BUTTON) {
//                this.keyword = searchBar.searchKey.toString()
//            }
//            KeyboardUtils.hideSoftInput(view)
//            searchUsersByKeyword(this.keyword)
//        }
    }

    private fun searchUsersByKeyword(keyword: String) {
        viewModel.getSentence()
    }

    private fun initAdapter(listBinding: IncludeListBinding) {
        listBinding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        listBinding.recyclerView.adapter = adapter
        viewModel.onComplete.observe(this) {
            listBinding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun initSwipeToRefresh(listBinding: IncludeListBinding) {
        listBinding.swipeRefreshLayout.setOnRefreshListener { searchUsersByKeyword(keyword) }
    }
}