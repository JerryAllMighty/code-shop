package codeshop.codeshop.application;

import codeshop.codeshop.presentation.dto.cart.CartItemAddRequestDto;
import codeshop.codeshop.presentation.dto.cart.CartItemModifyCartItemQuantityRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService{
    @Override
    public void addCartItem(CartItemAddRequestDto cartItemAddRequestDto, String email) {

    }

    @Override
    public void modifyCartItemQuantity(Long id, CartItemModifyCartItemQuantityRequestDto cartItemModifyCartItemQuantityRequestDto) {

    }

    @Override
    public void removeCartItem(Long id) {

    }
}
