package hxpmc.pc.manager;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException, MyException {
        ClientGlobal.initByProperties("fastdfs.properties");
        TrackerClient trackerClient  = new TrackerClient();
        TrackerServer trackerServer  = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);
      byte[]  bytes= storageClient1.download_file1("group1/M00/00/03/wKgAA1unRpKAXirYAACEAH2M2II27.json");
        OutputStream  out  =  new FileOutputStream("C:\\Users\\Administrator\\Downloads\\"+"1"+".json");
        out.write(bytes);
    }
}

