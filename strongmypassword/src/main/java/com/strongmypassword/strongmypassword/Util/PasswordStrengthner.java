package com.strongmypassword.strongmypassword.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PasswordStrengthner {

    //dictionary
  private static final Map<Character, List<String>> dictionary = Map.ofEntries(
    Map.entry('a', List.of("a","A","@", "4", "à", "á")),
    Map.entry('b', List.of("b","8", "ß", "B")),
    Map.entry('c', List.of("c","C","(", "<", "¢")),
    Map.entry('d', List.of("d","D", ")", "đ")),
    Map.entry('e', List.of("e","E","3", "€", "ë")),
    Map.entry('f', List.of("f","F","ƒ", "#", "F")),
    Map.entry('g', List.of("g","9", "&", "G")),
    Map.entry('h', List.of("#", "h", "H")),
    Map.entry('i', List.of("i","I","1", "!", "|", "í")),
    Map.entry('j', List.of("j","¿", "J")),
    Map.entry('k', List.of("k", "X", "K")),
    Map.entry('l', List.of("l","L","1", "|", "£")),
    Map.entry('m', List.of("m","M","^^", "M", "₥")),
    Map.entry('n', List.of("n", "И", "N")),
    Map.entry('o', List.of("o","O","0", "°", "ø")),
    Map.entry('p', List.of("p","P","¶", "9", "P")),
    Map.entry('q', List.of("q","Q","9", "Q", "&")),
    Map.entry('r', List.of("r","R","2", "®", "R")),
    Map.entry('s', List.of("s","S","$", "5", "§")),
    Map.entry('t', List.of("t","T","7", "+", "†")),
    Map.entry('u', List.of("U","µ", "Ü", "u")),
    Map.entry('v', List.of("v", "V", "√")),
    Map.entry('w', List.of("w", "W", "Ш")),
    Map.entry('x', List.of("%", "x", "X")),
    Map.entry('y', List.of("y","¥", "j", "Y")),
    Map.entry('z', List.of("z","2", "Z", "ƶ"))
);

public String ChangeCharacters(String WeakPassword){

    StringBuilder StrongPassword = new StringBuilder(); //build a new password char by char 
    Random random = new Random(); //generator of ramdom numbers to choice strong char
    char[] arrayChars = WeakPassword.toCharArray(); //transform String in array

    for (char c: arrayChars) {
        char lowChar = Character.toLowerCase(c);
        if (dictionary.containsKey(lowChar)) {
        List<String> substitutions = dictionary.get(lowChar);
        String newChar = substitutions.get(random.nextInt(substitutions.size()));
        StrongPassword.append(newChar);
        }
        else{
            StrongPassword.append(c);
        }
    }

    return StrongPassword.toString();
}

public String ShuffleNumbersSequence(String WeakPassword){

    StringBuilder StrongPassword = new StringBuilder(); //build a new password char by char 
    Random random = new Random(); //generator of ramdom numbers to choice strong char
    char[] arrayChars = WeakPassword.toCharArray(); //transform String in array
    List<Character> numbersList = new ArrayList<>();;
    for (char c : arrayChars){
        if (Character.isDigit(c)) {
            numbersList.add(c);
        }
        else{
            while (!numbersList.isEmpty()) {
                int randomIndex = random.nextInt(numbersList.size());
                StrongPassword.append(numbersList.get(randomIndex));
                numbersList.remove(randomIndex);
            }
        StrongPassword.append(c);
        }     
    }
    //IF THE PASSWORD END WITH NUMBERS 
    while (!numbersList.isEmpty()) {
    int randomIndex = random.nextInt(numbersList.size());
    StrongPassword.append(numbersList.get(randomIndex));
    numbersList.remove(randomIndex);
}
    return StrongPassword.toString();
}

public String MinOneUperCharacter(String WeakPassword){
    char[] arrayChars = WeakPassword.toCharArray();
      for (int i = 0; i < arrayChars.length; i++) {
        if (Character.isLowerCase(arrayChars[i])) {
            arrayChars[i] = Character.toUpperCase(arrayChars[i]);
            return new String(arrayChars);
        }
    }

    Random random = new Random();
    char randomUpper = (char) (random.nextInt(26) + 'A');
    return randomUpper + WeakPassword + randomUpper;

}
public String MinOneLowerCharacter(String WeakPassword){
    char[] arrayChars = WeakPassword.toCharArray();
      for (int i = 0; i < arrayChars.length; i++) {
        if (Character.isUpperCase(arrayChars[i])) {
            arrayChars[i] = Character.toLowerCase(arrayChars[i]);
            return new String(arrayChars);
        }
    }

    Random random = new Random();
    char randomLower = (char) (random.nextInt(26) + 'a');
    return randomLower + WeakPassword + randomLower;

}

public String MinOneNumber(String WeakPassword){
    
    Random random = new Random();
    Long number = random.nextLong(1000,9999);
    return WeakPassword + number;

}

public String MinLength(String WeekPassword, int minLength){
    
    StringBuilder result = new StringBuilder(WeekPassword);
    Random random = new Random();
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";

    while (result.length() < minLength) {
        char randomChar = chars.charAt(random.nextInt(chars.length()));
        result.append(randomChar);
    }

    return result.toString();
}

}
