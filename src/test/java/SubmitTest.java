import org.junit.Test;

public class SubmitTest extends TestBase{

    @Test
    public void testSubmit() {
        OpenHomePage();
        Login();
        OpenSubmitPage();
        CreatePost();
    }
}
