package cmcglobal.vn.ecommerce.controller;

import cmcglobal.vn.ecommerce.dto.OauthCodeDTO;
import cmcglobal.vn.ecommerce.entity.OauthCodeEntity;
import cmcglobal.vn.ecommerce.service.OauthCodeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/code"})
public class OauthCodeController {
    private final OauthCodeService oauthCodeService;


    public OauthCodeController(OauthCodeService oauthCodeService) {
        this.oauthCodeService = oauthCodeService;
    }

    @GetMapping({"/{oauthCode}"})
    public OauthCodeDTO findOauthCode(@PathVariable(name = "oauthCode") String oauthCode) {
        return oauthCodeService.findOauthCode(oauthCode);
    }
    @PostMapping
    public ResponseEntity<OauthCodeEntity> addOauthCode(@Valid @RequestBody OauthCodeDTO oauthCodeDTO) {
        OauthCodeEntity oauthCodeEntity = oauthCodeService.createOauthCode(oauthCodeDTO);
        return ResponseEntity.ok(oauthCodeEntity);
    }
    @PutMapping({"/{code}"})
    public ResponseEntity updateOauthCode(@PathVariable(name = "code") String code, @Valid @RequestBody OauthCodeDTO oauthCodeDTO) {
        oauthCodeService.updateOauthCode(code, oauthCodeDTO );
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("{code}")
    public ResponseEntity deleteOauthCode(@PathVariable(name = "code") String oauthCode) {
        oauthCodeService.deleteOauthCode(oauthCode);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    public  ResponseEntity<List<OauthCodeDTO>> filterOauthCode(@RequestParam(required = false) String code,
                                                           @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "3") int size) {
        List<OauthCodeDTO> oauthCodeDTOS = oauthCodeService.filterOauthCode(code, page, size);
        return ResponseEntity.ok().body(oauthCodeDTOS);
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
}
