package org.js9.model;

import java.security.SecureRandom;

public class BaseEntity {
    private String ref;

    public BaseEntity() {
        this.ref = generateRandomAlphaNumeric();
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String generateRandomAlphaNumeric() {

         final String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
         final int LENGTH = 8;
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(ALPHANUMERIC_CHARS.length());
            char randomChar = ALPHANUMERIC_CHARS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        return "BaseEntity{" +
                "ref='" + ref + '\'' +
                '}';
    }
}
