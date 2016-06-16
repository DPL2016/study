package com.kaishengit.service;

import com.kaishengit.dao.DocumentDao;
import com.kaishengit.entity.Document;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class DocumenService {
    private DocumentDao documentDao = new DocumentDao();
    public void updateFile(String fileName, long size, InputStream inputStream) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(IOUtils.toByteArray(inputStream));
        String md5 = DigestUtils.md5Hex(byteArrayInputStream);
        DocumentDao dao = new DocumentDao();
        Document document = dao.findDomentByMd5(md5);
        if(document==null){
            String saveFileName = saveFile(fileName,byteArrayInputStream);
            document = new Document();
            document.setFilename(fileName);
            document.setSavename(saveFileName);
            document.setEndname(fileName.substring(fileName.indexOf(".")));
            document.setSize(size);
            document.setMd5(md5);
            document.setDisplaysize(FileUtils.byteCountToDisplaySize(size));
            dao.savaDocument(document);
        }
    }

    private String saveFile(String fileName, InputStream inputStream) throws IOException {
        inputStream.reset();
        File dir = new File("D:/122");
        if (!dir.exists()) {
            dir.mkdir();
        }
        String endname = fileName.substring(fileName.indexOf("."));
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + endname;
        FileOutputStream fos = new FileOutputStream(new File(dir, fileName));
        IOUtils.copy(inputStream, fos);
        fos.flush();
        fos.close();
        fos.close();
        return fileName;
    }

    public List<Document> findAllDocument() {
        return  documentDao.findAll();
    }
    public Document findDocumentByMd5(String md5) {
        return documentDao.findDomentByMd5(md5);
    }
}
