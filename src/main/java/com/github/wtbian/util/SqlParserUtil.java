package com.github.wtbian.util;

import com.github.wtbian.core.Context;
import com.github.wtbian.core.Entity;
import com.github.wtbian.core.Property;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bianwentao on 2019/1/27.
 */
public class SqlParserUtil {
    /**
     * 解析建表语句
     * @param sql
     * @return
     * @throws JSQLParserException
     */
    public static Context parseCreateTable(String sql) throws JSQLParserException {
        Context ctx = Context.getInstance();
        CCJSqlParserManager parser = new CCJSqlParserManager();
        Statement stmt = parser.parse(new StringReader(sql.replace("`","")));
        if (stmt instanceof CreateTable) {
            CreateTable createTable = (CreateTable) stmt;
            List<ColumnDefinition> columnDefinitionList = createTable.getColumnDefinitions();
            Table table = createTable.getTable();
            String str = table.getName();
            ctx.setTableName(str);
            List<Property> propertyList = new ArrayList<Property>();
            for (ColumnDefinition columnDefinition : columnDefinitionList) {
                Property attr = new Property();
                attr.setJavaType(columnDefinition.getColDataType().getDataType());
                attr.setPropertyName(columnDefinition.getColumnName());
                List<String> comments = columnDefinition.getColumnSpecStrings();
                attr.setComment(comments.get(comments.size() - 1).replaceAll("\'",""));
                propertyList.add(attr);
            }
            ctx.setProperties(propertyList);
        }
        return ctx;
    }
}
