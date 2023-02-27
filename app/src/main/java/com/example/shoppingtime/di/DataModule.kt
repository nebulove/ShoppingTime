package com.example.shoppingtime.di

import android.app.Application
import com.example.shoppingtime.data.AppDatabase
import com.example.shoppingtime.data.ShopListDao
import com.example.shoppingtime.data.ShopListRepositoryImpl
import com.example.shoppingtime.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository

    companion object{

        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ) : ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}