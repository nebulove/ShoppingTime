package com.example.shoppingtime.domain

class DeleteIteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShoItem(shopItem: ShopItem){
        shopListRepository.deleteShoItem(shopItem)

    }
}