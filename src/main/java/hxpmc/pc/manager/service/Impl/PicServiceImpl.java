package hxpmc.pc.manager.service.Impl;

import hxpmc.pc.manager.dao.picdao;
import hxpmc.pc.manager.pojo.pic;
import hxpmc.pc.manager.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<pic> findAll() {
        return picdao.findAll();
    }
}
