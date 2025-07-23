package com.strongmypassword.strongmypassword.Controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.strongmypassword.strongmypassword.dto.PasswordDTO;
import com.strongmypassword.strongmypassword.dto.SeedsDTO;

@RestController
public class StrongMyPasswordController {

    @GetMapping("/strongme")
        public ResponseEntity<String>StrongMe(@RequestBody PasswordDTO password){
        String receved_password = "senha recebida = " + password.password();
        return ResponseEntity.ok().body(receved_password);
    }

    @GetMapping("/seedmypassword")
    public ResponseEntity<String> SeedMyPassword(@RequestBody SeedsDTO seeds){
        String password = seeds.seeds().get(1);
        return ResponseEntity.ok().body(password);
    }
    
}
