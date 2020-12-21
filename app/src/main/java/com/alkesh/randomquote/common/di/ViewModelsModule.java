package com.alkesh.randomquote.common.di;

import androidx.lifecycle.ViewModel;

import com.alkesh.randomquote.presentation.screens.quote.viewModel.QuoteViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuoteViewModel.class)
    public abstract ViewModel bindAuthViewModel(QuoteViewModel viewModel);
}