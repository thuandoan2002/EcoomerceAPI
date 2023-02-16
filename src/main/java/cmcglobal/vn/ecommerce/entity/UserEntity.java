package cmcglobal.vn.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "eCommerce", catalog = "")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "email", nullable = false, length = 500)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 500)
    private String password;
    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 50)
    private String lastName;
    @Basic
    @Column(name = "city", nullable = true, length = 90)
    private String city;
    @Basic
    @Column(name = "state", nullable = true, length = 20)
    private String state;
    @Basic
    @Column(name = "zip", nullable = true, length = 12)
    private String zip;
    @Basic
    @Column(name = "email_verified", nullable = true)
    private Byte emailVerified;
    @Basic
    @Column(name = "registration_date", nullable = true)
    private LocalDateTime registrationDate;
    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    private String phone;
    @Basic
    @Column(name = "country", nullable = true, length = 20)
    private String country;
    @Basic
    @Column(name = "address", nullable = true, length = 100)
    private String address;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<CartEntity> cartsById;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<OrdersEntity> ordersById;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<PasswordResetTokenEntity> passwordResetTokensById;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<VerificationTokenEntity> verificationTokensById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Byte getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Byte emailVerified) {
        this.emailVerified = emailVerified;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zip, that.zip) && Objects.equals(emailVerified, that.emailVerified) && Objects.equals(registrationDate, that.registrationDate) && Objects.equals(phone, that.phone) && Objects.equals(country, that.country) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, firstName, lastName, city, state, zip, emailVerified, registrationDate, phone, country, address);
    }

    public Collection<CartEntity> getCartsById() {
        return cartsById;
    }

    public void setCartsById(Collection<CartEntity> cartsById) {
        this.cartsById = cartsById;
    }

    public Collection<OrdersEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrdersEntity> ordersById) {
        this.ordersById = ordersById;
    }

    public Collection<PasswordResetTokenEntity> getPasswordResetTokensById() {
        return passwordResetTokensById;
    }

    public void setPasswordResetTokensById(Collection<PasswordResetTokenEntity> passwordResetTokensById) {
        this.passwordResetTokensById = passwordResetTokensById;
    }

    public Collection<VerificationTokenEntity> getVerificationTokensById() {
        return verificationTokensById;
    }

    public void setVerificationTokensById(Collection<VerificationTokenEntity> verificationTokensById) {
        this.verificationTokensById = verificationTokensById;
    }
}
