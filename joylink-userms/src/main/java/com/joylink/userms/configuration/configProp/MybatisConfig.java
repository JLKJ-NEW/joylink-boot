package com.joylink.userms.configuration.configProp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="mybatis")
public class MybatisConfig {
	
	private String configLocations;
	
	private String mapperLocations;

	public String getConfigLocations() {
		return configLocations;
	}

	public void setConfigLocations(String configLocations) {
		this.configLocations = configLocations;
	}

	public String getMapperLocations() {
		return mapperLocations;
	}

	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}
	
}
