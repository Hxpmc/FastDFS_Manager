package hxpmc.pc.manager.service;


import hxpmc.pc.manager.pojo.pic;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.List;

@Repository
public interface PicService  {
    public int addPic(pic pic);
    public int deletePic(String path);
    public List<pic> findAll();
    public int downloadPic(String path) throws FileNotFoundException;
    public pic findByPath(String path);
}
