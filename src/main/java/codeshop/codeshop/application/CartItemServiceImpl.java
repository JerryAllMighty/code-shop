package codeshop.codeshop.application;

import codeshop.codeshop.presentation.dto.request.cart.AddCartItemRequestDto;
import codeshop.codeshop.presentation.dto.request.cart.ModifyCartItemQuantityRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CartItemServiceImpl implements CartItemService{
    @Override
    public void addCartItem(AddCartItemRequestDto addCartItemRequestDto, String email) {

    }

    @Override
    public void modifyCartItemQuantity(Long id, ModifyCartItemQuantityRequestDto modifyCartItemQuantityRequestDto) {

    }

    @Override
    public void removeCartItem(Long id) {

    }
}
