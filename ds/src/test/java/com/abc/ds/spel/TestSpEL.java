package com.abc.ds.spel;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Map;
import ognl.AbstractMemberAccess;
import ognl.DefaultClassResolver;
import ognl.DefaultTypeConverter;
import ognl.MemberAccess;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class TestSpEL {

  @Test
  public void testExpression() throws OgnlException {
    ExpressionParser parser = new SpelExpressionParser();
    Expression expression = parser.parseExpression("#verifyStatus == 1");

    EvaluationContext context = new StandardEvaluationContext();
    context.setVariable("verifyStatus", 1);
    boolean result = (boolean) expression.getValue(context);
    Assert.assertTrue(result);
  }

}
