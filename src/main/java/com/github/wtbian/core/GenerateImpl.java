package com.github.wtbian.core;

import freemarker.template.Configuration;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * Created by bianwentao on 2019/1/27.
 */
public class GenerateImpl implements Generate{

    private Context ctx;

    private Configuration cfg;

    public GenerateImpl(Context ctx, Configuration cfg) {
        this.ctx = ctx;
        this.cfg = cfg;
    }

    @Override
    public void generateDomain() throws IOException {
        Consumer<Entity> consumer = new ProcessImpl(cfg.getTemplate("domain_entity.ftl","utf-8"));
        consumer.accept(EntityFactory.getEntity(ctx, "domain"));
    }

    @Override
    public void generateVo() throws IOException {
        Consumer<Entity> consumer = new ProcessImpl(cfg.getTemplate("vo_entity.ftl","utf-8"));
        consumer.accept(EntityFactory.getEntity(ctx, "vo"));
    }

    @Override
    public void generateDao() throws IOException {
        Consumer<Entity> consumer = new ProcessImpl(cfg.getTemplate("dao_entity.ftl","utf-8"));
        consumer.accept(EntityFactory.getEntity(ctx, "dao"));
    }

    @Override
    public void generateService() throws IOException {
        Consumer<Entity> consumer = new ProcessImpl(cfg.getTemplate("service_entity.ftl","utf-8"));
        consumer.accept(EntityFactory.getEntity(ctx, "service"));
    }

    @Override
    public void generateController() throws IOException {
        Consumer<Entity> consumer = new ProcessImpl(cfg.getTemplate("controller_entity.ftl","utf-8"));
        consumer.accept(EntityFactory.getEntity(ctx, "controller"));
    }

}
