package com.jzk.simple.generator;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Generator
 * Package:com.jzk.simple.generator
 * Description:MyBatis官方提供的逆向工程Java类
 *
 * @Date:2020/4/22 21:15
 * @Author:JZK
 */
public class Generator {

    //@Test
    public void generator() {
        try {
            List<String> warnings=new ArrayList<>();
            /*
             * 指向逆向工程的配置文件
             * */
            File configFile=new File("src/main/resources/generationConfig.xml");
            ConfigurationParser parser=new ConfigurationParser(warnings);
            Configuration configuration=parser.parseConfiguration(configFile);
            DefaultShellCallback callback=new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator=new MyBatisGenerator(configuration,callback,warnings);
            myBatisGenerator.generate(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
