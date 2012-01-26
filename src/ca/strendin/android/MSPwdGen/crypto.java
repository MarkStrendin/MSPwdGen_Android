package ca.strendin.android.MSPwdGen;
import java.io.UnsupportedEncodingException; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class crypto {
    
    public static String hash(String salt, String input) {
        String returnMe = "";
        try {
            returnMe = SHA1(input + salt);
        } catch (Exception ex) {
            returnMe = "ERROR: " + ex;            
        }
        return returnMe;
    }
    
    private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    } 
    
    public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException { 
        MessageDigest md;
        md = MessageDigest.getInstance("SHA-256");
        byte[] sha1hash = new byte[40];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        sha1hash = md.digest();
        return convertToHex(sha1hash);
    } 
}