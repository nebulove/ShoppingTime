package com.example.shoppingtime.domain

import javax.inject.Inject

class DeleteIteShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository) {
    suspend fun deleteShoItem(shopItem: ShopItem){
        shopListRepository.deleteShoItem(shopItem)

    }
}