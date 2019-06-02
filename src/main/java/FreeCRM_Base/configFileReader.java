package FreeCRM_Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configFileReader {
	Properties prop;	
	String sourceFolder;
	configFileReader(String sourceFolder){	
		this.sourceFolder = sourceFolder;
	}
	
	public void loadPropertiesFile() {
		try {
			File propertiesFileObj = new File(sourceFolder+"/GlobalConfig/config.properties");
			FileInputStream fls = new FileInputStream(propertiesFileObj);
			prop = new Properties();
			prop.load(fls);        //stored in key-value form
			fls.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("config file not found at "+sourceFolder+"/GlobalConfig/config.properties");
		}
	}
	
	
	@SuppressWarnings("unused")
	public String getApplicationName() {
		String appName =prop.getProperty("ApplicationName");
		if(appName != null && appName != "") {
			return appName;
		}
		else
			throw new RuntimeException("ApplicationName value is not specified");
	}
	
	
	@SuppressWarnings("unused")
	public String getUrl() {
		String url = prop.getProperty("url");
		if(url != null && url != "") {
			return url;
		}
		else
			throw new RuntimeException("URL value is not specified");
	}
	
	@SuppressWarnings("unused")
	public String getPassword() {
		String password = prop.getProperty("password");
		if(password != null && password != "") {
			return password;
		}
		else
			throw new RuntimeException("password value is not specified");
	}
	
	@SuppressWarnings("unused")
	public String getUsername() {
		String username = prop.getProperty("username");
		if(username != null|| username != "") {
			return username;
		}
		else
			throw new RuntimeException("Username value is not specified");
	}
	
	public String getInputDataFile() {
		String inputdatafile = prop.getProperty("Inputdatafile");
		if(inputdatafile != null && inputdatafile != "") {
			return inputdatafile;
		}
		else 
			throw new RuntimeException("Inputdatafile value is not specified");
	}
	}

