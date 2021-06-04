package com.example.user.service;

import com.example.user.model.PublicMaterial;
import com.example.user.model.PublicMaterialBase;
import com.example.user.mapper.PublicMaterialMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class PublicMaterialService {
    @Autowired
    PublicMaterialMapper publicMaterialMapper;

    //获取上传文件夹名称
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    public List<PublicMaterial> queryByCate(String category) throws IOException {
        List<PublicMaterial> publicMaterials = publicMaterialMapper.queryByCate(category);
        PublicMaterial publicMaterial;
        List<PublicMaterial> resPublicMaterials = new ArrayList<>();

        //得到PuMaterialBase的List
        for(int i=0; i < publicMaterials.size(); i++){
            PublicMaterial resPublicMaterial = new PublicMaterial();
            publicMaterial = publicMaterials.get(i);
            String pid = publicMaterial.getPid();
            resPublicMaterial.setPid(pid);
            resPublicMaterial.setPicture_url(publicMaterial.getPicture_url());

            //读取缩略图
            //String thumbnail_url = publicMaterial.getThumbnail_url();
            //File file = new File(thumbnail_url);
            //FileInputStream inputStream = new FileInputStream(file);
            //byte[] bytes = new byte[inputStream.available()];
            //inputStream.read(bytes, 0, inputStream.available());
            //inputStream.close();
            //publicMaterialBase.setThumbnail(bytes);
            //String picture_url = publicMaterial.getPicture_url();
            //System.out.println("zhuiming picture_url:"+picture_url);
            int count = publicMaterial.getCount();
            resPublicMaterial.setCount(count);

            resPublicMaterials.add(resPublicMaterial);
        }
        return resPublicMaterials;
    }

    //读取图片
    public byte[] queryByPid(String pid) throws IOException {
        PublicMaterial publicMaterial = publicMaterialMapper.queryByPid(pid);
        String picture_url = publicMaterial.getPicture_url();
        File file = new File(picture_url);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        inputStream.close();
        return bytes;
    }

    public int add(MultipartFile file, String category) throws IOException {
        PublicMaterial publicMaterial = new PublicMaterial();
        publicMaterial.setCategory(category);
        String md5 = org.springframework.util.DigestUtils.md5DigestAsHex(file.getInputStream());
        publicMaterial.setMd5(md5);

        //设置图片和缩略图的保存位置
        String savePath = UPLOAD_FOLDER;
        String pictureSavePath = savePath + "picture/" + category + "/";
        String thumbnailSavePath = savePath + "thumbnail/" + category + "/";
        File pictureSavePathFile = new File(pictureSavePath);
        File thumbnailSavePathFile = new File(thumbnailSavePath);
        if (!pictureSavePathFile.exists()) {
            pictureSavePathFile.mkdirs();
        }
        if (!thumbnailSavePathFile.exists()) {
            thumbnailSavePathFile.mkdirs();
        }

        //用MD5值重命名图片
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String filename = md5 + "." + suffix;

        //设置图片和缩略图的url
        String picturePathname = pictureSavePath + filename;
        String thumbnailPathname = thumbnailSavePath + filename;
        publicMaterial.setPicture_url(picturePathname);
        publicMaterial.setThumbnail_url(thumbnailPathname);

        //保存图片到本地
        try {
            file.transferTo(new File(picturePathname));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        //保存缩略图到本地
        BufferedImage thumbnail = Thumbnails.of(picturePathname)
                                            .size(20, 20)
                                            .asBufferedImage();//按比例缩小
        try {
            ImageIO.write(thumbnail, suffix, new File(thumbnailPathname));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        return publicMaterialMapper.add(publicMaterial);
    }

    public int delByPid(String pid) {
        PublicMaterial publicMaterial = publicMaterialMapper.queryByPid(pid);
        String thumbnail_url = publicMaterial.getThumbnail_url();
        String picture_url = publicMaterial.getPicture_url();
        File f1 = new File(thumbnail_url);
        f1.delete();
        File f2 = new File(picture_url);
        f2.delete();
        return publicMaterialMapper.delByPid(pid);
    }

    public PublicMaterial queryByMD5(@Param("md5") String md5){
        return publicMaterialMapper.queryByMD5(md5);
    }

}
