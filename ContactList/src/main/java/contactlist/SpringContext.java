package contactlist;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

    private static String configName = "SpringConfig.xml";
    private static AbstractApplicationContext abstractApplicationContext;

    private SpringContext() {}

    /**
     * @return instance of AbstractApplicationContext if it exists or create new one
     */
    public static AbstractApplicationContext getAbstractApplicationContext() {
        if (abstractApplicationContext == null) {
            SpringContext.abstractApplicationContext = new ClassPathXmlApplicationContext(SpringContext.configName);
        }
        return abstractApplicationContext;
    }
}
