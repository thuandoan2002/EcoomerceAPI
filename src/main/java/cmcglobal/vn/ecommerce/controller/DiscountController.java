package cmcglobal.vn.ecommerce.controller;

import cmcglobal.vn.ecommerce.dto.DiscountDTO;
import cmcglobal.vn.ecommerce.dto.ProductDTO;
import cmcglobal.vn.ecommerce.entity.DiscountEntity;
import cmcglobal.vn.ecommerce.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/discount"})
public class DiscountController {
    private final DiscountService discountService;

    @PostMapping({""})
    public ResponseEntity<DiscountDTO> addDiscount(@RequestBody DiscountDTO discountDTO) {
        return ResponseEntity.ok().body(discountService.createDiscount(discountDTO));
    }

    @PutMapping("/{discountId}")
    public ResponseEntity updateDiscount(@PathVariable(name = "discountId") Integer discountId, @RequestBody DiscountDTO discountDTO) {
        discountService.updateDiscount(discountId, discountDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{discountId}")
    public ResponseEntity deleteDiscount(@PathVariable(name = "discountId") long discountId) {
        discountService.deleteDiscount(discountId);
        return ResponseEntity.ok().build();
    }
}

