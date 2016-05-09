package com.shadow.alternator.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.EditText;

public class StringTool {


    public static boolean isEmpty(String s) {
        if (null == s) {
            return true;
        }
        if ("".equals(s.replace(" ", ""))) {
            return true;
        }
        if (s.toLowerCase().equals("null")) {
            return true;
        }

        return false;
    }



    public static boolean checkByteLength(String s, int max, int min) {
        byte[] bs = s.getBytes();
        if (bs.length <= max && bs.length >= min) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(EditText editText) {
        String s = editText.getText().toString();
        return isEmpty(s);
    }

    public static boolean isMobile(String mobiles) {
        if (isEmpty(mobiles)) {
            return false;
        }
        if (!mobiles.startsWith("1")) {
            return false;
        }
        if (mobiles.length() != 11) {
            return false;
        }

        return true;
        // Pattern p = Pattern.compile("^13/d{9}||15[8,9]/d{8}$");
        // Matcher m = p.matcher(mobiles);
        // return m.matches();
    }

    public static int str2int(String s, int defvalue) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            // TODO: handle exception
            return defvalue;
        }
    }

    public static long str2long(String s, long defvalue) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            // TODO: handle exception
            return defvalue;
        }
    }

    public static double str2double(String s, double defvalue) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            // TODO: handle exception
            return defvalue;
        }
    }

    public static float str2float(String s, float defvalue) {
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            // TODO: handle exception
            return defvalue;
        }
    }




    public static String md5(String string) {

        byte[] hash;

        try {

            hash = MessageDigest.getInstance("MD5").digest(
                    string.getBytes("UTF-8"));

        } catch (NoSuchAlgorithmException e) {

            throw new RuntimeException("Huh, MD5 should be supported?", e);

        } catch (UnsupportedEncodingException e) {

            throw new RuntimeException("Huh, UTF-8 should be supported?", e);

        }

        StringBuilder hex = new StringBuilder(hash.length * 2);

        for (byte b : hash) {

            if ((b & 0xFF) < 0x10)
                hex.append("0");

            hex.append(Integer.toHexString(b & 0xFF));

        }

        return hex.toString();

    }
  	public static boolean isEmail(String strEmail) {
  		String strPattern = "^[\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";

  		Pattern p = Pattern.compile(strPattern);
  		Matcher m = p.matcher(strEmail);
  		return m.matches();
  	}
  	public static boolean isMobileNum(String mobiles) {
          Pattern p = Pattern.compile("^((13[0-9])|(17[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
          Matcher m = p.matcher(mobiles);
          return m.matches();
      }
  	
}
