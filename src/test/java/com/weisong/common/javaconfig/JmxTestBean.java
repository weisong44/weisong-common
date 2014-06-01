package com.weisong.common.javaconfig;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = JmxTestJavaConfig.OBJECT_NAME)
public class JmxTestBean {
    
    @ManagedAttribute
    public Integer getNumber() {
        return 100;
    }
    
    @ManagedAttribute
    public String getName() {
        return "name";
    }
}
