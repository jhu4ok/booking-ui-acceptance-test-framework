package setup;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class TestContext {
    private static final Logger LOG = LoggerFactory.getLogger(TestContext.class);

    private static String propertiesFilePath =
        "\\src\\main\\resources\\propertyFiles\\environment_variables.properties";

    private static Properties prop = loadProperties(propertiesFilePath);

    private String baseUrl = prop.getProperty("BASE_URL");

    private String friendsUrl = prop.getProperty("FRIENDS_URL");

    private String aboutEndpoint = prop.getProperty("ABOUT_ENDPOINT");

    private String soonEndpoint = prop.getProperty("SOON_ENDPOINT");

    private String promotionsEndpoint = prop.getProperty("PROMOTIONS_ENDPOINT");

    private String helpEndpoint = prop.getProperty("HELP_ENDPOINT");

    private String cinemasEndpoint = prop.getProperty("CINEMAS_ENDPOINT");

    private String cinemaEndpoint = prop.getProperty("CINEMA_ENDPOINT");

    private String loginEndpoint = prop.getProperty("LOGIN_ENDPOINT");

    private String boardEndpoint = prop.getProperty("BOARD_ENDPOINT");

    private String filmEndpoint = prop.getProperty("FILM_ENDPOINT");

    public TestContext() {
        loadProperties(propertiesFilePath);
    }

    private static Properties loadProperties(String propertiesFilePath) {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + propertiesFilePath);
            properties.load(input);
        } catch (IOException e) {
            LOG.error("Error read properties file: " + e.getMessage());
        }
        return properties;
    }
}
