package com.jzk.simple.sys.controller;

import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.utils.AppFileUtils;
import com.jzk.simple.sys.utils.DataGridView;
import com.jzk.simple.sys.utils.RandomUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:FileController
 * Package:com.jzk.simple.sys.controller
 * Description:
 *
 * @Date:2020/5/9 16:48
 * @Author:JiangZhikuan
 */
@Controller
@RequestMapping("file")
public class FileController {

    @ResponseBody
    @RequestMapping("uploadFile")
    public DataGridView uploadFile(MultipartFile mf) throws IOException {
        String parentPath= AppFileUtils.PATH;

        String dirName= RandomUtils.getCurrentDateForString();

        File dirFile=new File(parentPath,dirName);
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }

        String oldName=mf.getOriginalFilename();

        String newName=
                RandomUtils.createFileNameUseTime(
                        oldName,
                        SysConstast.FILE_UPLOAD_TEMP);
        File dest=new File(dirFile,newName);
        mf.transferTo(dest);

        Map<String,Object> map=new HashMap<>();
        map.put("src",dirName+"/"+newName);

        return new DataGridView(map);
    }

    @RequestMapping("downloadShowFile")
    public ResponseEntity<Object> downloadShowFile(String path, HttpServletResponse response){
        return AppFileUtils.downloadFile(response,path,"1");
    }

    @RequestMapping("downloadFile")
    public ResponseEntity<Object> downloadFile(String path,HttpServletResponse response){
        return AppFileUtils.downloadFile(response,path,"1");
    }
}
