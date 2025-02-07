package pages;

import base.UIActions;
import org.openqa.selenium.By;

public class HomePage {
    UIActions ui = new UIActions();
    private final By RenewalLink = By.linkText("Renew Now!");
    private final By registerLink = By.xpath("//*[@id=\"app-content\"]/header/div/div[2]/div/div[2]/div[1]/div/button");

    public RegistrationPage openRegistrationPage()
    {
        ui.clickOn(RenewalLink);
        ui.clickOn(registerLink);
        return new RegistrationPage();
    }
}
