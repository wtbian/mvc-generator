# mvc-generator
根据数据库表信息生成完整的web功能模块代码，xml配置问题，插件运行
配置xml文件如下：

引入插件配置如下：
 <build>
      <plugins>
        <plugin>
          <groupId>mvc-generator-plugin</groupId>
          <artifactId>generator-maven-plugin</artifactId>
          <version>1.0.0-SNAPSHOT</version>
          <executions>
            <execution>
              <goals>
                <goal>mvc</goal>
              </goals>
              <phase>compile</phase>
            </execution>
          </executions>
        </plugin>
      </plugins>
    </build>
 运行命令如下：
 mvn generator:mvc
