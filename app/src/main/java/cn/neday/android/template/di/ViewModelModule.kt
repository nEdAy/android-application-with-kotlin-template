package cn.neday.android.template.di

import cn.neday.android.template.viewmodel.HomeViewModel
import cn.neday.android.template.viewmodel.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }

    viewModel { ListViewModel(get()) }
}