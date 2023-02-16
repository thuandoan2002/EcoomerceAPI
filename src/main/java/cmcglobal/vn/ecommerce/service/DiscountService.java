package cmcglobal.vn.ecommerce.service;

import cmcglobal.vn.ecommerce.dto.DiscountDTO;
import cmcglobal.vn.ecommerce.entity.DiscountEntity;
import cmcglobal.vn.ecommerce.repository.DiscountRepository;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Optional;

@Service
public class DiscountService {
    public final DiscountRepository discountRepository;

    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        Optional<DiscountEntity> exits = discountRepository.exitsByCode(discountDTO.getCode());
        if (discountDTO.getDiscountPercent() > 0 && Objects.nonNull(discountDTO.getCode()) && !exits.isPresent()  ) {
            DiscountEntity discountEntity = new DiscountEntity();
            discountEntity.setDiscountPercent(discountDTO.getDiscountPercent());
            discountEntity.setStatus(discountDTO.getStatus());
            discountEntity.setCode(discountDTO.getCode());
            discountRepository.save(discountEntity);
            return discountDTO;
        }
        return null;
    }
    public void updateDiscount(long discountId, DiscountDTO discountDTO) {
        Optional<DiscountEntity> discountEntityOptional = discountRepository.findById(discountId);
        Optional<DiscountEntity> exits = discountRepository.exitsByCode(discountDTO.getCode());
        if (discountEntityOptional.isPresent() && exits.isEmpty()) {
            DiscountEntity discountEntity = discountEntityOptional.get();
            discountEntity.setCode(discountDTO.getCode());
            discountEntity.setDiscountPercent(discountDTO.getDiscountPercent());
            discountEntity.setStatus(discountDTO.getStatus());
            discountRepository.save(discountEntity);
        }
    }
    public void deleteDiscount(long discountId) {
        Optional<DiscountEntity> discountEntityOptional = discountRepository.findById(discountId);
        if (discountEntityOptional.isPresent()){
            discountRepository.deleteById(discountId);
        }

    }
}
