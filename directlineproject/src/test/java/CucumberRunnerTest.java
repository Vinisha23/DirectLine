import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:Feature/",
        glue = "classpath:tests",
        format = {"pretty", "html:target/test-report", "json:target/test-report.json", "junit:target/test-report.xml"}
)

public class CucumberRunnerTest {

}
