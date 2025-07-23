package com.strongmypassword.strongmypassword.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strongmypassword.strongmypassword.Util.PasswordStrengthner;


@Service
public class StrongMyPasswordService {
    @Autowired
    PasswordStrengthner passwordStrengthner;
    
    public String Strengthner(String WeakPassword){
        String StrogerPassword = passwordStrengthner.ChangeCharacters(WeakPassword);
        return StrogerPassword;
    }

}
