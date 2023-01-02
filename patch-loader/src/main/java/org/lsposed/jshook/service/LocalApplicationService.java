package org.lsposed.jshook.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import org.lsposed.jshook.loader.util.FileUtils;
import org.lsposed.jshook.util.ModuleLoader;
import org.lsposed.jshook.models.Module;
import org.lsposed.jshook.service.ILSPApplicationService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

public class LocalApplicationService extends ILSPApplicationService.Stub {

    private static final String TAG = "JsHook";

    private final List<Module> modules = new ArrayList<>();

    public LocalApplicationService(Context context) {
        try {
            for (var name : context.getAssets().list("jshook/modules")) {
                String packageName = name.substring(0, name.length() - 4);
                String modulePath = context.getCacheDir() + "/jshook/" + packageName + "/";
                String cacheApkPath;
                try (ZipFile sourceFile = new ZipFile(context.getPackageResourcePath())) {
                    cacheApkPath = modulePath + sourceFile.getEntry("assets/jshook/modules/" + name).getCrc() + ".apk";
                }

                if (!Files.exists(Paths.get(cacheApkPath))) {
                    Log.i(TAG, "Extract module apk: " + packageName);
                    FileUtils.deleteFolderIfExists(Paths.get(modulePath));
                    Files.createDirectories(Paths.get(modulePath));
                    try (var is = context.getAssets().open("jshook/modules/" + name)) {
                        Files.copy(is, Paths.get(cacheApkPath));
                    }
                }

                var module = new Module();
                module.apkPath = cacheApkPath;
                module.packageName = packageName;
                module.file = ModuleLoader.loadModule(cacheApkPath);
                modules.add(module);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error when initializing LocalApplicationServiceClient", e);
        }
    }

    @Override
    public IBinder requestModuleBinder(String name) {
        return null;
    }

    @Override
    public List<Module> getModulesList() {
        return modules;
    }

    @Override
    public String getPrefsPath(String packageName) {
        return new File(Environment.getDataDirectory(), "data/" + packageName + "/shared_prefs/").getAbsolutePath();
    }

    @Override
    public Bundle requestRemotePreference(String packageName, int userId, IBinder callback) {
        return null;
    }

    @Override
    public ParcelFileDescriptor requestInjectedManagerBinder(List<IBinder> binder) {
        return null;
    }
}
