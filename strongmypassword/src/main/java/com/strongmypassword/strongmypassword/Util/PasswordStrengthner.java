package com.strongmypassword.strongmypassword.Util;

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
        if (dictionary.containsKey(c)) {
        char lowChar = c;
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


}
