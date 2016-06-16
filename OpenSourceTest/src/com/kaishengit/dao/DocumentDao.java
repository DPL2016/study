package com.kaishengit.dao;

import com.kaishengit.entity.Document;
import com.kaishengit.util.DBHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class DocumentDao {
    public void savaDocument(Document document){
        String sql = "INSERT INTO document(filename,savename,md5,size,endname,displaysize) VALUES (?,?,?,?,?,?)";
        DBHelp.update(sql,document.getFilename(),document.getSavename(),document.getMd5(),document.getSize(),document.getEndname(),document.getDisplaysize());
    }

    public Document findDomentByMd5(String md5) {
        String sql = "select*from document where md5=?";
        return DBHelp.query(sql,new BeanHandler<>(Document.class),md5);
    }
}
