package com.zzh.dell.guoku.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by bluesky on 16/9/20.
 */
public class BitmapUtils {


    /**
     * 保存图片到本地
     *
     * @param bmp:图片的bitmap对象
     * @param fileName:保存的图片的文件名称
     * @return
     */
    public static String saveImageToSDCard(Bitmap bmp, String fileName) {
        // 首先保存图片
        File rootDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"GuoKu");
        if (!rootDir.exists()) {
            rootDir.mkdirs();
        }
        File sub = new File(rootDir,"images");
        if(!sub.exists()){
            sub.mkdir();
        }
        File file = new File(sub, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();
    }


    /**
     * 把文件插入到系统图库
     *
     * @param context
     * @param path     :文件的保存路径
     * @param fileName :文件的名称
     */
    public static void insertImgStore(Context context, String path, String fileName) {
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    path, fileName, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
    }


    //根据指定地址得到文件名称
    public static String getFileName(String url) {
        String[] s = url.split("/");
        String name = s[s.length - 1];
        return name;
    }

    /**
     * 对图片可能进行二次采样，不致于加载过大图片出现内存溢出
     */
    public static Bitmap getBitmapByPath(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;  //仅仅解码边缘区域
        //如果指定了inJustDecodeBounds，decodeByteArray将返回为空
        BitmapFactory.decodeFile(path, options);
        //得到宽与高

        int sampleSize = 4;


        //不再只加载图片实际边缘
        options.inJustDecodeBounds = false;
        //并且制定缩放比例
        options.inSampleSize = sampleSize;
        return BitmapFactory.decodeFile(path, options);
    }

    public static Bitmap rotateBitmapByDegree(Bitmap paramBitmap, int paramInt) {
        Matrix localMatrix = new Matrix();
        localMatrix.postRotate(paramInt);
        Bitmap localBitmap1 = null;
        try {
            Bitmap localBitmap2 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
            localBitmap1 = localBitmap2;
            if (localBitmap1 == null)
                localBitmap1 = paramBitmap;
            if (paramBitmap != localBitmap1)
                paramBitmap.recycle();
            return localBitmap1;
        } catch (OutOfMemoryError localOutOfMemoryError) {
            localOutOfMemoryError.printStackTrace();
        }
        return null;
    }

    public static int getBitmapDegree(String paramString) {
        try {
            int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
            switch (i) {
                case 4:
                case 5:
                case 7:
                case 6:
                    return 90;
                case 3:
                    return 180;
                case 8:
                    return 270;
                default:
                    return 0;
            }

        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return 0;
    }


}
