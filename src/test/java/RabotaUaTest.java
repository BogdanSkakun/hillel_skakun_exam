import enums.City;
import enums.TimePeriod;
import org.junit.Test;
import pages.RabotaUaPage;
import pages.ResultsPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HillelNew5 on 06.05.2018.
 */
public class RabotaUaTest extends  TestBase{

    private RabotaUaPage rabotaUaPage;
    private ResultsPage resultsPage;
    private String jobvacancy = "QA Automation";
    private List<String> resultsList = new ArrayList<>();

    @Override
    public void beforeTest(){
       rabotaUaPage = new RabotaUaPage(driver);
       resultsPage = new ResultsPage(driver);


    }
    @Override
    public void afterTest(){

    }

    @Test
    public void searchQaAutomationVacancies(){
        rabotaUaPage.searchJob(jobvacancy, City.LVIV);
        resultsPage.setPublishedPeriod(TimePeriod.SEVEN_DAYS);
        resultsList = resultsPage.getResultList();
        rabotaUaPage.searchJob(jobvacancy, City.KYIV);
        resultsList.addAll( resultsPage.getResultList());
        rabotaUaPage.searchJob(jobvacancy, City.DNIPRO);
        resultsList.addAll( resultsPage.getResultList());
        resultsPage.printVacancy(resultsList);
    }

}
