package cn.neday.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.FragmentBinding
import com.dylanc.viewbinding.base.FragmentBindingDelegate

/**
 * Fragment 基类 + Binding
 *
 * @author nEdAy
 */
abstract class BaseBindingFragment<VB : ViewBinding> : Fragment(),
    FragmentBinding<VB> by FragmentBindingDelegate() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return createViewWithBinding(inflater, container)
    }

    protected fun popBackStack() {
        activity?.supportFragmentManager?.popBackStack()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareInitView()
        initView()
    }

    open fun prepareInitView() {
        // do nothing
    }

    abstract fun initView()
}
