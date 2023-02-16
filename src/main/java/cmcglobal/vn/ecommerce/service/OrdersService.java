package cmcglobal.vn.ecommerce.service;

import cmcglobal.vn.ecommerce.dto.OrdersDTO;
import cmcglobal.vn.ecommerce.entity.*;
import cmcglobal.vn.ecommerce.repository.CartRepository;
import cmcglobal.vn.ecommerce.repository.OrderDetailRepository;
import cmcglobal.vn.ecommerce.repository.OrdersRepository;
import cmcglobal.vn.ecommerce.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    public final UserRepository userRepository;
    public final OrderDetailRepository orderDetailRepository;
    public final CartRepository cartRepository;
    public final OrdersRepository ordersRepository;

    public OrdersService(UserRepository userRepository, OrderDetailRepository orderDetailRepository,
                         CartRepository cartRepository, OrdersRepository ordersRepository) {
        this.userRepository = userRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.cartRepository = cartRepository;
        this.ordersRepository = ordersRepository;
    }
    public OrdersEntity createdOrder(OrdersDTO ordersDTO, long userId) {
        Collection<CartEntity> cartEntities = cartRepository.findCartByUserId(userId);
        OrdersEntity ordersEntity = new OrdersEntity();
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if (userEntityOptional.isPresent()) {
            ordersEntity.setUserByUserId(userEntityOptional.get());
            ordersEntity.setShipName(ordersDTO.getShipName());
            ordersEntity.setShipAddress(ordersDTO.getShipAddress());
            ordersEntity.setBillingAddress(ordersDTO.getBillingAddress());
            ordersEntity.setCity(ordersDTO.getCity());
            ordersEntity.setState(ordersDTO.getState());
            ordersEntity.setZip(ordersDTO.getZip());
            ordersEntity.setCountry(ordersDTO.getCountry());
            ordersEntity.setPhone(ordersDTO.getPhone());
            ordersEntity.setTotalPrice(ordersDTO.getTotalPrice());
            ordersEntity.setTotalCargoPrice(ordersDTO.getTotalCargoPrice());
            ordersEntity.setDate(ordersDTO.getDate());
            ordersEntity.setShipped(ordersDTO.getShipped());
            ordersEntity.setCargoFirm(ordersDTO.getCargoFirm());
            ordersEntity.setTrackingNumber(ordersDTO.getTrackingNumber());
            OrdersEntity ordersResult = ordersRepository.save(ordersEntity);
            Optional<CartEntity> cartEntityOptional = cartEntities.stream().findFirst();
            if (cartEntityOptional.isPresent()) {
                CartEntity cart = cartEntityOptional.get();
                Collection<CartItemEntity> cartItemEntities = cart.getCartItemsById();
                List<CartItemEntity> cartItemEntityList = cartItemEntities.stream().toList();
                cartItemEntityList.forEach(cartItemEntity -> {
                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                    orderDetailEntity.setOrdersByOrderId(ordersResult);
                    orderDetailEntity.setProductVariantByProductVariantId(cartItemEntity.getProductVariantByProductVariantId());
//                    orderDetailEntity.setAmount(cartItemEntity.getProductVariantByProductVariantId().getPrice());
                    orderDetailRepository.save(orderDetailEntity);
                });
            }
            return ordersResult;
        }
       return null;
    }
    public List<OrdersDTO> getAllOrders() {
        List<OrdersEntity> ordersEntities = ordersRepository.findAll();
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        ordersEntities.forEach(ordersEntity -> {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setShipName(ordersEntity.getShipName());
            ordersDTO.setShipAddress(ordersEntity.getShipAddress());
            ordersDTO.setBillingAddress(ordersEntity.getBillingAddress());
            ordersDTO.setCity(ordersEntity.getCity());
            ordersDTO.setState(ordersEntity.getState());
            ordersDTO.setZip(ordersEntity.getZip());
            ordersDTO.setCountry(ordersEntity.getCountry());
            ordersDTO.setPhone(ordersEntity.getPhone());
            ordersDTO.setTotalPrice(ordersEntity.getTotalPrice());
            ordersDTO.setTotalCargoPrice(ordersEntity.getTotalCargoPrice());
            ordersDTO.setDate(ordersEntity.getDate());
            ordersDTO.setShipped(ordersEntity.getShipped());
            ordersDTO.setCargoFirm(ordersEntity.getCargoFirm());
            ordersDTO.setTrackingNumber(ordersEntity.getTrackingNumber());

            ordersDTOList.add(ordersDTO);
        });
        return ordersDTOList;
    }
    public OrdersDTO getOrderByUser(long user) {
        Optional<OrdersEntity> ordersEntityOptional = ordersRepository.findById(user);
        OrdersDTO ordersDTO = new OrdersDTO();
        if (ordersEntityOptional.isPresent()) {
            ordersDTO.setShipName(ordersEntityOptional.get().getShipName());
            ordersDTO.setShipAddress(ordersEntityOptional.get().getShipAddress());
            ordersDTO.setBillingAddress(ordersEntityOptional.get().getBillingAddress());
            ordersDTO.setCity(ordersEntityOptional.get().getCity());
            ordersDTO.setState(ordersEntityOptional.get().getState());
            ordersDTO.setZip(ordersEntityOptional.get().getZip());
            ordersDTO.setCountry(ordersEntityOptional.get().getCountry());
            ordersDTO.setPhone(ordersEntityOptional.get().getPhone());
            ordersDTO.setTotalPrice(ordersEntityOptional.get().getTotalPrice());
            ordersDTO.setTotalCargoPrice(ordersEntityOptional.get().getTotalCargoPrice());
            ordersDTO.setDate(ordersEntityOptional.get().getDate());
            ordersDTO.setShipped(ordersEntityOptional.get().getShipped());
            ordersDTO.setCargoFirm(ordersEntityOptional.get().getCargoFirm());
            ordersDTO.setTrackingNumber(ordersEntityOptional.get().getTrackingNumber());
        }
        return ordersDTO;
    }

    public List<OrdersDTO> getOrderByUser(long userId, int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<OrdersEntity> ordersEntities = ordersRepository.findByUserByUserId(userId, paging);
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        List<OrdersEntity> ordersEntityList = ordersEntities.getContent();
        ordersEntityList.forEach(ordersEntity -> {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setShipName(ordersEntity.getShipName());
            ordersDTO.setShipAddress(ordersEntity.getShipAddress());
            ordersDTO.setBillingAddress(ordersEntity.getBillingAddress());
            ordersDTO.setCity(ordersEntity.getCity());
            ordersDTO.setState(ordersEntity.getState());
            ordersDTO.setZip(ordersEntity.getZip());
            ordersDTO.setCountry(ordersEntity.getCountry());
            ordersDTO.setPhone(ordersEntity.getPhone());
            ordersDTO.setTotalPrice(ordersEntity.getTotalPrice());
            ordersDTO.setTotalCargoPrice(ordersEntity.getTotalCargoPrice());
            ordersDTO.setDate(ordersEntity.getDate());
            ordersDTO.setShipped(ordersEntity.getShipped());
            ordersDTO.setCargoFirm(ordersEntity.getCargoFirm());
            ordersDTO.setTrackingNumber(ordersEntity.getTrackingNumber());
            ordersDTOList.add(ordersDTO);
        });
        return ordersDTOList;
    }

    public List<OrdersDTO> filterOrder(String shipName, String shipAddress, String billingAddress,  int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Collection<OrdersEntity> ordersEntities = ordersRepository.filterOrder(shipName, shipAddress, billingAddress);
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        List<OrdersEntity> ordersEntityList = ordersEntities.stream().toList();
        ordersEntityList.forEach(ordersEntity -> {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setShipName(ordersEntity.getShipName());
            ordersDTO.setShipAddress(ordersEntity.getShipAddress());
            ordersDTO.setBillingAddress(ordersEntity.getBillingAddress());
            ordersDTO.setCity(ordersEntity.getCity());
            ordersDTO.setState(ordersEntity.getState());
            ordersDTO.setZip(ordersEntity.getZip());
            ordersDTO.setCountry(ordersEntity.getCountry());
            ordersDTO.setPhone(ordersEntity.getPhone());
            ordersDTO.setTotalPrice(ordersEntity.getTotalPrice());
            ordersDTO.setTotalCargoPrice(ordersEntity.getTotalCargoPrice());
            ordersDTO.setDate(ordersEntity.getDate());
            ordersDTO.setShipped(ordersEntity.getShipped());
            ordersDTO.setCargoFirm(ordersEntity.getCargoFirm());
            ordersDTO.setTrackingNumber(ordersEntity.getTrackingNumber());
            ordersDTOList.add(ordersDTO);
        });
        return ordersDTOList;
    }
}
