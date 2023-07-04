package com.example.demo.util;


import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/2/16 16:51
 */
public final class WordUtils {

    /**
     * word文件合并
     * @param wordList
     * @return
     * @throws Exception
     */
    public static  XWPFDocument mergeWord(List<XWPFDocument> wordList) throws Exception{
        if (CollectionUtils.isEmpty(wordList)) {
            throw  new RuntimeException("待合并的word文档list为空");
        }
        XWPFDocument doc = wordList.get(0);
        int size = wordList.size();
        if (size > 1) {
            doc.createParagraph().setPageBreak(true);
            for (int i = 1; i < size; i++) {
                // 从第二个word开始合并
                XWPFDocument nextPageDoc = wordList.get(i);
                // 最后一页不需要设置分页符
                if (i != (size-1)) {
                    nextPageDoc.createParagraph().setPageBreak(true);
                }
                appendBody(doc, nextPageDoc);
            }
        }
        return doc;
    }

    private static void appendBody(XWPFDocument src, XWPFDocument append) throws Exception {
        CTBody src1Body = src.getDocument().getBody();
        CTBody src2Body = append.getDocument().getBody();
        List<XWPFPictureData> allPictures = append.getAllPictures();
        // 记录图片合并前及合并后的ID
        Map<String,String> map = new HashMap<>();
        for (XWPFPictureData picture : allPictures) {
            String before = append.getRelationId(picture);
            //将原文档中的图片加入到目标文档中
            String after = src.addPictureData(picture.getData(), Document.PICTURE_TYPE_PNG);
            map.put(before, after);
        }
        appendBody(src1Body, src2Body,map);

    }

    private static void appendBody(CTBody src, CTBody append,Map<String,String> map) throws Exception {
        XmlOptions optionsOuter = new XmlOptions();
        optionsOuter.setSaveOuter();
        String appendString = append.xmlText(optionsOuter);
        String srcString = src.xmlText();
        String prefix = srcString.substring(0,srcString.indexOf(">")+1);
        String mainPart = srcString.substring(srcString.indexOf(">")+1,srcString.lastIndexOf("<"));
        String sufix = srcString.substring( srcString.lastIndexOf("<") );
        String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));
        if (map != null && !map.isEmpty()) {
            //对xml字符串中图片ID进行替换
            for (Map.Entry<String, String> set : map.entrySet()) {
                addPart = addPart.replace(set.getKey(), set.getValue());
            }
        }
        //将两个文档的xml内容进行拼接
        CTBody makeBody = CTBody.Factory.parse(prefix+mainPart+addPart+sufix);
        src.set(makeBody);
    }

}
