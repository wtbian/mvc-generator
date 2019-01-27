package com.github.wtbian.core;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by bianwentao on 2019/1/27.
 */
public class ProcessImpl implements Consumer<Entity>{

    Template template;

    private EntityToModuleHelper couponDataMapToPojoHelper=new EntityToModuleHelper();

    public ProcessImpl(Template template) {
        this.template = template;
    }

    @Override
    public void accept(Entity entity) {
        try {
            Module module = couponDataMapToPojoHelper.apply(entity);
            Map<String, Object> root = module.getRoot();
            File javaFile = module.getJavaFile();

            // 步骤四：合并 模板 和 数据模型
            // 创建.java类文件
            if (javaFile != null) {
                Writer javaWriter = new FileWriter(javaFile);
                template.process(root, javaWriter);
                javaWriter.flush();
                System.out.println("文件生成路径：" + javaFile.getCanonicalPath());
                javaWriter.close();
            }
            // 输出到Console控制台
            Writer out = new OutputStreamWriter(System.out);
            template.process(root, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
