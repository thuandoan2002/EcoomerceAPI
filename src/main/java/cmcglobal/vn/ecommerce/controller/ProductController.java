package cmcglobal.vn.ecommerce.controller;

import cmcglobal.vn.ecommerce.dto.ProductDTO;
import cmcglobal.vn.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"product"})
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/{productId}"})
    public ProductDTO getProductById(@PathVariable(name = "productId") long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return ResponseEntity.ok().body(productDTO);
    }

    @PutMapping("/{productId}")
    public ResponseEntity updateProduct(@Valid @PathVariable(name = "productId") Integer productId, @RequestBody ProductDTO productDTO) {
        productService.updateProductById(productId, productDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProduct(@PathVariable(name = "productId") Integer productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/filter")
    public  ResponseEntity<List<ProductDTO>> filterProduct( @RequestParam(required = false) String name,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "3") int size) {
        List<ProductDTO> productDTOS = productService.filterProduct(name, page, size);
        return ResponseEntity.ok().body(productDTOS);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @GetMapping({"/find-by-url/{url}"})
    public ProductDTO findByUrl(@PathVariable(name = "url") String url) {
        return productService.findByUrl(url);
    }
}
