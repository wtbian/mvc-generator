package com.github.wtbian.core;

import com.github.wtbian.util.ResolveDirectoryUtil;

/**
 * Created by bianwentao on 2018/12/17.
 */
public class EntityFactory {

    public static Entity getEntity(final Context ctx, String directory,String className, boolean constructor) {
        Entity entity = new Entity();
        entity.setClassName(className);
        entity.setJavaPackage(ResolveDirectoryUtil.getPackage(directory));
        entity.setBase(ctx.getTableName());
        entity.setProperties(ctx.getProperties());
        entity.setConstructors(constructor);
        return entity;
    }

    public static Entity getEntity(final Context ctx, String type) {
        Entity entity = new Entity();
        entity.setBase(ctx.getTableName());
        entity.setProperties(ctx.getProperties());
        entity.setConstructors(false);
        entity.setType(type);
        entity.setSourceDirectory(ctx.getSourceDirectory());
        String tname= ctx.getTableName();
        String tableNameUpper =tname.substring(0, 1).toUpperCase().concat(tname.substring(1));
        switch (type) {
            case "domain":
                entity.setClassName(tableNameUpper);
                entity.setJavaPackage(ResolveDirectoryUtil.getPackage(ctx.getDomainDirectory()));
                entity.setCommonPackage(entity.getJavaPackage().substring(0, entity.getJavaPackage().lastIndexOf(".")));
                entity.setPackagePath(entity.getJavaPackage().replace(".","/"));
                return entity;
            case "vo":
                entity.setClassName(tableNameUpper + "VO");
                entity.setJavaPackage(ResolveDirectoryUtil.getPackage(ctx.getVoDirectory()));
                entity.setCommonPackage(entity.getJavaPackage().substring(0, entity.getJavaPackage().lastIndexOf(".")));
                entity.setPackagePath(entity.getJavaPackage().replace(".","/"));
                entity.setConstructors(true);
                return entity;
            case "dao":
                entity.setClassName(tableNameUpper + "Dao");
                entity.setJavaPackage(ResolveDirectoryUtil.getPackage(ctx.getDaoDirectory()));
                entity.setCommonPackage(entity.getJavaPackage().substring(0, entity.getJavaPackage().lastIndexOf(".")));
                entity.setPackagePath(entity.getJavaPackage().replace(".","/"));
                return entity;
            case "service":
                entity.setClassName(tableNameUpper + "Service");
                entity.setJavaPackage(ResolveDirectoryUtil.getPackage(ctx.getServiceDirectory()));
                entity.setCommonPackage(entity.getJavaPackage().substring(0, entity.getJavaPackage().lastIndexOf(".")));
                entity.setPackagePath(entity.getJavaPackage().replace(".","/"));
                return entity;
            case "controller":
                entity.setClassName(tableNameUpper + "Controller");
                entity.setJavaPackage(ResolveDirectoryUtil.getPackage(ctx.getControllerDirectory()));
                entity.setCommonPackage(entity.getJavaPackage().substring(0, entity.getJavaPackage().lastIndexOf(".")));
                entity.setPackagePath(entity.getJavaPackage().replace(".","/"));
                entity.setSuperClass("BaseController");
                return entity;
            default:
                return null;

        }
    }
}
