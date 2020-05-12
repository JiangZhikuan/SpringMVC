package com.jzk.simple.sys.utils;

import javax.print.DocFlavor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * ClassName:RandomUtils
 * Package:com.jzk.simple.sys.utils
 * Description:
 *
 * @Date:2020/4/22 13:01
 * @Author:JiangZhikuan
 */
public class RandomUtils {
    private static SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static Random random=new Random();

    /*
    * 获取当前时间
    * */
    public static String getCurrentDateForString(){
        return sdf1.format(new Date());
    }

    /*
    * 生成文件名使用时间+4位随机数
    * */
    public static String createFileNameUseTime(String fileName,String suffix){
        String fileSuffix=fileName.substring(fileName.lastIndexOf('.'),fileName.length());
        String time=sdf2.format(new Date());
        Integer num=random.nextInt(9000)+1000;
        return time+num+suffix+fileSuffix;
    }

    /*
    * 生成文件名使用UUID
    * */
    public static  String createFileNameUseUUID(String fileName){
        String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
        return UUID.randomUUID().toString().replace("_","").toUpperCase()+fileSuffix;
    }
}
