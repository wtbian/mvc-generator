package ${entity.javaPackage};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ${entity.commonPackage}.dao.${entity.base?cap_first}Dao;
import ${entity.commonPackage}.domain.${entity.base?cap_first};
import ${entity.commonPackage}.vo.${entity.base?cap_first}VO;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* This code is generated by FreeMarker
* @author bianwentao
*
*/
@Service
public class ${entity.base?cap_first}Service {

    private static final Logger logger = LoggerFactory.getLogger(${entity.className}.class);

    @Autowired
    private ${entity.base?cap_first}Dao ${entity.base}Dao;

    @Transactional(rollbackFor = Exception.class)
    public void insert(${entity.base?cap_first} ${entity.base}) {
        ${entity.base}Dao.insert(${entity.base});
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(${entity.base?cap_first} ${entity.base}) {
        ${entity.base}Dao.update(${entity.base});
    }

    public ${entity.base?cap_first} getById(Integer id) {
        ${entity.base?cap_first} ${entity.base} = null;
        ${entity.base} = ${entity.base}Dao.selectById(id);
        return ${entity.base};
    }

    public List<${entity.base?cap_first}VO> getAll() {
        List<${entity.base?cap_first}VO> ${entity.base}List = null;
        ${entity.base}List = VoUtil.toTarget(${entity.base}Dao.selectAll(), ${entity.base?cap_first}VO.class);
        return ${entity.base}List;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(List<Integer> ids) {
        ${entity.base}Dao.deleteBatch(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        ${entity.base}Dao.delete(id);
    }
}