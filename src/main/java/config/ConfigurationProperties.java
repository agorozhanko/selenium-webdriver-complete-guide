package config;

import core.BrowserType;
import lombok.Getter;
import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;


@Resource.Classpath("config/configuration.properties")
@Getter
public class ConfigurationProperties {

    @Property("endpoint")
    public String endpoint;

    @Property("timeout.implicitlywait")
    private Long timeoutImplicitlyWait = 5L;

    @Property("timeout.pageload")
    private Long timeoutPageLoad = 30L;

    @Property("test.browser.type")
    private BrowserType browserType;

    @Property("test.chrome.driver.path")
    private String chromeDriverPath;

    @Property("test.gecko.driver.path")
    private String firefoxDriverPath;
    @Property("test.msedge.driver.path")
    private String msEdgeDriverPath;
    @Property("test.ff.path")
    private String firefoxPath;
    @Property("test.ffnightly.path")
    private String firefoxNightlyPath;

    @Property("test.locale")
    private String locale = "en";

    private static ConfigurationProperties configProperties;

    private ConfigurationProperties() {
        PropertyLoader.newInstance().populate(this);
    }

    public static ConfigurationProperties getInstance() {
        if (configProperties == null) {
            configProperties = new ConfigurationProperties();
        }
        return configProperties;
    }

}
