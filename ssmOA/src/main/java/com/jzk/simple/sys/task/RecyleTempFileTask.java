package com.jzk.simple.sys.task;

import com.jzk.simple.sys.constast.SysConstast;
import com.jzk.simple.sys.utils.AppFileUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * ClassName:RecyleTempFileTask
 * Package:com.jzk.simple.sys.task
 * Description:
 *
 * @Date:2020/5/12 17:19
 * @Author:JiangZhikuan
 */
@Component
@EnableScheduling
public class RecyleTempFileTask {

    @Scheduled(cron = "0 0 0 * * ?")
    public void recyleTempFile(){
        File file=new File(AppFileUtils.PATH);
        deleteFile(file);
    }

    public void deleteFile(File file){
        if(null!=file){
            File[] files=file.listFiles();
            if(files!=null&&files.length>0){
                for (File f:files){
                    if (f.isFile()){
                        if(f.getName().endsWith(SysConstast.FILE_UPLOAD_TEMP)){
                            f.delete();
                        }
                    }else {
                        deleteFile(f);
                    }
                }
            }
        }
    }
}
