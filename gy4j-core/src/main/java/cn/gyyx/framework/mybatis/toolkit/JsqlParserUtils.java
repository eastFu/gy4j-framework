package cn.gyyx.framework.mybatis.toolkit;

import cn.gyyx.framework.mybatis.entity.CountOptimize;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.*;

import java.util.ArrayList;
import java.util.List;

public class JsqlParserUtils {

    private static List<SelectItem> countSelectItem = null;

    /**
     * jsqlparser方式获取select的count语句
     *
     * @param originalSql
     *            selectSQL
     * @return
     */
    public static CountOptimize jsqlparserCount(CountOptimize countOptimize, String originalSql) {
        String sqlCount;
        try {
            Select selectStatement = (Select) CCJSqlParserUtil.parse(originalSql);
            PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();
            Distinct distinct = plainSelect.getDistinct();
            List<Expression> groupBy = plainSelect.getGroupByColumnReferences();
            // 优化Order by
            List<OrderByElement> orderBy = plainSelect.getOrderByElements();
            // 添加包含groupby 不去除orderby
            if (CollectionUtils.isEmpty(groupBy) && CollectionUtils.isNotEmpty(orderBy)) {
                plainSelect.setOrderByElements(null);
                countOptimize.setOrderBy(false);
            }
            // 包含 distinct、groupBy不优化
            if (distinct != null || CollectionUtils.isNotEmpty(groupBy)) {
                sqlCount = String.format(SqlUtils.SQL_BASE_COUNT, selectStatement.toString());
                countOptimize.setCountSQL(sqlCount);
                return countOptimize;
            }
            List<SelectItem> selectCount = countSelectItem();
            plainSelect.setSelectItems(selectCount);
            sqlCount = selectStatement.toString();
        } catch (Exception e) {
            sqlCount = String.format(SqlUtils.SQL_BASE_COUNT, originalSql);
        }
        countOptimize.setCountSQL(sqlCount);
        return countOptimize;
    }

    /**
     * 获取jsqlparser中count的SelectItem
     *
     * @return
     */
    private static List<SelectItem> countSelectItem() {
        if (CollectionUtils.isNotEmpty(countSelectItem)) {
            return countSelectItem;
        }
        Function function = new Function();
        function.setName("COUNT");
        List<Expression> expressions = new ArrayList<>();
        LongValue longValue = new LongValue(1);
        ExpressionList expressionList = new ExpressionList();
        expressions.add(longValue);
        expressionList.setExpressions(expressions);
        function.setParameters(expressionList);
        countSelectItem = new ArrayList<>();
        SelectExpressionItem selectExpressionItem = new SelectExpressionItem(function);
        countSelectItem.add(selectExpressionItem);
        return countSelectItem;
    }
}
