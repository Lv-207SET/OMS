package JavaRestClient.Annotations;

import org.apache.xpath.SourceTree;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.internal.annotations.TestAnnotation;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Dmytro Voropai on 14/01/2017.
 */
public class TransferToJiraImplementation {
    public static void getAnnotatedMethods(){
        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls( ClasspathHelper.forPackage("com.softserve.edu.oms.tests" ))
                        .setScanners( new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(TransferToJira.class);
        System.out.println(methods.size());
        for(Method method : methods){
            String nameOfMethodInJira= method.getAnnotation(TestCaseId.class).value();
            System.out.println(nameOfMethodInJira);
        }
    }
}
