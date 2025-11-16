package com.strongmypassword.strongmypassword.Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthnerTest {

    PasswordStrengthner strengthner = new PasswordStrengthner();

    @Test
    void changeCharactersMantemTamanhoDaSenha() {
        String weak = "abcxyz";
        String strong = strengthner.ChangeCharacters(weak);

        assertEquals(weak.length(), strong.length());
    }


    @Test
    void shuffleNumbersSequenceMantemQuantidadeDeDigitos() {
        String weak = "ab123cd45";
        String strong = strengthner.ShuffleNumbersSequence(weak);

        long originalDigits = weak.chars().filter(Character::isDigit).count();
        long newDigits = strong.chars().filter(Character::isDigit).count();

        assertEquals(originalDigits, newDigits);
        assertEquals(weak.length(), strong.length());
    }

    @Test
    void minOneUperCharacterDeveAdicionarLetraMaiusculaQuandoNaoTemLower() {
        String weak = "1234";
        String strong = strengthner.MinOneUperCharacter(weak);

        // como não há minúsculas, cai no else → acrescenta 2 chars
        assertTrue(strong.length() >= weak.length() + 2);
        assertTrue(strong.chars().anyMatch(Character::isUpperCase));
    }

    @Test
    void minOneUperCharacterConvertePrimeiraMinusculaParaMaiuscula() {
        String weak = "abc123";
        String strong = strengthner.MinOneUperCharacter(weak);

        assertTrue(strong.chars().anyMatch(Character::isUpperCase));
        assertEquals(weak.length(), strong.length());
    }

    @Test
    void minOneLowerCharacterDeveAdicionarLetraMinusculaQuandoNaoTemUpper() {
        String weak = "1234";
        String strong = strengthner.MinOneLowerCharacter(weak);

        assertTrue(strong.length() >= weak.length() + 2);
        assertTrue(strong.chars().anyMatch(Character::isLowerCase));
    }

    @Test
    void minOneNumberSempreGeraNumeroNoFinal() {
        String weak = "Abc!";
        String strong = strengthner.MinOneNumber(weak);

        assertTrue(strong.length() > weak.length());
        String suffix = strong.substring(weak.length());
        assertTrue(suffix.matches("\\d+"));
    }
}
