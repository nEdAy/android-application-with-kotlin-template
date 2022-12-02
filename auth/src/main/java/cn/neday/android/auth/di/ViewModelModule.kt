package cn.neday.android.auth.di

import cn.neday.android.auth.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { LoginViewModel(get()) }
}