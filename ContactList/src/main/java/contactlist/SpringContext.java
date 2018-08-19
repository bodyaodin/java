package contactlist;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

    /**
     * name of Spring xml configuration file
     */
    private static String configName = "SpringConfig.xml";
    private static AbstractApplicationContext abstractApplicationContext;

    private SpringContext() {}

    /**
     * @return instance of AbstractApplicationContext if it exists or create new one
     */
    public static AbstractApplicationContext getAbstractApplicationContext() {
        if (abstractApplicationContext == null) {
            abstractApplicationContext = new ClassPathXmlApplicationContext(configName);
        }
        return abstractApplicationContext;
    }
}
