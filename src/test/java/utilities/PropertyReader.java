package utilities;

import java.util.Properties;

public class PropertyReader {

	private Properties properties;
	
	public PropertyReader(DependencyInjector injector) {
		properties = injector.getProperties();
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
