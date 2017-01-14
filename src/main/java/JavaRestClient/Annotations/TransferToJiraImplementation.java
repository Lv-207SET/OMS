package JavaRestClient.Annotations;

import JavaRestClient.TestCase;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Dmytro Voropai on 14/01/2017.
 */
public class TransferToJiraImplementation {
    public static HashMap<String, TestCase> getAnnotatedMethods(){
        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls( ClasspathHelper.forPackage("com.softserve.edu.oms.tests" ))
                        .setScanners( new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(TransferToJira.class);
        HashMap<String, TestCase> testCasesList = new HashMap<>();
        for(Method method : methods){
            testCasesList.put(method.getName(), new TestCase(
                    method.getAnnotation(TestCaseId.class).value(),
                    method.getAnnotation(Step.class).value(),
                    method.getAnnotation(Description.class).value()));
        }
        return testCasesList;
    }
}
