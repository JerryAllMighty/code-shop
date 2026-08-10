package codeshop.codeshop.presentation.controller;

import codeshop.codeshop.application.CartItemService;
import codeshop.codeshop.presentation.dto.request.cart.AddCartItemRequestDto;
import codeshop.codeshop.presentation.dto.request.cart.ModifyCartItemQuantityRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/carts/items")
@RestController
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addCartItem(@Valid AddCartItemRequestDto addCartItemRequestDto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new RuntimeException("로그인이 필요합니다");
        }
        String email = session.getAttribute("email").toString();
        cartItemService.addCartItem(addCartItemRequestDto, email);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> modifyCartItemQuantity(@PathVariable Long id, @Valid ModifyCartItemQuantityRequestDto modifyCartItemQuantityRequestDto
    , HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new RuntimeException("로그인이 필요합니다");
        }
        cartItemService.modifyCartItemQuantity(id, modifyCartItemQuantityRequestDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removeCartItem(@PathVariable Long id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            throw new RuntimeException("로그인이 필요합니다");
        }
        cartItemService.removeCartItem(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
