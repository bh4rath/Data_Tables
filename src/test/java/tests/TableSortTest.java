package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.stream.Collectors;

public class TableSortTest extends BaseTest {

    @Test
    public void sortTableTest() {
        driver.get("E:\\Data Tables\\Web\\table.html");

        var table = driver.findElement(By.xpath("//table[@id='myTable']"));
        var cells = table.findElements(By.cssSelector("#myTable tr td:first-child"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        Collections.sort(cells);

        table.findElement(By.xpath("//th[text()='Name']")).click();
        var actualCells = table.findElements(By.cssSelector("#myTable tr td:first-child"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        Assert.assertEquals(actualCells, cells);
    }
}
