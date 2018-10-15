package hxpmc.pc.manager;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class iodemo {
    public static void main(String[] args) throws IOException {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();
         String c = com.getPath();


   }

    }

