package com.github.wtbian.core;

import java.util.List;

/**
 * Created by bianwentao on 2018/12/13.
 */
public class Entity {
    /**
     * common basic info
     */
    private String base;

    /**
     * class package
     */
    private String javaPackage;

    /**
     * class name
     */
    private String className;

    /**
     * super class name
     */
    private String superClass;

    /**
     * table fields properties for freemarker template
     */
    List<Property> properties;

    /**
     * is or not generate  constructor for entity
     */
    private boolean constructors;

    /**
     * table comments
     */
    private String comments;

    /**
     * directory type
     */
    private String type;

    /**
     * project source directory
     */
    String sourceDirectory;

    /**
     * class package path
     */
    String packagePath;

    /**
     * common package
     */
    String commonPackage;

    public String getJavaPackage() {
        return javaPackage;
    }

    public void setJavaPackage(String javaPackage) {
        this.javaPackage = javaPackage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public boolean isConstructors() {
        return constructors;
    }

    public void setConstructors(boolean constructors) {
        this.constructors = constructors;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSuperClass() {
        return superClass;
    }

    public void setSuperClass(String superClass) {
        this.superClass = superClass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getCommonPackage() {
        return commonPackage;
    }

    public void setCommonPackage(String commonPackage) {
        this.commonPackage = commonPackage;
    }


}
