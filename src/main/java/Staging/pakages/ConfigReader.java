package Staging.pakages;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
private Properties prop;
public Properties in_itprop() throws IOException {
	prop =new Properties();
	try {
	FileInputStream ip = new FileInputStream("src/src/test/resurces/Satging/config/StagingConfig.properties");
	prop.load(ip);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
		
	}
	catch(IOException e) {
		e.printStackTrace();
	}
return prop;
}

}
