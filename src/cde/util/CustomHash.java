/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cde.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lukas
 */
public class CustomHash {
    
    public static String customHash(String senha) throws NoSuchAlgorithmException{
        
        MessageDigest algo = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = {};
        try {
            messageDigest = algo.digest(senha.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CustomHash.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StringBuilder hexString = new StringBuilder();
        for(byte b: messageDigest){
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaHex = hexString.toString();
        return senhaHex;
        
    }
    
}
