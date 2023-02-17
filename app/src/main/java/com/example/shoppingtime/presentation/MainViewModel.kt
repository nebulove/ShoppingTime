package com.example.shoppingtime.presentation


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingtime.data.ShopListRepositoryImpl
import com.example.shoppingtime.domain.DeleteIteShopItemUseCase
import com.example.shoppingtime.domain.EditShopItemUseCase
import com.example.shoppingtime.domain.GetShopListUseCase
import com.example.shoppingtime.domain.ShopItem
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteIteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShoItem(shopItem)
        }
    }

    fun changeEnableState (shopItem: ShopItem){
        viewModelScope.launch {
            val newItem = shopItem.copy( enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

}