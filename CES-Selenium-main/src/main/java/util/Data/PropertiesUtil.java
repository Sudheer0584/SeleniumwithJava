package util.Data;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Set;

import util.Common.BaseUtil;

public class PropertiesUtil extends BaseUtil{
	private Properties p;
	
	public PropertiesUtil(String PropName) {
		p=new Properties();  
		try {
				p.load(new FileReader(pathUtil.getFileinResources("Properties/"+PropName)));
			} catch (Exception e) {
			e.printStackTrace();
			try {
				String pathProp = pathUtil.getFileinResources("Properties/browser.properties");
				FileOutputStream outputProp = new FileOutputStream(pathProp);
				FileWriter write = new FileWriter(pathProp);
				write.write("BrowserName=chrome");
				write.write("\n");
				write.write("waitTime=15");
				write.close();
				outputProp.close();
				p.load(new FileReader(pathUtil.getFileinResources("Properties/"+PropName)));

		      } catch (Exception e2) {
		    	  e2.printStackTrace();
			}
			
		}  
	}


	public String getValue(String propertyName) {
		
		return p.getProperty(propertyName);
		
	}

	public Set<Object> getKeys() {
		return p.keySet();
	}
}
