package com.github.wtbian.util;

/**
 * Created by bianwentao on 2019/1/27.
 */
public class ResolveDirectoryUtil {

    public static String getPackage(String directory){
        if(directory.contains("src/main/java/")){
            return directory.split("src/main/java/")[1].replace('/', '.');
        }else if(directory.startsWith("/")){
            return directory.substring(1).replace('/', '.');
        }else {
            return directory.replace('/', '.');
        }
    }
}
