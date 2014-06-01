package com.weisong.common.javaconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    CommonPropertyJavaConfig.class
  , CommonJmxJavaConfig.class
})
public class CommonCombinedJavaConfig {
}
