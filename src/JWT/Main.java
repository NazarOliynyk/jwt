package JWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class Main {

    // System.currentTimeMillis() current time right now
    public static void main(String[] args) {

            String jwtoken = Jwts.builder()
            .setSubject("Vasya")
            .signWith(SignatureAlgorithm.HS512, "yes".getBytes())
            .setExpiration(new Date(System.currentTimeMillis()+3000)) // less than 2500-3000 may cause the expiration of the token
            .compact();

        System.out.println(jwtoken);

       // Thread.sleep(600);


        String subject = Jwts.parser()
                .setSigningKey("yes".getBytes())
                .parseClaimsJws(jwtoken)
                .getBody()
                .getSubject();

        System.out.println("subject: "+subject);
    }




}
