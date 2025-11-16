package com.strongmypassword.strongmypassword.Util;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

    public boolean VerifySize(String password,int minSize){
        return password.length() >= minSize;
    }
    public boolean VerifyNumbers(String password){
        return password.matches(".*\\d.*");
    }
    public boolean VerifyEspecialCharacter(String password){
        return password.matches(".*[!@#\\$%\\^&\\*()_\\+=\\[\\]{};:'\"\\\\|,.<>/?¢€£ƒ¶®§†µÜ√ß¿ø¥ƶàáëđ].*");
    }
    public boolean VerifyUper(String password){
        return password.matches(".*[A-Z].*");
    }

}
