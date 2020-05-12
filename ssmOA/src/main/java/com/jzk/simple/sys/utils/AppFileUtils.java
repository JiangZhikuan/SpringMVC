package com.jzk.simple.sys.utils;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Properties;

/**
 * ClassName:AppFileUtils
 * Package:com.jzk.simple.sys.utils
 * Description:
 *
 * @Date:2020/4/22 12:39
 * @Author:JiangZhikuan
 */
public class AppFileUtils {

    public static String PATH="";
    static {
        InputStream stream=
                AppFileUtils.class.getClassLoader()
                        .getResourceAsStream("file.properties");
        Properties properties=new Properties();
        try {
            properties.load(stream);
            PATH=properties.getProperty("path");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /*
    * 文件下载
    * */
    public static ResponseEntity<Object> downloadFile(HttpServletResponse response,String path,String oldName){
        //使用绝对路径+相对路径去找对象
        File file=new File(AppFileUtils.PATH,path);
        //判断文件是否存在
        if(file.exists()){
            try{
                try {
                    oldName= URLEncoder.encode(oldName,"UTF-8");
                }catch (Exception e){
                    e.printStackTrace();
                }
                //把file转成一个bytes
                byte[] bytes= FileUtils.readFileToByteArray(file);
                HttpHeaders httpHeaders=new HttpHeaders();
                //封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
                httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                //设置下载的文件的名称
                httpHeaders.setContentDispositionFormData("attachment",oldName);
                //创建ResponseEntity对象
                ResponseEntity<Object> entity=new ResponseEntity<>(bytes,httpHeaders, HttpStatus.CREATED);
                return entity;

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }else{
            PrintWriter out;
            try {
                out=response.getWriter();
                out.write("文件不存在");
                out.flush();
                out.close();
            }catch (IOException e){e.printStackTrace();}
            return null;
        }
    }

    /*
    * 根据相对路径删除硬盘文件
    * */
    public static void  deleteFileUsePath(String path){
        String realPath=PATH+path;
        File file=new File(realPath);
        if(file.exists()){file.delete();}
    }

    /*
    * 修改图片名称
    * */
    public static String updateFileName(String carimg,String suffix){
        try {
            File file=new File(PATH,carimg);
            if(file.exists()){
                file.renameTo(new File(PATH,carimg.replace(suffix,"")));
                return carimg.replace(suffix,"");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*
    * 删除图片
    * */
    public static void removeFileByPath(String carimg){
        try{
            File file=new File(PATH,carimg);
            if (file.exists()){
                file.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
