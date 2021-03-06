package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * An class used as a holder of the @RunWith and @Suite 
 * annotations, necessary when someone needs to group
 * classes that include tests, for demonstrating Unit Testing.
 * @author DimitrisMazarakis (dimitrismazarakis77@gmail.com)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathTest.class, MyMathFactorialParameterizedTest.class})
public class MyMathTestSuite {

}
