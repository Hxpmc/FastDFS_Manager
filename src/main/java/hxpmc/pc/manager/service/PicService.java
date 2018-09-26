package hxpmc.pc.manager.service;


import hxpmc.pc.manager.pojo.pic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicService  {
    public int addPic(pic pic);
    public List<pic> findAll();
}
