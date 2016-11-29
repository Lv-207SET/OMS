import enums.ConditionFilterDropdownList;
import enums.FieldFilterDropdownList;
import pages.CreateReportPage;

/**
 * Created by Antonio on 30.11.2016.
 */
public class Test extends TestRunner {



    @org.testng.annotations.Test
    public void testMethod(){

        driver.get("https://atmkv.github.io/CreateReportPage.html");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        CreateReportPage page = new CreateReportPage(driver);
        page
                .selectField(FieldFilterDropdownList.FIRST_NAME.getFieldName())
                .selectCondition(ConditionFilterDropdownList.CONTAINS.getNameOfConditionFilterField())
                /*.search("Con")*/;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
