package Pages.MePage;

import org.openqa.selenium.By;

public class MeLocators {

    public static By loginOrRegisterButton = By.id("com.zzkko:id/me_login_btn");
    public static By loginButton = By.xpath("//android.widget.TextView[contains(@text,'התחבר')]//parent::androidx.appcompat.app.ActionBar.Tab");
    public static By connectedUser = By.xpath("//android.widget.FrameLayout[@resource-id=\"com.zzkko:id/textView35\"]//android.widget.TextView");

}
