package com.strongmypassword.strongmypassword.dto;

public record PasswordDTO(String password,int minLength,boolean requireUppercase,boolean requireNumber,boolean requireSpecialChar) {

}
