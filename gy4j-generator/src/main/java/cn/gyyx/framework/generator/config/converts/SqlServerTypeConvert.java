package cn.gyyx.framework.generator.config.converts;

import cn.gyyx.framework.generator.config.ITypeConvert;
import cn.gyyx.framework.generator.config.rules.DbColumnType;

public class SqlServerTypeConvert implements ITypeConvert {

    @Override
    public DbColumnType processTypeConvert(String fieldType) {
        String t = fieldType.toLowerCase();
        if (t.contains("char") || t.contains("text") || t.contains("xml")) {
            return DbColumnType.STRING;
        } else if (t.contains("bigint")) {
            return DbColumnType.LONG;
        } else if (t.contains("int")) {
            return DbColumnType.INTEGER;
        } else if (t.contains("date") || t.contains("time")) {
            return DbColumnType.DATE;
        } else if (t.contains("text")) {
            return DbColumnType.STRING;
        } else if (t.contains("bit")) {
            return DbColumnType.BOOLEAN;
        } else if (t.contains("decimal") || t.contains("numeric")) {
            return DbColumnType.DOUBLE;
        } else if (t.contains("money")) {
            return DbColumnType.BIG_DECIMAL;
        } else if (t.contains("binary") || t.contains("image")) {
            return DbColumnType.BYTE_ARRAY;
        } else if (t.contains("float") || t.contains("real")) {
            return DbColumnType.FLOAT;
        }
        return DbColumnType.STRING;
    }

}