package com.konark.basky.utils;

import org.passay.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserPasswordGenerator {

    CharacterData specialChars = new CharacterData() {
        public String getErrorCode() {
            return "100";
        }

        public String getCharacters() {
            return "!@#$%^&*()_+";
        }
    };

    List rules = Arrays.asList(

            // at least one upper-case character
            new CharacterRule(EnglishCharacterData.UpperCase, 2),

            // at least one lower-case character
            new CharacterRule(EnglishCharacterData.LowerCase, 4),

            // at least one digit character
            new CharacterRule(EnglishCharacterData.Digit, 1),

            // at least one symbol (special character)
            new CharacterRule(specialChars, 1)

    );

    public String generatePassword() {
        PasswordGenerator generator = new PasswordGenerator();
        String password = generator.generatePassword(8, rules);
        return password;
    }

}
