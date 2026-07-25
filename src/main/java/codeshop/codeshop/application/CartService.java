package codeshop.codeshop.application;

import codeshop.codeshop.presentation.dto.cart.MyCartResponseDto;

public interface CartService {
    //TODO : dto 반환을 관장하는 레이어 관련해서 기준 정립하기
    MyCartResponseDto getMyCart(String email);
}
