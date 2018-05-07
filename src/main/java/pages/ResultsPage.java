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
    public ElementBase tableBody(){
        return new ElementBase(resultTable().getElement("//tbody"));
    }
    public List<ElementBase> resultVacancy(){
        List<WebElement> webElementsVacancy = tableBody()
                .getElements("//h3[@class='fd-beefy-gunso f-vacancylist-vacancytitle']");
        return webElementsVacancy.stream().map(i -> new ElementBase(i)).limit(5).collect(Collectors.toList());
    }
    public List<ElementBase> resultCompany(){
        List<WebElement> webElementsCompany = tableBody()
                .getElements("//p[@class='f-vacancylist-companyname fd-merchant f-text-dark-bluegray']");
       return webElementsCompany.stream().map(i -> new ElementBase(i)).limit(5).collect(Collectors.toList());
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
            result.add("Vacancy: " + resultVacancy().get(i).getText() + ". Company: " + resultCompany().get(i).getText());
       }
       return result;
    }




}
