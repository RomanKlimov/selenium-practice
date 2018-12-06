package ru.itis.bases;

import org.junit.After;
import ru.itis.AppManager;
import org.junit.Before;

public class TestBase {

    private AppManager appManager;

    public AppManager getAppManager() {
        return appManager;
    }

    @Before
    public void setUp() throws Exception {
        appManager = AppManager.getInstance();
    }

    @After
    public void tearDown() throws Exception {
        appManager.stop();
    }

    protected void setApp(AppManager appManager) {
        this.appManager = appManager;
    }
}
