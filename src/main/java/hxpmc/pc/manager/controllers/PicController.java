package hxpmc.pc.manager.controllers;

import hxpmc.pc.manager.pojo.pic;
import hxpmc.pc.manager.service.PicService;
import hxpmc.pc.manager.untils.UploadUtils;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileNotFoundException;
import java.io.IOException;


@Controller
public class PicController {
    @Autowired
    PicService picService;

    @RequestMapping("upload")
    @ResponseBody
    public String  upload(MultipartFile file) throws IOException, MyException {
        String[] ExtNmae = file.getOriginalFilename().split("\\.");
        byte[] bytes = file.getBytes();
        String  ext_name = ExtNmae[ExtNmae.length-1];
        String filename=  ExtNmae[0];
        String path  = UploadUtils.uploadfile(bytes,ext_name,null);
        pic pic  =  new pic();
        pic.setType(ext_name);
        pic.setPath(path);
        pic.setName(filename);
        picService.addPic(pic);
        return "ok";
    }
    @RequestMapping("delete")
    public String delete(String id) throws IOException, MyException {
      picService.deletePic(id);
        return "redirect:filemanager";
    }
@RequestMapping("download")
@ResponseBody
    public String download(String id) throws FileNotFoundException {
        picService.downloadPic(id);
    return "ok";
}
}
