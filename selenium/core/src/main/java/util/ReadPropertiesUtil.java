package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesUtil {
    private static Properties properties = new Properties();
    private static InputStream input;

    public static Properties read() {
        try {
            input = ReadPropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }

    public static String getProperty(String property){
        return read().getProperty(property);
    }
}