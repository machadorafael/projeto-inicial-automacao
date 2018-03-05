package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Utils {

	public static final String TEST_CONFIG_PROPERTIES_PATH = "src/test/resources/test-config.properties";

	public static Properties loadTestProperties() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(TEST_CONFIG_PROPERTIES_PATH);
		prop.load(input);
		input.close();
		return prop;
	}

	public static String getTestProperty(String propertyKey) {
		try {
			Properties prop = loadTestProperties();
			return prop.getProperty(propertyKey);
		} catch (Exception e) {
			String error_msg = String.format("Nao foi possivel carregar a propriedade %s. Erro %s",
					propertyKey, e.getMessage());
			throw new IllegalStateException(error_msg);
		}
	}
	
	public static String[] getSubDirectoriesNames(String path){
		File file = new File(path);
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		return directories;
	}
	
	public static String getDateTime(String formato) {
		DateFormat dateFormat = new SimpleDateFormat(formato);
		Date date = new Date();
		return dateFormat.format(date);
	}

}
