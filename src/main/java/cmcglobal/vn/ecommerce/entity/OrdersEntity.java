package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "ship_name", nullable = false, length = 100)
    private String shipName;
    @Basic
    @Column(name = "ship_address", nullable = false, length = 100)
    private String shipAddress;
    @Basic
    @Column(name = "billing_address", nullable = false, length = 100)
    private String billingAddress;
    @Basic
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    @Basic
    @Column(name = "state", nullable = false, length = 50)
    private String state;
    @Basic
    @Column(name = "zip", nullable = true, length = 20)
    private String zip;
    @Basic
    @Column(name = "country", nullable = false, length = 50)
    private String country;
    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @Basic
    @Column(name = "total_price", nullable = false, precision = 0)
    private double totalPrice;
    @Basic
    @Column(name = "total_cargo_price", nullable = false, precision = 0)
    private double totalCargoPrice;
    @Basic
    @Column(name = "date", nullable = false)
    private LocalDateTime date;
    @Basic
    @Column(name = "shipped", nullable = false)
    private byte shipped;
    @Basic
    @Column(name = "cargo_firm", nullable = true, length = 100)
    private String cargoFirm;
    @Basic
    @Column(name = "tracking_number", nullable = true, length = 80)
    private String trackingNumber;
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<OrderDetailEntity> orderDetailsById;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private DiscountEntity discountByDiscountId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalCargoPrice() {
        return totalCargoPrice;
    }

    public void setTotalCargoPrice(double totalCargoPrice) {
        this.totalCargoPrice = totalCargoPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public byte getShipped() {
        return shipped;
    }

    public void setShipped(byte shipped) {
        this.shipped = shipped;
    }

    public String getCargoFirm() {
        return cargoFirm;
    }

    public void setCargoFirm(String cargoFirm) {
        this.cargoFirm = cargoFirm;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return id == that.id  && Double.compare(that.totalPrice, totalPrice) == 0 && Double.compare(that.totalCargoPrice, totalCargoPrice) == 0 && shipped == that.shipped && Objects.equals(shipName, that.shipName) && Objects.equals(shipAddress, that.shipAddress) && Objects.equals(billingAddress, that.billingAddress) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zip, that.zip) && Objects.equals(country, that.country) && Objects.equals(phone, that.phone)  && Objects.equals(date, that.date) && Objects.equals(cargoFirm, that.cargoFirm) && Objects.equals(trackingNumber, that.trackingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shipName, shipAddress, billingAddress, city, state, zip, country, phone, totalPrice, totalCargoPrice, date, shipped, cargoFirm, trackingNumber);
    }

    public Collection<OrderDetailEntity> getOrderDetailsById() {
        return orderDetailsById;
    }

    public void setOrderDetailsById(Collection<OrderDetailEntity> orderDetailsById) {
        this.orderDetailsById = orderDetailsById;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public DiscountEntity getDiscountByDiscountId() {
        return discountByDiscountId;
    }

    public void setDiscountByDiscountId(DiscountEntity discountByDiscountId) {
        this.discountByDiscountId = discountByDiscountId;
    }
}
