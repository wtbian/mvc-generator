package com.github.wtbian.core;

import com.github.wtbian.util.FreemarkerUtils;
import com.github.wtbian.util.SqlParserUtil;
import freemarker.template.Configuration;
import net.sf.jsqlparser.JSQLParserException;

/**
 * Created by bianwentao on 2019/1/27.
 */
public class Generator{
    private static Context ctx;
    private static Configuration cfg = new Configuration();

    public static void execute(String sourceDirectory, String sqlScript, String daoDirectory, String serviceDirectory, String controllerDirectory, String voDirectory, String domainDirectory) throws Exception {
        initContext(sourceDirectory, sqlScript, daoDirectory, serviceDirectory, controllerDirectory, voDirectory, domainDirectory);
        initConfiguration(cfg);
        GenerateImpl gi = new GenerateImpl(ctx, cfg);
        gi.generateDomain();
        gi.generateVo();
        gi.generateDao();
        gi.generateService();
        gi.generateController();
        destroy();
    }

    private static void initContext(String sourceDirectory, String sqlScript, String daoDirectory, String serviceDirectory,
                String controllerDirectory, String voDirectory, String domainDirectory) throws JSQLParserException {
        ctx = SqlParserUtil.parseCreateTable(sqlScript);
        ctx.setSourceDirectory(sourceDirectory);
        ctx.setSqlScript(sqlScript);
        ctx.setDaoDirectory(daoDirectory);
        ctx.setServiceDirectory(serviceDirectory);
        ctx.setControllerDirectory(controllerDirectory);
        ctx.setVoDirectory(voDirectory);
        ctx.setDomainDirectory(domainDirectory);
    }

    private static void initConfiguration(Configuration cfg) throws Exception {
        FreemarkerUtils.init(cfg);
    }

    private static void destroy() throws Exception {
        FreemarkerUtils.destroy();
    }

    public static void main(String args[]){
        String sourceDirectory="/Users/bianwentao/IdeaProjects/simpledemo/src/main/java";
//        String sqlScript=
//                "CREATE TABLE `scene` (" +
//                "`id` INT NOT NULL AUTO_INCREMENT COMMENT '场景主键ID'," +
//                "`name` VARCHAR(45) NOT NULL COMMENT '名字'," +
//                "`code` VARCHAR(45) NOT NULL COMMENT '场景code'," +
//                "`valid` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '1:有效,0无效'," +
//                "PRIMARY KEY (`id`))";
        String sqlScript=
                "CREATE TABLE `schemaConfig` (\n" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `poi_cate_id` int(11) NOT NULL DEFAULT '0' COMMENT '品类ID',\n" +
                        "  `appid` int(11) NOT NULL DEFAULT '0' COMMENT 'appid',\n" +
                        "  `version` varchar(255) NOT NULL DEFAULT '0.0.0' COMMENT 'schema生效的最低版本',\n" +
                        "  `schema` varchar(255) NOT NULL DEFAULT '' COMMENT '跳转的schema规则',\n" +
                        "  `enable` int(11) NOT NULL DEFAULT '1' COMMENT '是否有效',\n" +
                        "  PRIMARY KEY (`id`)\n" +
                        ")";
        String daoDirectory="/Users/bianwentao/IdeaProjects/simpledemo/src/main/java/com/wtbian/web/dao";
        String serviceDirectory="/Users/bianwentao/IdeaProjects/simpledemo/src/main/java/com/wtbian/web/service";
        String controllerDirectory="/Users/bianwentao/IdeaProjects/simpledemo/src/main/java/com/wtbian/web/controller";
        String voDirectory="/Users/bianwentao/IdeaProjects/simpledemo/src/main/java/com/wtbian/web/vo";
        String domainDirectory="/Users/bianwentao/IdeaProjects/simpledemo/src/main/java/com/wtbian/web/domain";
        try {
            execute( sourceDirectory,  sqlScript,  daoDirectory,  serviceDirectory,  controllerDirectory,  voDirectory,  domainDirectory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
