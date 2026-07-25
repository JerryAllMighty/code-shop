package codeshop.codeshop.presentation.controller;

import codeshop.codeshop.application.CartService;
import codeshop.codeshop.presentation.dto.cart.MyCartResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/carts")
@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<MyCartResponseDto> getMyCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new RuntimeException("로그인이 필요합니다");
        }
        String email = session.getAttribute("email").toString();
        return ResponseEntity.ok(cartService.getMyCart(email));
    }
}
