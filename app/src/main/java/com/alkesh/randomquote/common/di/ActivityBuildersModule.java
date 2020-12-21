package com.alkesh.randomquote.common.di;


import com.alkesh.randomquote.presentation.screens.quote.activity.QuoteActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {ViewModelsModule.class})
    abstract QuoteActivity contributeAuthActivity();

}