package com.zzh.dell.guoku.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by Ishinagi_moeta on 2016/10/19.
 */
public class CategoryDownloadUtils {

    static private String filePath;

    static public void saveCategory(String str){
        CreateFile();
        writeFile(str);
    }

    static public String loadCategory(){
        StringBuilder sb = new StringBuilder(1000);
        try(FileReader fr = new FileReader(filePath)) {
            int len = 0;
            char buf [] = new char [1024];
            while ((len = fr.read(buf))!=-1){
                String str = new String(buf,0,len);
                sb.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

    static private void CreateFile(){
        //1.创建文件(外部自定义存储)
        //1>先判断sd卡是否挂载2>创建目录或者文件
        //Environment.MEDIA_MOUNTED标识sd卡挂载的状态，
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //标识sd卡存在
            //获取sd卡根目录
            File root = Environment.getExternalStorageDirectory();
            //创建目录
            File dir = new File(root.getAbsolutePath() + "/category");
            //判断目录是否存在
            if (!dir.exists()) {
                //该目录不存在，要创建
                //mkdirs:创建多级目录，如果父目录不存在，可以依次创建
                //mkdir:创建单级目录,如果父目录不存在，无法创建
                dir.mkdirs();
            }
            //创建文件
            File categoryFile = new File(dir.getAbsolutePath() + "/" + "category");
            filePath = categoryFile.getAbsolutePath();
        }
    }

    static private void writeFile(String str){
        File categoryFile = new File(filePath);
        if (categoryFile!=null&&categoryFile.exists()){
            FileOutputStream outStream = null;
            try(FileWriter fw = new FileWriter(filePath)){
                fw.write(str);
                fw.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
