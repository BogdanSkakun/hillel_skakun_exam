package pages;

import interfaces.ElementBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by HillelNew5 on 06.05.2018.
 */
public class ResultsPage extends PageBase {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public ElementBase resultTable(){
        return new ElementBase(getElement("//table[@class='f-vacancylist-tablewrap']"));
    }



    public List<String> getVacancyList(){
        List<String> result = new ArrayList<>();
        List<WebElement> vacancyElements = resultTable().getElements("//h3[@class='fd-beefy-gunso f-vacancylist-vacancytitle']");
        List<WebElement> companyElements = resultTable().getElements("//p[@class='f-vacancylist-companyname fd-merchant f-text-dark-bluegray']");
       for(int i = 0; i < 5; i ++){
            result.add("Vacancy: " + vacancyElements.get(i).getText() + ". Company: " + companyElements.get(i).getText());
       }
       return result;
    }

    public void printVacancies(){
        log("Print results");
        System.out.println("QA Automation vacancies in city; "
                + getElement("//input[@id='content_HorizontalContainer1_CityPickerWork_inpCity']").getAttribute("value"));
        getVacancyList().forEach(System.out::println);
    }


}
