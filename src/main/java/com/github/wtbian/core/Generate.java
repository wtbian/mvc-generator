package com.github.wtbian.core;

import java.io.IOException;

/**
 * Created by bianwentao on 2019/1/27.
 */
public interface Generate {
    void generateDomain() throws IOException;
    void generateVo() throws IOException;
    void generateDao() throws IOException;
    void generateService() throws IOException;
    void generateController() throws IOException;
}
