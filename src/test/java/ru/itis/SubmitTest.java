package ru.itis;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.bases.AuthTestBase;

public class SubmitTest extends AuthTestBase {

    @Test
    public void testSubmit() {
        getAppManager().getNavigationHelper().getSubmitPage();
        getAppManager().getPostHelper().addPost();

        Assert.assertTrue(getAppManager().getPostHelper().getLastAddedPostTitl());
    }
}
