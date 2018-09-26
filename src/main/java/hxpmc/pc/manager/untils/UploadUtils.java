package hxpmc.pc.manager.untils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class UploadUtils {
    private static TrackerServer trackerServer;
    private static TrackerClient trackerClient;
    private static StorageClient1 storageClient;
    private static StorageServer storageServer;
    static {
        try {
            ClientGlobal.initByProperties("fastdfs.properties");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient1(trackerServer,storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    public static  String uploadFile(String filename) throws IOException, MyException {
        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("fileName", filename);
        String fileId = storageClient.upload_file1(filename, null, metaList);
    return fileId;
    }
    public static  String uploadfile(byte[] bytes,String s,NameValuePair[] meta_list) throws IOException, MyException {
        String fileId  = storageClient.upload_file1(bytes,s,meta_list);
        return fileId;
    }
    public static int deleteFile(String  id) throws IOException, MyException {
      int result=   storageClient.delete_file1(id);
        return result;
    }
    public static byte[] downFile(String id) throws IOException, MyException {
      byte[] filebytes= storageClient.download_file1(id);
      return filebytes;
    }
}
