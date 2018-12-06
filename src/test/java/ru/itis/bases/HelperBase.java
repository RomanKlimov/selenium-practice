package ru.itis.bases;

import ru.itis.AppManager;

public class HelperBase {

    private AppManager appManager;

    public HelperBase(AppManager appManager) {
        this.appManager = appManager;
    }

    public String getBaseUrl() {
        return appManager.getBaseUrl();
    }

    public AppManager getAppManager() {
        return appManager;
    }
}
