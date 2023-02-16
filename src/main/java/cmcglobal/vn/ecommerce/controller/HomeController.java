package cmcglobal.vn.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping({"/"})
    public ResponseEntity<String> home() {
        return ResponseEntity.ok().body("thuan");
    }


}
