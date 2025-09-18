package lifeunit;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ReChapterText {
    public static void main(String[] args) throws Exception {
        chapterText();
    }

    private static void chapterText() throws Exception {
//        Pattern title=new 第84章 第 84 章
        String filePath="D:\\download\\BaiduNetdiskDownload\\小说0517\\言情\\有港来信.txt";
        File file=new File(filePath);
        if(!file.exists()||file.isDirectory()){
            return;
        }
        File copy=new File(filePath.replace(".txt","1.txt"));
        if(!copy.exists()){
            file.createNewFile();
        }
        Scanner scanner=null;
        FileWriter fileWriter=null;
        try {
            int index=1,lineidx=0;
             scanner=new Scanner(file);
            fileWriter= new FileWriter(copy);
             while (scanner.hasNext()){
                 lineidx++;
                 String line= scanner.nextLine();
                 if(null==line||"".equals(line.trim())){

//                 }else if(line.indexOf("◎")>=0||line.indexOf("【第")>=0){
//                    continue;
//                 }else if(line.indexOf("【十")>=0
//                         ||line.indexOf("【二")>=0
//                         ||line.indexOf("【三")>=0
//                         ||line.indexOf("【四")>=0
//                         ||line.indexOf("【五")>=0
//                         ||line.indexOf("【六")>=0
//                 ) {
//                     System.err.println(line);
//                     continue;

                 }else if(Pattern.matches("第.*章",line)){
                     System.err.println(line);

                 }
                 /*if(null==line||"".equals(line)||line.startsWith(" ")||line.trim().length()!=4||line.indexOf("…")>=0||line.indexOf(" ")>=0){

                 }else {
                     line="第"+(index++)+"章 "+line.trim();
                     System.err.println(line);
                 }*/
                 fileWriter.write(line+"\n");
             }
//            System.err.println(index);
        }catch (Exception e){
            System.err.println(e);
        }finally {
            fileWriter.close();
            scanner.close();
        }
    }
}
