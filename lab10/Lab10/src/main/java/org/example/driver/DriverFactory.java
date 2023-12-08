package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    public static WebDriver createDriver() {
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
        return new EdgeDriver();
    }
}
