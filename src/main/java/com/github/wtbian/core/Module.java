package com.github.wtbian.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bianwentao on 2018/12/16.
 */
public class Module {
    Map<String, Object> root = new HashMap<String, Object>();
    File javaFile;

    public Map<String, Object> getRoot() {
        return root;
    }

    public void setRoot(Map<String, Object> root) {
        this.root = root;
    }

    public File getJavaFile() {
        return javaFile;
    }

    public void setJavaFile(File javaFile) {
        this.javaFile = javaFile;
    }
}
