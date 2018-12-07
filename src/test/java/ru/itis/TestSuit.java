package ru.itis;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({ LoginTest.class, SubmitTest.class })
public class TestSuit {

    @AfterClass
    public static void tearDown() {
        AppManager.getInstance().shutDown();
    }
}
