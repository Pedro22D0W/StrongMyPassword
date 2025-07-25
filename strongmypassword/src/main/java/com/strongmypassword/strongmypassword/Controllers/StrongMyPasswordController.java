package com.strongmypassword.strongmypassword.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.strongmypassword.strongmypassword.Services.StrongMyPasswordService;
import com.strongmypassword.strongmypassword.dto.PasswordDTO;
import com.strongmypassword.strongmypassword.dto.SeedsDTO;

@RestController
public class StrongMyPasswordController {

    @Autowired
    StrongMyPasswordService strongMyPasswordService;
    @GetMapping("/strongme")
        public ResponseEntity<String>StrongMe(@RequestBody PasswordDTO password){
        
        String newPassword = strongMyPasswordService.Strengthner(password);
        return ResponseEntity.ok().body(newPassword);
    }

    @GetMapping("/seedmypassword")
    public ResponseEntity<String> SeedMyPassword(@RequestBody SeedsDTO seeds){
        String password = strongMyPasswordService.HashFromSeeds(seeds);
        return ResponseEntity.ok().body(password);
    }
    
}
