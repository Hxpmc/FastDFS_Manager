package hxpmc.pc.manager.service.Impl;

import hxpmc.pc.manager.dao.picdao;
import hxpmc.pc.manager.pojo.pic;
import hxpmc.pc.manager.service.PicService;
import hxpmc.pc.manager.untils.UploadUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class PicServiceImpl  implements PicService{
    @Autowired
    picdao picdao;
    @Override
    public int addPic(pic pic) {
        Date date = new Date();
        pic.setCreatetime(date);
        return  picdao.add(pic);
    }
//
    @Override
    public int deletePic(String path) {
        try {
            UploadUtils.deleteFile(path);
        } catch (IOException e){
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return picdao.deletePic(path);
    }
    public int downloadPic(String path) throws FileNotFoundException {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();
        String  desktopPath=   com.getPath();
        pic pic =findByPath(path);
        FileOutputStream fileOutputStream = new FileOutputStream(desktopPath+"\\"+pic.getName()+"."+pic.getType());
        try {
          byte[]  bytes= UploadUtils.downFile(path);
        fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public pic findByPath(String path) {
        return picdao.findByPath(path);
    }

    @Override
    public List<pic> findAll() {
        return picdao.findAll();
    }
}
