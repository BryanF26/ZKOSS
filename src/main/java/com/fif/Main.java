package com.fif;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {
    public static void main(String[] args){
        String encryptedPass = passwordEncoder().encode("admin");
        System.out.println(encryptedPass);
        System.out.println(encryptedPass);
    }

    public static PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
    }
}
