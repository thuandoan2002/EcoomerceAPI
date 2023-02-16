package cmcglobal.vn.ecommerce.service;

import cmcglobal.vn.ecommerce.dto.UserDTO;
import cmcglobal.vn.ecommerce.entity.UserEntity;
import cmcglobal.vn.ecommerce.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDTO getUserById(long userId) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        UserDTO userDTO = new UserDTO();
        if (userEntityOptional.isPresent()) {

            userDTO.setCity(userEntityOptional.get().getCity());
            userDTO.setCountry(userEntityOptional.get().getCountry());
            userDTO.setAddress(userEntityOptional.get().getAddress());
            userDTO.setEmail(userEntityOptional.get().getEmail());
            userDTO.setEmailVeryfied(userEntityOptional.get().getEmailVerified());
            userDTO.setPhone(userEntityOptional.get().getPhone());
            userDTO.setZip(userEntityOptional.get().getZip());
            userDTO.setState(userEntityOptional.get().getState());
            userDTO.setFirstName(userEntityOptional.get().getFirstName());
            userDTO.setLastName(userEntityOptional.get().getLastName());
            userDTO.setRegistrationDate(userEntityOptional.get().getRegistrationDate());
        }
        return userDTO;
    }
    public UserEntity createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setCity(userDTO.getCity());
        userEntity.setCountry(userDTO.getCountry());
        userEntity.setAddress(userDTO.getAddress());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setEmailVerified((byte) userDTO.getEmailVeryfied());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setZip(userDTO.getZip());
        userEntity.setState(userDTO.getState());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setPassword(userDTO.getPassword());
        return userRepository.save(userEntity);
    }
    public void updateUserById(long userId, UserDTO userDTO) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        UserEntity userEntity = userEntityOptional.get();
        userEntity.setCity(userDTO.getCity());
        userEntity.setCountry(userDTO.getCountry());
        userEntity.setAddress(userDTO.getAddress());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setEmailVerified((byte) userDTO.getEmailVeryfied());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setZip(userDTO.getZip());
        userEntity.setState(userDTO.getState());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userRepository.save(userEntity);
    }
    public void deleteUserById(long userId) {
        userRepository.deleteById(userId);
    }
    public List<UserDTO> filterUser(String email, int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<UserEntity> userEntities = userRepository.findByEmailIsContaining(email, paging);
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> userEntityList = userEntities.getContent();
        userEntityList.forEach(userEntity -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setCity(userEntity.getCity());
            userDTO.setCountry(userEntity.getCountry());
            userDTO.setAddress(userEntity.getAddress());
            userDTO.setEmail(userEntity.getEmail());
            userDTO.setEmailVeryfied(userEntity.getEmailVerified());
            userDTO.setPhone(userEntity.getPhone());
            userDTO.setZip(userEntity.getZip());
            userDTO.setState(userEntity.getState());
            userDTO.setFirstName(userEntity.getFirstName());
            userDTO.setLastName(userEntity.getLastName());
            userDTO.setRegistrationDate(userEntity.getRegistrationDate());

            userDTOList.add(userDTO);
        });
        return userDTOList;

    }


}
