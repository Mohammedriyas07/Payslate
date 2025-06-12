package Helper;

import Drivermanager.Drivermanager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.Actions;

public class Action {

    private static Action actionclass;

    private Action() {}

    public static Action getInstance() {
        if (actionclass == null) {
            actionclass = new Action();
        }
        return actionclass;
    }

    public void type(String value) {
        AppiumDriver driver = Drivermanager.getInstance().getDriver();
        Actions actions = new Actions(driver);
        actions.sendKeys(value).perform();
    }
}
