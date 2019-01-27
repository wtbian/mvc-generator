# mvc-generator
根据数据库表信息生成完整的web功能模块代码，xml配置问题，插件运行

工程地址：https://github.com/wtbian/mvc-generator.git

配置xml文件如下：

    <build>
      <plugins>
        <plugin>
          <groupId>mvc-generator-plugin</groupId>
          <artifactId>generator-maven-plugin</artifactId>
          <version>1.0.0-SNAPSHOT</version>
          <configuration>
                <sqlScript>
                CREATE TABLE `scene` (
                    `id` INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                    `name` VARCHAR(45) NOT NULL COMMENT '名字',
                    `code` VARCHAR(45) NOT NULL COMMENT '编码',
                    `valid` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '1:有效,0无效',
                    PRIMARY KEY (`id`))
                </sqlScript>
                <domainDirectory>
                    ${project.basedir}/src/main/java/com/wtbian/web/domain
                </domainDirectory>
                <controllerDirectory>
                    ${project.basedir}/src/main/java/com/wtbian/web/controller
                </controllerDirectory>
                <daoDirectory>
                    ${project.basedir}/src/main/java/com/wtbian/web/dao
                </daoDirectory>
                <voDirectory>
                    ${project.basedir}/src/main/java/com/wtbian/web/vo
                </voDirectory>
                <serviceDirectory>
                    ${project.basedir}/src/main/java/com/wtbian/web/service
                </serviceDirectory>
            </configuration>
        </plugin>
      </plugins>
    </build>
    
    
 运行命令如下：
 
 mvn generator:mvc
