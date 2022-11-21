package cn.neday.android.template.di

import cn.neday.android.template.viewmodel.ListViewModel
import cn.neday.android.template.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }

    viewModel { ListViewModel(get()) }
}