package com.weisong.common.javaconfig;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JmxTestJavaConfig.class })
public class JmxTest {

    @Autowired
    private JmxTestBean mbean;

    @Test
    public void testJmx() throws Exception {
        final ObjectName objectName = new ObjectName(JmxTestJavaConfig.OBJECT_NAME);
        final JMXServiceURL jmxUrl = new JMXServiceURL(JmxTestJavaConfig.JMX_RMI_URL);
        final JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxUrl);
        final MBeanServerConnection mbsc = jmxConnector.getMBeanServerConnection();
        {
            // Test number
            final Integer number = (Integer) mbsc.invoke(objectName, "getNumber", null, null);
            Assert.assertEquals(mbean.getNumber(), number);
        }
        {
            // Test number
            final String name = (String) mbsc.invoke(objectName, "getName", null, null);
            Assert.assertEquals(mbean.getName(), name);
        }
    }
}
