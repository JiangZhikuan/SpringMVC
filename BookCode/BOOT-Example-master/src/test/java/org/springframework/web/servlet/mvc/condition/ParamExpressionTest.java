package org.springframework.web.servlet.mvc.condition;

import org.junit.Assert;
import org.junit.Test;

public class ParamExpressionTest {

    @Test
    public void testParamExpression() {
        ParamsRequestCondition.ParamExpression expressionLower = new ParamsRequestCondition.ParamExpression("key=value");
        ParamsRequestCondition.ParamExpression expressionUpper = new ParamsRequestCondition.ParamExpression("KEY=value");
        Assert.assertNotEquals(expressionLower.hashCode(), expressionUpper.hashCode());
        Assert.assertNotEquals(expressionLower, expressionUpper);
    }
}
