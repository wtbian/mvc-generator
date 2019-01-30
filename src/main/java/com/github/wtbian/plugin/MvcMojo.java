package com.github.wtbian.plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.github.wtbian.core.Generator;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "mvc")
public class MvcMojo
        extends AbstractMojo {

    @Parameter(defaultValue = "${project.build.sourceDirectory}", required = true, readonly = true)
    private String sourceDirectory;

    @Parameter(property = "sqlScript")
    private String sqlScript;

    @Parameter(property = "daoDirectory")
    private String daoDirectory;

    @Parameter(property = "serviceDirectory")
    private String serviceDirectory;

    @Parameter(property = "controllerDirectory")
    private String controllerDirectory;

    @Parameter(property = "voDirectory")
    private String voDirectory;

    @Parameter(property = "domainDirectory")
    private String domainDirectory;

    public void execute()
            throws MojoExecutionException {

        if (StringUtils.isBlank(sqlScript)) {
            getLog().error(new Exception("sqlScript:" + this.sqlScript + ", must be observe SQL syntax"));
            return;
        }

        try {
            Generator.execute(sourceDirectory, sqlScript, daoDirectory, serviceDirectory, controllerDirectory, voDirectory, domainDirectory);
        } catch (Exception e) {
            getLog().error(e);
        }
    }
}
