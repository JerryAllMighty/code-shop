package codeshop.codeshop.application;

import codeshop.codeshop.domain.entity.Cart;
import codeshop.codeshop.domain.entity.CartItem;
import codeshop.codeshop.infra.CartRepository;
import codeshop.codeshop.presentation.dto.response.cart.GetMyCartResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public GetMyCartResponseDto getMyCart(String email) {
        //TODO : jpql 과 querydsl 사용 기준 정립
        //TODO : dto 생성 더 좋은 방법 고민해보기
        GetMyCartResponseDto myCartResponseDto = new GetMyCartResponseDto();
        Cart myCart = cartRepository.findOneByMemberEmail(email);
        List<CartItem> myCartCartItemList = myCart.getCartItemList();
        myCartCartItemList.forEach(cartItem -> myCartResponseDto.cartItemList.add(
                new GetMyCartResponseDto.MyCartItemResponseDto(
                        cartItem.getProductId(),
                        cartItem.getQuantity(),
                        cartItem.getQuantity() > 0 && cartItem.isOnSale()
                )
        ));
        return myCartResponseDto;
    }
}
