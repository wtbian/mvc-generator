package com.github.wtbian.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by bianwentao on 2019/1/27.
 */
public class EntityToModuleHelper implements Function<Entity, Module>{

    @Override
    public Module apply(Entity entity) {
        Module module = new Module();
        Map<String, Object> root = new HashMap<String, Object>();
        File javaFile;
        // 创建.java类文件
        File outDirFile = new File(entity.getSourceDirectory()+"/");
        if (!outDirFile.exists()) {
            outDirFile.mkdir();
        }
        javaFile = toJavaFilename(outDirFile, entity.getJavaPackage(), entity.getClassName());
        root.put("entity", entity);
        module.setJavaFile(javaFile);
        module.setRoot(root);
        return module;
    }

    /**
     * 创建.java文件所在路径 和 返回.java文件File对象
     * @param outDirFile 生成文件路径
     * @param javaPackage java包名
     * @param javaClassName java类名
     * @return
     */
    private static File toJavaFilename(File outDirFile, String javaPackage, String javaClassName) {
        String packageSubPath = javaPackage.replace('.', '/');
        File packagePath = new File(outDirFile, packageSubPath);
        File file = new File(packagePath, javaClassName + ".java");
        if (!packagePath.exists()) {
            packagePath.mkdirs();
        }
        return file;
    }
}
