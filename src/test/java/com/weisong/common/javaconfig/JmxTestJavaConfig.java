package com.weisong.common.javaconfig;

import java.rmi.registry.Registry;

import javax.management.remote.JMXConnectorServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

@Configuration
@Import({
    CommonCombinedJavaConfig.class
})
public class JmxTestJavaConfig {
    
    final static String OBJECT_NAME = "weisong:type=test,name=test";
    final static String JMX_RMI_URL = "service:jmx:rmi://localhost/jndi/rmi://localhost:1099/jmxrmi";
    
    @Autowired private RmiRegistryFactoryBean rmiRegistryFactoryBean;
    @Autowired private ConnectorServerFactoryBean connectorServerFactoryBean;
    
    @Bean
    public RmiRegistryFactoryBean rmiRegistryFactoryBean() {
        RmiRegistryFactoryBean factoryBean = new RmiRegistryFactoryBean();
        factoryBean.setAlwaysCreate(true);
        factoryBean.setPort(1099);
        return factoryBean;
    }
    
    @Bean 
    public Registry rmiRegistry() throws Exception {
        return rmiRegistryFactoryBean.getObject();
    }
    
    @Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean() throws Exception {
        ConnectorServerFactoryBean factoryBean = new ConnectorServerFactoryBean();
        factoryBean.setObjectName(OBJECT_NAME);
        factoryBean.setServiceUrl(JMX_RMI_URL);
        return factoryBean;
    }
    
    @Bean
    public JMXConnectorServer jmxConnectorServer() throws Exception {
        return connectorServerFactoryBean.getObject();
    }
    
    @Bean
    public JmxTestBean testJmxBean() {
        return new JmxTestBean();
    }
}
