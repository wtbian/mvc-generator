package com.github.wtbian.core;

import java.util.List;

/**
 * Created by bianwentao on 2019/1/26.
 */
public class Context {
    /**
     * project source directory
     */
    String sourceDirectory;

    /**
     * sql text
     */
    private String sqlScript;

    /**
     * table name
     */
    private String tableName;

    /**
     * table fields properties
     */
    private List<Property> properties;

    /**
     * table comments
     */
    private String comments;

    /**
     * directory for dao level code generate
     */
    private String daoDirectory;

    /**
     * directory for service level code generate
     */
    private String serviceDirectory;

    /**
     * directory for controller level code generate
     */
    private String controllerDirectory;

    /**
     * directory for vo level code generate
     */
    private String voDirectory;

    /**
     * directory for domain level code generate
     */
    private String domainDirectory;

    /**
     * constructor
     */

    private Context() {
    }

    private static volatile Context instance;

    public static Context getInstance() {
        if (instance == null) {
            synchronized (Context.class) {
                instance = new Context();
            }
        }
        return instance;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSqlScript() {
        return sqlScript;
    }

    public void setSqlScript(String sqlScript) {
        this.sqlScript = sqlScript;
    }

    public String getDaoDirectory() {
        return daoDirectory;
    }

    public void setDaoDirectory(String daoDirectory) {
        this.daoDirectory = daoDirectory;
    }

    public String getServiceDirectory() {
        return serviceDirectory;
    }

    public void setServiceDirectory(String serviceDirectory) {
        this.serviceDirectory = serviceDirectory;
    }

    public String getControllerDirectory() {
        return controllerDirectory;
    }

    public void setControllerDirectory(String controllerDirectory) {
        this.controllerDirectory = controllerDirectory;
    }

    public String getVoDirectory() {
        return voDirectory;
    }

    public void setVoDirectory(String voDirectory) {
        this.voDirectory = voDirectory;
    }

    public String getDomainDirectory() {
        return domainDirectory;
    }

    public void setDomainDirectory(String domainDirectory) {
        this.domainDirectory = domainDirectory;
    }

}
