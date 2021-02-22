package com.abc.ds.jexl3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.junit.Assert;
import org.junit.Test;

public class TestJexl3 {

  @Test
  public void testExpression() {
    JexlEngine jexl = new JexlBuilder().create();
    JexlContext jc = new MapContext();
    jc.set("verifyStatus", 1);
    JexlExpression expression = jexl.createExpression("verifyStatus == 1");
    boolean result = (boolean) expression.evaluate(jc);
    Assert.assertTrue(result);
  }

  @Test
  public void testSQL() {
    String sql = "select id, invite_code, phone, name \n"
        + "from user \n"
        + "where status = 1 \n"
        + "@if(:inviteCode != null) { and invite_code = :inviteCode }";

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("inviteCode", "dd");

    System.out.println(parseJexl(sql, params));
  }



  public String parseJexl(String jexlSql, Map<String, Object> params) {


    // 判断是否包含 @if
    List<String> results = StringUtil.matches(jexlSql, "@if([\\s\\S]*?)}");
    if (results.isEmpty()) {
      return jexlSql;
    }

    JexlEngine jexl = new JexlBuilder().create();
    JexlContext jc = new MapContext();

    for (String e : results) {
      System.out.println(e);
      List<String> sqlFragment = StringUtil.matches(e, "\\(([\\s\\S]*?)\\)|\\{([\\s\\S]*?)\\}");
      String sqlExp = sqlFragment.get(0).trim().substring(1, sqlFragment.get(0).length() - 1);
      List<String> sqlFragmentParam = StringUtil.matches(sqlExp, "\\?\\d+(\\.[A-Za-z]+)?|:[A-Za-z0-9]+(\\.[A-Za-z]+)?");
      for (String param : sqlFragmentParam) {
        String newSQLExp = "_" + param.substring(1);
        sqlExp = sqlExp.replace(param, newSQLExp);
        jc.set(newSQLExp, params.get(param.substring(1)));
      }
      JexlExpression expression = jexl.createExpression(sqlExp);
      Boolean o = (Boolean) expression.evaluate(jc);
      if (o) {
        jexlSql = jexlSql.replace(e, sqlFragment.get(1).trim().substring(1, sqlFragment.get(1).length() - 1));
      } else {
        jexlSql = jexlSql.replace(e, "");
      }
    }
    return jexlSql;
  }
}
