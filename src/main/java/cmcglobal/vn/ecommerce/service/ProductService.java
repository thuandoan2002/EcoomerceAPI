package cmcglobal.vn.ecommerce.service;

import cmcglobal.vn.ecommerce.dto.ProductDTO;
import cmcglobal.vn.ecommerce.entity.ProductEntity;
import cmcglobal.vn.ecommerce.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    public final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO getProductById(long productId) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(productId);
        ProductDTO productDTO = new ProductDTO();
        if (productEntityOptional.isPresent()) {
            productDTO.setName(productEntityOptional.get().getName());
            productDTO.setSku(productEntityOptional.get().getSku());
            productDTO.setLongDesc(productEntityOptional.get().getLongDesc());
            productDTO.setUrl(productEntityOptional.get().getUrl());
            productDTO.setLastUpdated(productEntityOptional.get().getLastUpdated());
            productDTO.setDateCreated(productEntityOptional.get().getDateCreated());
            productDTO.setUnlimited(productEntityOptional.get().getUnlimited());
            productDTO.setCategoryId(productEntityOptional.get().getProductCategoryByCategoryId().getId());
        }
        return productDTO;
    }

    public ProductEntity createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setSku(productDTO.getSku());
        productEntity.setLongDesc(productDTO.getLongDesc());
        productEntity.setUrl(productDTO.getUrl());
        productEntity.setLastUpdated(productDTO.getLastUpdated());
        productEntity.setDateCreated(productDTO.getDateCreated());
//        productEntity.s(productDTO.getCategoryId());
        return productRepository.save(productEntity);
    }

    public void updateProductById(long productId, ProductDTO productDTO) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(productId);
        if (productEntityOptional.isPresent()) {
            ProductEntity productEntity = productEntityOptional.get();
            productEntity.setName(productDTO.getName());
            productEntity.setSku(productDTO.getSku());
            productEntity.setLongDesc(productDTO.getLongDesc());
            productEntity.setUrl(productDTO.getUrl());
            productEntity.setLastUpdated(productDTO.getLastUpdated());
            productEntity.setDateCreated(productDTO.getDateCreated());
//            productEntity.setCategoryId(productDTO.getCategoryId());
            productRepository.save(productEntity);
        }
    }

    public void deleteProductById(long productId) {
        productRepository.deleteById(productId);
    }

    public List<ProductDTO> filterProduct(String name, int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<ProductEntity> productEntities = productRepository.findByNameIsContaining(name, paging);
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<ProductEntity> productEntityList = productEntities.getContent();
        productEntityList.forEach(productEntity -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(productEntity.getName());
            productDTO.setSku(productEntity.getSku());
            productDTO.setLongDesc(productEntity.getLongDesc());
            productDTO.setUrl(productEntity.getUrl());
            productDTO.setLastUpdated(productEntity.getLastUpdated());
            productDTO.setDateCreated(productEntity.getDateCreated());
            productDTO.setUnlimited(productEntity.getUnlimited());
//            productDTO.setCategoryId(productEntity.getCategoryId());
            productDTOList.add(productDTO);

        });
        return productDTOList;

    }
    public ProductDTO findByUrl(String url) {
        Collection<ProductEntity> productEntityOptional = productRepository.getByUrl(url);
        ProductDTO productDTO = new ProductDTO();
        if (!productEntityOptional.isEmpty()) {
            productDTO.setName(productEntityOptional.stream().findFirst().get().getName());
            productDTO.setSku(productEntityOptional.stream().findFirst().get().getSku());
            productDTO.setLongDesc(productEntityOptional.stream().findFirst().get().getLongDesc());
            productDTO.setUrl(productEntityOptional.stream().findFirst().get().getUrl());
            productDTO.setLastUpdated(productEntityOptional.stream().findFirst().get().getLastUpdated());
            productDTO.setDateCreated(productEntityOptional.stream().findFirst().get().getDateCreated());
            productDTO.setUnlimited(productEntityOptional.stream().findFirst().get().getUnlimited());
//            productDTO.setCategoryId(productEntityOptional.stream().findFirst().get().getCategoryId());
        }
        return productDTO;
    }
}
