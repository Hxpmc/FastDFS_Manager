package hxpmc.pc.manager.dao;

import hxpmc.pc.manager.pojo.pic;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface picdao {
    public pic findOne(String id);
    public pic findByName(String name);
    public pic findByPath(String path);
    public List<pic> findAll();
    public  int  add(pic pic);
    public  int deletePic(String path);
}
