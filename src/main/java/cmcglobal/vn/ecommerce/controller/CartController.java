package cmcglobal.vn.ecommerce.controller;

import cmcglobal.vn.ecommerce.dto.CartDTO;
import cmcglobal.vn.ecommerce.dto.CartDecreaseDTO;
import cmcglobal.vn.ecommerce.dto.ProductDTO;
import cmcglobal.vn.ecommerce.service.CartService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/v1/cart"})
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartDTO> addCart(@Valid @RequestBody CartDTO cartDTO) {
        cartService.createCart(cartDTO);
        return ResponseEntity.ok().body(cartDTO);
    }
    @PutMapping
    public ResponseEntity<CartDecreaseDTO> decreaseCartItem(@Valid @RequestBody CartDecreaseDTO cartDecreaseDTO) {
        cartService.decreaseCartItem(cartDecreaseDTO);
        return ResponseEntity.ok().body(cartDecreaseDTO);
    }
}
