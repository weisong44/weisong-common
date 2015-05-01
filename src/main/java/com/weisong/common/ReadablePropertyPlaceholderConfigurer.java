package com.weisong.common;

import java.util.Properties;

import lombok.Getter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class ReadablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	@Getter private Properties properties;
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		super.processProperties(beanFactory, props);
		properties = props;
	}

}
