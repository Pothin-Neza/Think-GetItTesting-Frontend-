package com.thinkgetit.backend.Utilities;

public class Utils {

    public static String generateUniqueEmail(String prefix) {
        return prefix + "_" + System.currentTimeMillis() + "@othin.com";
    }

    public static String generateSecurePassword() {
        return "SecurePass" + System.currentTimeMillis() + "!";
    }
}
