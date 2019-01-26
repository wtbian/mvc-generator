# mvc-generator
根据数据库表信息生成完整的web功能模块代码，xml配置问题，插件运行
配置xml文件如下：

引入插件配置如下：
 &lt;build&gt;
      &lt;plugins&gt;
        &lt;plugin&gt;
          &lt;groupId&gt;mvc-generator-plugin</groupId&gt;
          &lt;artifactId&gt;generator-maven-plugin</artifactId&gt;
          &lt;version&gt;1.0.0-SNAPSHOT</version&gt;
          &lt;executions&gt;
            &lt;execution&gt;
              &lt;goals&gt;
                &lt;goal>mvc</goal&gt;
              &lt;/goals&gt;
              &lt;phase&gt;compile</phase&gt;
            &lt;/execution&gt;
          &lt;/executions&gt;
        &lt;/plugin&gt;
      &lt;/plugins&gt;
    &lt;/build&gt;
 运行命令如下：
 mvn generator:mvc
