package cmcglobal.vn.ecommerce.controller;

import cmcglobal.vn.ecommerce.dto.OrdersDTO;
import cmcglobal.vn.ecommerce.dto.ProductDTO;
import cmcglobal.vn.ecommerce.service.OrdersService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api"})
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping({"/order"})
    public ResponseEntity<OrdersDTO> addOrder(@RequestParam(required = false) long userId,
                                              @Valid @RequestBody OrdersDTO ordersDTO) {
        ordersService.createdOrder(ordersDTO, userId);
        return ResponseEntity.ok().build();
    }
    @GetMapping({"order/search"})
    public ResponseEntity<List<OrdersDTO>> filterOrder(@RequestParam(required = false) String shipName,
                                                       @RequestParam(required = false) String shipAddress,
                                                       @RequestParam(required = false) String billingAddress,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        List<OrdersDTO> ordersDTOList = ordersService.filterOrder(shipName, shipAddress, billingAddress, page, size);
        return ResponseEntity.ok().body(ordersDTOList);

    }
    @GetMapping({"find-by-user-id/order"})
    public ResponseEntity<List<OrdersDTO>> getOrderByUser(@RequestParam(required = false) long userId,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        List<OrdersDTO> ordersDTOList = ordersService.getOrderByUser(userId, page, size);
        return ResponseEntity.ok().body(ordersDTOList);

    }
}

