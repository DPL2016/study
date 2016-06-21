package com.kaishengit.test;

import com.kaishengit.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
public class JSoupTestCase {
    @Test
    public void testGetImage() throws IOException {
        for (int i=2;i<5;i++){
            Document document = Jsoup.connect("http://www.topit.me/pop?p=\"+i").cookie("is_click", "1").get();
            Elements elements = document.select("#content .catalog .e>a");
            for (Element element :elements){
                String herf = element.attr("href");
                System.out.println("href:"+herf);
                Document bigImageDoc = Jsoup.connect(herf).cookie("is_click", "1").get();
                Element imgElement = bigImageDoc.select("#content>a").first();
                String imgSrc = imgElement.attr("href");
                System.out.println(imgSrc);
                String fileName = imgSrc.substring(imgSrc.lastIndexOf("/")+1);
                HttpUtils.getRequestStream(imgSrc, "D:/upload/" + fileName);
            }
        }
    }
}
