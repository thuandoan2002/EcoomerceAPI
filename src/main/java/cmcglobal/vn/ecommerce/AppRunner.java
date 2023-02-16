package cmcglobal.vn.ecommerce;

import cmcglobal.vn.ecommerce.entity.OrderDetailEntity;
import cmcglobal.vn.ecommerce.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AppRunner implements CommandLineRunner {

    private final OrderDetailRepository orderDetailRepository;
    @Override
    public void run(String... args) throws Exception {
//        Optional<OrderDetailEntity> entity = orderDetailRepository.findById(2l);
//        System.out.printf("sdssd");
    }
}
