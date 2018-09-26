package hxpmc.pc.manager;

import java.io.*;

public class iodemo {
    public static void main(String[] args) throws IOException {
   String s = "jdkapi+1.8.CHM";
   String[] ss = s.split("\\.");
   for (String ds:ss){
       System.out.println(ds);
   }

    }
}
