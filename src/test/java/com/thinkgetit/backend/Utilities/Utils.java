package com.thinkgetit.backend.Utilities;

import java.util.Random;

public class Utils {

    public static String generateUniqueEmail(String prefix) {
        return prefix + "_" + System.currentTimeMillis() + "@othin.com";
    }

    public static String generateSecurePassword() {
        return "SecurePass" + System.currentTimeMillis() + "!";
    }

    public static String generateRandomStreet() {
        return (new Random().nextInt(998) + 1) + " Dynamic Automation Way";
    }

    public static String generateRandomPostalCode() {
        return (new Random().nextInt(89999) + 10000) + "";
    }

    public static String generateRandomPhone() {
        return "+9" + (new Random().nextInt(899999999) + 100000000);
    }
}
