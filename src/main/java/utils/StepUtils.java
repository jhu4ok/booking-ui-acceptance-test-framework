package utils;

;
import lombok.extern.slf4j.Slf4j;
import setup.TestContext;

@Slf4j
public class StepUtils {

    protected TestContext testContext = new TestContext();

    protected Context context;

    public StepUtils() {
        this.context = new Context();
    }
}
