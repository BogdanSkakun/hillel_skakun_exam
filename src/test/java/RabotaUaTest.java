import enums.City;
import org.junit.Test;
import pages.RabotaUaPage;
import pages.ResultsPage;

/**
 * Created by HillelNew5 on 06.05.2018.
 */
public class RabotaUaTest extends  TestBase{

    private RabotaUaPage rabotaUaPage;
    private ResultsPage resultsPage;
    private String jobvacancy = "QA Automation";

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
        resultsPage.printVacancies();
    }

}
