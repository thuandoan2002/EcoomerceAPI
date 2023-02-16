package cmcglobal.vn.ecommerce.controller;

import cmcglobal.vn.ecommerce.dto.UserDTO;
import cmcglobal.vn.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/{userId}"})
    public UserDTO getUserById(@PathVariable(name = "userId") long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public ResponseEntity addUser(@Valid @RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok().body(userDTO);
    }

    @PutMapping("/{userId}")
    public ResponseEntity updateUser(@PathVariable(name = "userId") Integer userId,@Valid @RequestBody UserDTO userDTO) {
        userService.updateUserById(userId, userDTO);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable(name = "userId") Integer userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
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
    @GetMapping({"/filter"})
    public ResponseEntity<List<UserDTO>> filterUser( @RequestParam(required = false) String email,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "3") int size) {

       List<UserDTO> userDTOS = userService.filterUser(email, page, size);
       return ResponseEntity.ok().body(userDTOS);
    }

}
