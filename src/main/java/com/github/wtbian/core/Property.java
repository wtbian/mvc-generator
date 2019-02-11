package com.github.wtbian.core;

/**
 * Created by bianwentao on 2018/12/13.
 */
public class Property {
    // 属性数据类型
    private String javaType;
    // 属性名称
    private String propertyName;

    private PropertyType propertyType;

    private String comment;

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        String str=javaType.toUpperCase();
        switch (str) {
            case "VARCHAR":
                this.javaType = "String";
                break;
            case "INT":
                this.javaType = "Integer";
                break;
            case "TINYINT":
                this.javaType = "Boolean";
                break;
            default:
                break;
        }
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
