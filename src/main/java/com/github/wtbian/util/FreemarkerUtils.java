package com.github.wtbian.util;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.FileOutputStream;

public class FreemarkerUtils {
	private static final Logger logger = LoggerFactory.getLogger(FreemarkerUtils.class);

	private static PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

	private static String suffix = ".ftl";

	private static String folderName = "mvc-generator";

	private static String tmpdir = System.getProperty("java.io.tmpdir") + folderName + "/";

	private static String[] templatesName = { "domain_entity", "vo_entity", "dao_entity",
			"service_entity", "controller_entity"};

	public static void init(Configuration cfg) throws Exception {
		File tmpFile = new File(tmpdir);
		if (!tmpFile.exists()) {
			tmpFile.mkdirs();
		}
		for (String templateName : templatesName) {
			Resource resource = patternResolver.getResource("classpath:META-INF/" + templateName + suffix);

			FileCopyUtils.copy(resource.getInputStream(),
					new FileOutputStream(new File(tmpdir, templateName + suffix)));
		}

		FileTemplateLoader templateLoader = new FileTemplateLoader(new File(tmpdir));

		cfg.setTemplateLoader(templateLoader);
	}

	public static void destroy() throws Exception {
		if (!FileSystemUtils.deleteRecursively(new File(tmpdir)))
			System.out.println("---------------delete tmp file-----------------");
	}

}
