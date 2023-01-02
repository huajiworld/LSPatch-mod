package org.lsposed.jshook.share;

public class Constants {

    final static public String CONFIG_ASSET_PATH = "assets/jshook/config.json";
    final static public String LOADER_DEX_ASSET_PATH = "assets/jshook/loader.dex";
    final static public String META_LOADER_DEX_ASSET_PATH = "assets/jshook/metaloader.dex";
    final static public String ORIGINAL_APK_ASSET_PATH = "assets/jshook/origin.apk";

    final static public String PATCH_FILE_SUFFIX = "-jshooked.apk";
    final static public String PROXY_APP_COMPONENT_FACTORY = "org.lsposed.jshook.metaloader.LSPAppComponentFactoryStub";
    final static public String MANAGER_PACKAGE_NAME = "me.jsonet.jshook";
    final static public int MIN_ROLLING_VERSION_CODE = 341;

    final static public int SIGBYPASS_LV_DISABLE = 0;
    final static public int SIGBYPASS_LV_PM = 1;
    final static public int SIGBYPASS_LV_PM_OPENAT = 2;
    final static public int SIGBYPASS_LV_MAX = 3;
}
