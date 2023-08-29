package org.js9.util;

import org.js9.model.StaffType;

import java.security.SecureRandom;

public class RandomAlphaNumericGenerator {
    private static final String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";


    public static String generateRandomAlphaNumeric(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALPHANUMERIC_CHARS.length());
            char randomChar = ALPHANUMERIC_CHARS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

    public static String generateRandomAlphaNumericForStaff(StaffType staffType, int staffCount) {

        StringBuilder sb = new StringBuilder(staffType.getValue());

        //This method can be synchronized
            if(staffCount >= 100){
                sb.append(staffCount);
            }else{
                sb.append("0").append(staffCount);
            }


        return sb.toString();
    }
    public static void main(String[] args) {
//        String randomRef = generateRandomAlphaNumericForStaff(StaffType.MANAGER, 1);
//        System.out.println("Random Reference: " + randomRef);

        System.out.println("S/N          Item                              Qty          ");
    }
}

