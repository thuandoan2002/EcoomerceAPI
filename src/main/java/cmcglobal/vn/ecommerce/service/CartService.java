package cmcglobal.vn.ecommerce.service;

import cmcglobal.vn.ecommerce.dto.CartDTO;
import cmcglobal.vn.ecommerce.dto.CartDecreaseDTO;
import cmcglobal.vn.ecommerce.entity.CartEntity;
import cmcglobal.vn.ecommerce.entity.CartItemEntity;
import cmcglobal.vn.ecommerce.entity.ProductVariantEntity;
import cmcglobal.vn.ecommerce.entity.UserEntity;
import cmcglobal.vn.ecommerce.repository.CartItemRepository;
import cmcglobal.vn.ecommerce.repository.CartRepository;
import cmcglobal.vn.ecommerce.repository.ProductVariantIdRepository;
import cmcglobal.vn.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class CartService {
    public final CartItemRepository cartItemRepository;
    public final ProductVariantIdRepository productVariantIdRepository;
    public final CartRepository cartRepository;
    public final UserRepository userRepository;

    public CartService(CartItemRepository cartItemRepository, ProductVariantIdRepository productVariantIdRepository,
                       CartRepository cartRepository, UserRepository userRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productVariantIdRepository = productVariantIdRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public CartDTO createCart(CartDTO cartDTO) {
        Optional<UserEntity> userEntityOptional = userRepository.findByEmail(cartDTO.getEmail());
        Optional<ProductVariantEntity> productVariantEntity = productVariantIdRepository.findById(cartDTO.getProductVariantId());
        CartItemEntity cartItemEntity = new CartItemEntity();
        if (userEntityOptional.isPresent() && productVariantEntity.isPresent()) {
            Collection<CartEntity> userCart = userEntityOptional.get().getCartsById();
            if (!userCart.isEmpty()) {
                Optional<CartEntity> cartEntityOptional = userCart.stream().findFirst();
                CartEntity cartDb =  cartEntityOptional.get();
                cartItemEntity.setCartByCartId(cartDb);
                cartDb.setTotalPrice(cartDb.getTotalPrice().add(productVariantEntity.get().getPrice().subtract(new BigDecimal(cartDTO.getAmount()))));
            } else {
                CartEntity cartEntity = new CartEntity();
                cartEntity.setUserByUserId(userEntityOptional.get());
                cartEntity.setDateCreated(LocalDateTime.now());
                cartEntity.setTotalCartPrice(productVariantEntity.get().getPrice().multiply(new BigDecimal(cartDTO.getAmount())) );
                cartEntity = cartRepository.save(cartEntity);
                cartItemEntity.setCartByCartId(cartEntity);
            }

            cartItemEntity.setAmount(cartDTO.getAmount());
            cartItemEntity.setProductVariantByProductVariantId(productVariantEntity.get());
            cartItemRepository.save(cartItemEntity);
        }
        return cartDTO;
    }
    @Transactional
    public CartEntity decreaseCartItem(CartDecreaseDTO cartDecreaseDTO) {
        Optional<CartEntity> cartEntityOptional = cartRepository.findById(cartDecreaseDTO.getCartId());
        Optional<ProductVariantEntity> productVariantEntity = productVariantIdRepository.findById(cartDecreaseDTO.getProductVariantId());

        if (cartEntityOptional.isPresent() && productVariantEntity.isPresent()) {
            // Tính số tiền của đơn hàng bị trừ
            BigDecimal totalPriceDecrease = productVariantEntity.get().getPrice().multiply(cartDecreaseDTO.getAmountDecrease());
            CartEntity cartEntity = cartEntityOptional.get();
            // Tính tổng số tiền còn lại của đơn hàng
            // (bằng tổng giá trị giỏ hàng lưu trong DB trừ đi (số lượng sản phẩm {amount} nhân với giá sản phẩm))
            BigDecimal currenTotalPrice = cartEntity.getTotalCartPrice().subtract(totalPriceDecrease);
            cartEntity.setTotalCartPrice(currenTotalPrice);
            cartRepository.save(cartEntity);

        }
        return null;

    }

}


