package com.strongmypassword.strongmypassword.Services;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.strongmypassword.strongmypassword.Util.PasswordStrengthner;
import com.strongmypassword.strongmypassword.Util.PasswordValidator;
import com.strongmypassword.strongmypassword.dto.PasswordDTO;
import com.strongmypassword.strongmypassword.dto.SeedsDTO;



@Service
public class StrongMyPasswordService {
    @Autowired
    PasswordStrengthner passwordStrengthner;
    @Autowired
    PasswordValidator passwordValidator;
    @Autowired
    PasswordEncoder passwordEncoder;
    
    public String Strengthner(PasswordDTO WeakPassword){
        String StrogerPassword = WeakPassword.password();

        if (!passwordValidator.VerifySize(WeakPassword.password(),WeakPassword.minLength())) {
            StrogerPassword = passwordStrengthner.MinLength(StrogerPassword,WeakPassword.minLength());
        }

        StrogerPassword = passwordStrengthner.ShuffleNumbersSequence(StrogerPassword);
        StrogerPassword = passwordStrengthner.ChangeCharacters(StrogerPassword);

        if (WeakPassword.requireNumber()) {
            if (!passwordValidator.VerifyNumbers(StrogerPassword)) {
              StrogerPassword = passwordStrengthner.MinOneNumber(StrogerPassword);
            }
        }
        if (WeakPassword.requireSpecialChar()) {
            if (!passwordValidator.VerifyEspecialCharacter(StrogerPassword)) {
                while (!passwordValidator.VerifyEspecialCharacter(StrogerPassword)) {
                    StrogerPassword = passwordStrengthner.ChangeCharacters(StrogerPassword);
                }
            }
        }
        if (WeakPassword.requireUppercase()) {
            if (!passwordValidator.VerifyUper(StrogerPassword)) {
               StrogerPassword = passwordStrengthner.MinOneUperCharacter(StrogerPassword);
            }
        }
       
    return StrogerPassword;

    }

    public String HashFromSeeds(SeedsDTO seeds){
       try {
         StringBuilder concatenatedSeeds = new StringBuilder();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        for(String s:seeds.seeds()){
            concatenatedSeeds.append(s.toLowerCase());
        }
       byte[] hashBytes = digest.digest(concatenatedSeeds.toString().getBytes(StandardCharsets.UTF_8));
       return Base64.getEncoder().encodeToString(hashBytes);
       } catch (Exception e) {
         throw new RuntimeException("Erro ao gerar SHA-256", e);
       }
        
    }
}
