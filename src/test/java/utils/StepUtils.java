package utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import setup.TestContext;


public class StepUtils {

    protected static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

    protected TestContext testContext = new TestContext();

    protected Context context;

    public StepUtils() {
        this.context = new Context();
    }
}
