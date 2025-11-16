package com.strongmypassword.strongmypassword.Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void verifySizeDeveRetornarTrueQuandoSenhaMaiorOuIgualMinimo() {
        assertTrue(validator.VerifySize("abcdef", 6));
        assertTrue(validator.VerifySize("abcdefg", 6));
    }

    @Test
    void verifySizeDeveRetornarFalseQuandoSenhaMenorQueMinimo() {
        assertFalse(validator.VerifySize("abc", 6));
    }

    @Test
    void verifyNumbersDeveRetornarTrueQuandoTemNumero() {
        assertTrue(validator.VerifyNumbers("abc1def"));
    }

    @Test
    void verifyNumbersDeveRetornarFalseQuandoNaoTemNumero() {
        assertFalse(validator.VerifyNumbers("abcdef"));
    }

    @Test
    void verifyEspecialCharacterDeveRetornarTrueQuandoTemEspecial() {
        assertTrue(validator.VerifyEspecialCharacter("abc!def"));
    }

    @Test
    void verifyEspecialCharacterDeveRetornarFalseQuandoNaoTemEspecial() {
        assertFalse(validator.VerifyEspecialCharacter("abcdef1"));
    }

    @Test
    void verifyUperDeveRetornarTrueQuandoTemLetraMaiuscula() {
        assertTrue(validator.VerifyUper("abcDef"));
    }

    @Test
    void verifyUperDeveRetornarFalseQuandoNaoTemLetraMaiuscula() {
        assertFalse(validator.VerifyUper("abcdef"));
    }
}
