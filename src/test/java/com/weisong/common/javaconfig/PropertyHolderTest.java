package com.weisong.common.javaconfig;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weisong.common.javaconfig.CommonCombinedJavaConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CommonCombinedJavaConfig.class })
public class PropertyHolderTest {
    
    @Value("${test.prop1}") private String prop1;
    @Value("${test.prop2:unknown}") private String prop2;
    
    @Test
    public void testPropertiesRead() {
        Assert.assertEquals("abc", prop1);
        Assert.assertEquals("unknown", prop2);
    }
}
