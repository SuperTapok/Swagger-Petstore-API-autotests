package configuration;

public class Settings {
    public static String URL = "https://petstore.swagger.io/v2";

    private Settings() {
    }

    private static class SingletonHolder {
        public static final Settings HOLDER_INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
