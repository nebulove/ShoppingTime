package com.example.shoppingtime.presentation


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shoppingtime.data.ShopListRepositoryImpl
import com.example.shoppingtime.domain.DeleteIteShopItemUseCase
import com.example.shoppingtime.domain.EditShopItemUseCase
import com.example.shoppingtime.domain.GetShopListUseCase
import com.example.shoppingtime.domain.ShopItem

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteIteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShoItem(shopItem)
    }

    fun changeEnableState (shopItem: ShopItem){
        val newItem = shopItem.copy( enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}