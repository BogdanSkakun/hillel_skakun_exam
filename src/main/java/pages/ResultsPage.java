package pages;

import enums.TimePeriod;
import interfaces.ElementBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    public ElementBase tableBody(){
        return new ElementBase(resultTable().getElement("//tbody"));
    }
    public implementation.ElementBase dropDownIcon(){
        return new implementation.ElementBase(getElement("//i[@class='fi-drop-down-icon f-vacancylist-dropdown-periodcaret']"));
    }
    public List<ElementBase> resultVacancy(){
        List<WebElement> webElementsVacancy = tableBody()
                .getElements("//h3[@class='fd-beefy-gunso f-vacancylist-vacancytitle']");
        return webElementsVacancy.stream().map(i -> new ElementBase(i)).collect(Collectors.toList());
    }
    public List<ElementBase> resultCompany(){
        List<WebElement> webElementsCompany = tableBody()
                .getElements("//p[@class='f-vacancylist-companyname fd-merchant f-text-dark-bluegray']");
       return webElementsCompany.stream().map(i -> new ElementBase(i)).collect(Collectors.toList());
    }
    public List<ElementBase> timePublishedList(){
        List<WebElement> timePublishList = tableBody()
                .getElements("//p[@class='f-vacancylist-agotime f-text-light-gray fd-craftsmen']");
        return timePublishList.stream().map(i -> new ElementBase(i)).collect(Collectors.toList());
    }
    public void printVacancy(List<String> list){
      log("Print results");
      list.stream().forEach(System.out::println);
    }


    public List<String> getResultList(){
        List<String> result = new ArrayList<>();
        result.add("QA Automation vacancies in city; "
                + getElement("//input[@id='content_HorizontalContainer1_CityPickerWork_inpCity']").getAttribute("value"));

       for(int i = 0; i < resultVacancy().size(); i ++){
            result.add("Vacancy: " + resultVacancy().get(i).getText() + ". Company: " + resultCompany().get(i).getText()
            + ". Time published: " + timePublishedList().get(i).getText());
       }
       return result.size()>5 ? result.stream().limit(5).collect(Collectors.toList()) : result;
    }

    public void setPublishedPeriod(TimePeriod timePeriod){
        log("Set time of publish " + timePeriod.getTimePeriod());
        Actions action = new Actions(driver);
        WebElement dropDownIcon = driver.findElement(By.xpath("//h2[@class='f-vacancylist-dropdown-wrap']"));
        action.moveToElement(dropDownIcon).moveToElement(driver.findElement(By.xpath("//a[text()='" + timePeriod.getTimePeriod() + "']")))
                .click().build().perform();

    }




}
