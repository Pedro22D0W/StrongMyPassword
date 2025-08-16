package com.strongmypassword.strongmypassword.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.strongmypassword.strongmypassword.Services.StrongMyPasswordService;
import com.strongmypassword.strongmypassword.dto.PasswordDTO;
import com.strongmypassword.strongmypassword.dto.SeedsDTO;

@RestController
public class StrongMyPasswordController {

    @Autowired
    StrongMyPasswordService strongMyPasswordService;
    @PostMapping("/strongme")
        public ResponseEntity<String>StrongMe(@RequestBody PasswordDTO password){
        
        String newPassword = strongMyPasswordService.Strengthner(password);
        System.out.println(newPassword);
        return ResponseEntity.ok().body(newPassword);
    }

    @PostMapping("/seedmypassword")
    public ResponseEntity<String> SeedMyPassword(@RequestBody SeedsDTO seeds){
        String password = strongMyPasswordService.HashFromSeeds(seeds);
        return ResponseEntity.ok().body(password);
    }
    
}
