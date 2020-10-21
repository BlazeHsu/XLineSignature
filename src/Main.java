import com.Base64.XLineSignature;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        XLineSignature hmacSHA256 = new XLineSignature();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello input your secret & request body");
        System.out.println("secret :  ");
        String secret = scanner.next();
        System.out.println("request body : ");
        String requestBody = scanner.next();

        try {
            System.out.println("hmacSha256 : "+hmacSHA256.getSignature(secret,requestBody));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }


}
