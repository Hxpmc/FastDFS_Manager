package hxpmc.pc.manager;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class test {
    public static void main(String[] args) throws IOException, MyException {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();
        String   s = com.getPath();
        ClientGlobal.initByProperties("fastdfs.properties");
        TrackerClient trackerClient  = new TrackerClient();
        TrackerServer trackerServer  = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);
      byte[]  bytes= storageClient1.download_file1("group1/M00/00/03/wKgAA1us0RaAVs5LAACEAH2M2II57.json");
        OutputStream  out  =  new FileOutputStream(s+"\\"+"3"+".json");
        out.write(bytes);
    }
}

