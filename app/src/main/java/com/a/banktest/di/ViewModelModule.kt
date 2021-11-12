package com.a.banktest.di

import com.a.banktest.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel  = module{
    viewModel { MainViewModel() }
}