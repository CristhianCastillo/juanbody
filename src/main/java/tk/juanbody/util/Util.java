package tk.juanbody.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Util {

    public static String hashPassword(String clearTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] byteFromStr = clearTextPassword.getBytes(Charset.forName("UTF-8"));
            md.update(byteFromStr);
            Base64.Encoder base64Encoder = Base64.getEncoder().withoutPadding();
            return base64Encoder.encodeToString(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
