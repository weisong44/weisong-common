package com.weisong.common.javaconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.jmx.export.naming.ObjectNamingStrategy;
import org.springframework.jmx.support.RegistrationPolicy;

@Configuration
public class CommonJmxJavaConfig {
	
	@Autowired(required = false)
	private ObjectNamingStrategy namingStrategy;
	
    @Bean
    public AnnotationMBeanExporter annotationMBeanExporter() {
        AnnotationMBeanExporter exporter = new AnnotationMBeanExporter();
        exporter.setRegistrationPolicy(RegistrationPolicy.REPLACE_EXISTING);
        if(namingStrategy != null) {
        	exporter.setNamingStrategy(namingStrategy);
        }
        return exporter;
    }
}
