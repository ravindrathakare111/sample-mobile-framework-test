package utils;

import java.io.File;
import java.util.Map;

public class Config {
    public String platform;
    public Android android;
    public IOS ios;

    public static class Android {
        public String app;
        public String platformName;
        public String deviceName;
        public String automationName;
        public String serverUrl;
        public String ignoreHiddenPolicyError;
        public String noReset;
    }

    public static class IOS {
        public String app;
        public String platformName;
        public String deviceName;
        public String automationName;
        public String platformVersion;
        public String serverUrl;
        public String ignoreHiddenPolicyError;
        public String noReset;
    }
}

