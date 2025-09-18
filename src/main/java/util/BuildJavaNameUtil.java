package util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import java.io.File;
import java.io.IOException;

public class BuildJavaNameUtil {
    public static void main(String[] args) {
        String url="https://leetcode.cn/problems/fraction-to-recurring-decimal/?envType=problem-list-v2&envId=w8OJJIbl";
        String path="D:\\Program Files\\JetBrains\\IdeaProjects\\leetcode\\src\\main\\java\\D202507";
        String fileName=buildName(url);
        String pkg=buildPkg(path);
        System.err.println(pkg);
        File file=new File(path,fileName+".java");
        String name=fileName;
        if(file.exists()) return;
        int i=0;
        while (file.exists()) {
            name=fileName+(i++);
            file=new File(path,name+".java");
        }
        if(!file.exists()){
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String content="package "+pkg+";\n\n/**\n * "+url+"\n * @Author UGcris\n * @date "+ DateUtil.formatDate(DateUtil.date()) +"\n **/\npublic class "+name+" {\n\n}";
        FileUtil.writeString(content,file,"UTF-8");
    }


    private static String buildPkg(String path) {
        String[] split = path.split("\\\\");
        StringBuilder builder=new StringBuilder();
        for (int i = split.length-1; i >=0 ; i--) {
            if(!split[i].equals("java")){
                if(builder.length()==0){
                    builder.append(split[i]);
                }else {
                    builder.insert(0,split[i]+".");
                }
            }else {
                break;
            }
        }
        return builder.toString();
    }

    private static String buildName(String url) {
        String[] split = url.split("/");
        String word=split[4];
        return StrUtil.upperFirst(StrUtil.toCamelCase(word,'-'));
    }

}
