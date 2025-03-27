package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TakeSnapshot {

    public static void takeSnapShot(Driver driver) throws Exception{
        int numberRandom = (int)(Math.random() * 9000) + 1000;
        String fileName = "image_"+numberRandom+".png";
        String filePath = "target/images/"+fileName;

        TakesScreenshot scrShot =((TakesScreenshot)driver.getDriver());
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(new File(filePath).getAbsolutePath());
        Files.copy(SrcFile.toPath(), DestFile.toPath());

        try (InputStream is = Files.newInputStream(Paths.get(filePath))) {
            Allure.attachment(fileName, is);
        }
    }
}
