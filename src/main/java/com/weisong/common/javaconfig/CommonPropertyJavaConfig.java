package com.weisong.common.javaconfig;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class CommonPropertyJavaConfig {
    
    final private static String[] locations = new String[] {
            "classpath*:/properties/*.properties"
          , "file:/etc/override.properties"
    };
    
    @Bean
    static public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws Exception {
        PropertyPlaceholderConfigurer c = new PropertyPlaceholderConfigurer();
        c.setIgnoreResourceNotFound(true);
        c.setIgnoreUnresolvablePlaceholders(true);
        c.setLocations(createResources(locations));
        return c;
    }

    static private Resource[] createResources(String... locations) throws Exception {
        List<Resource> resources = new LinkedList<>();
        for(String loc : locations) {
            Resource[] temp = new PathMatchingResourcePatternResolver().getResources(loc);
            resources.addAll(Arrays.asList(temp));
        }
        return resources.toArray(new Resource[resources.size()]);
    }
}
