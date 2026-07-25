package codeshop.codeshop.application;

import codeshop.codeshop.presentation.dto.cart.CartItemAddRequestDto;
import codeshop.codeshop.presentation.dto.cart.CartItemModifyCartItemQuantityRequestDto;

public interface CartItemService {
    void addCartItem(CartItemAddRequestDto cartItemAddRequestDto, String email);
    void modifyCartItemQuantity(Long id, CartItemModifyCartItemQuantityRequestDto cartItemModifyCartItemQuantityRequestDto);
    void removeCartItem(Long id);
}
