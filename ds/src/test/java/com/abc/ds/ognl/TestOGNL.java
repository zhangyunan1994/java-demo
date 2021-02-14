package com.abc.ds.ognl;

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

public class TestOGNL {

  @Test
  public void testExpression() throws OgnlException {

    MemberAccess memberAccess = new AbstractMemberAccess() {
      @Override
      public boolean isAccessible(Map context, Object target, Member member, String propertyName) {
        int modifiers = member.getModifiers();
        return Modifier.isPublic(modifiers);
      }
    };

    OgnlContext context = (OgnlContext) Ognl.createDefaultContext(this,
        memberAccess,
        new DefaultClassResolver(),
        new DefaultTypeConverter());

    context.put("verifyStatus", 1);
    Object expression = Ognl.parseExpression("#verifyStatus == 1");
    boolean result =(boolean) Ognl.getValue(expression, context, context.getRoot());
    Assert.assertTrue(result);

  }

}
