package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/abs.properties"
})
public interface AppConfig extends Config {

    @Key("apiUrl")
    String apiUrl();

}
