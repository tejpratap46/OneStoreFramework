package com.brainstrom.onestoreframework.encryption;

import com.brainstrom.onestoreframework.config.Config;

public class PrettyGoodPrivacy {
    public static String encryptDecrypt(String input) {
        String key = Config.ENCRYPTION_KEY;
        // int key= 5;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.codePointAt(i) ^ Integer
                    .parseInt(Character.toString(key.charAt(i)))));
            // output.append((char) (input.charAt(i) ^ key));
        }
        return output.toString();
    }

//    uses :
//    String encrypted = PrettyGoodPrivacy.encryptDecrypt("tejpratapsingh");
//    System.out.println("Encrypted:" + encrypted);
//    String decrypted = PrettyGoodPrivacy.encryptDecrypt(encrypted);
//    System.out.println("Decrypted:" + decrypted);
}
