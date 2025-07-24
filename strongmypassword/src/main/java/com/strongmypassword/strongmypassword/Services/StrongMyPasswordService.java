package com.strongmypassword.strongmypassword.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.strongmypassword.strongmypassword.Util.PasswordStrengthner;
import com.strongmypassword.strongmypassword.Util.PasswordValidator;
import com.strongmypassword.strongmypassword.dto.PasswordDTO;


@Service
public class StrongMyPasswordService {
    @Autowired
    PasswordStrengthner passwordStrengthner;
    @Autowired
    PasswordValidator passwordValidator;
    
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

}
