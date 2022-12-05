package cn.neday.android.app.di

import cn.neday.android.app.viewmodel.AccountViewModel
import cn.neday.android.app.viewmodel.HomeViewModel
import cn.neday.android.app.viewmodel.ProjectViewModel
import cn.neday.android.app.viewmodel.TreeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }

    viewModel { TreeViewModel(get()) }

    viewModel { ProjectViewModel(get()) }

    viewModel { AccountViewModel(get()) }
}