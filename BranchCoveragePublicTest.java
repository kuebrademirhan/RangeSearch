import java.lang.reflect.*;
import java.io.*;

public class BranchCoveragePublicTest {
	// ========== SYSTEM ==========
	protected static final String EX_NAME_RangeSearchTest = "BranchCoverage-RangeSearchTest";
	protected static final String EX_NAME_SocksTest = "BranchCoverage-SocksTest";

	// ========== Test the test #-) ==========
	@org.junit.Test(timeout = 666)
	public void pubTest__RangeSearchTest__EXTREMELY_TACITURN_SmokeTest() {
		new RangeSearchTest();
	}

	@org.junit.Test(timeout = 666)
	public void pubTest__SocksTest__EXTREMELY_TACITURN_SmokeTest() {
		new SocksTest();
	}

	// ========== main ==========
	// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
	// to run on command line: java -cp .:/usr/share/java/junit4.jar <nameOfThisClass> <nameOfYourTestClass>
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Run me with exactly one argument denoting the name of your test class!");
		} else {
			try {
				Class<?> testClass = ClassLoader.getSystemClassLoader().loadClass(args[0]);
				System.out.println("JUnit AuD-fake-version 0.1");
				Constructor<?> constructor;
				int testsRun = 0, testsFailed = 0;
				StringBuilder result = new StringBuilder();
				long startTime = System.currentTimeMillis();
				System.setErr(new PrintStream(new ByteArrayOutputStream()));
				try {
					constructor = testClass.getDeclaredConstructor();
					if (!Modifier.isPublic(constructor.getModifiers())) {
						System.out.println("Test class should have exactly one public constructor");
					}
					Object target = constructor.newInstance();
					for (Method testCaseMethod : testClass.getMethods()) {
						if (testCaseMethod.isAnnotationPresent(Test.class) && testCaseMethod.getParameterTypes().length == 0) {
							try {
								testsRun++;
								testCaseMethod.invoke(target);
								System.out.print(".");
							} catch (Throwable t) {
								testsFailed++;
								System.out.print("E");
								result.append(testsFailed).append(") ").append(testCaseMethod.getName()).append("(").append(testClass.getName()).append(")").append("\n");
								StringWriter sw = new StringWriter();
								PrintWriter pw = new PrintWriter(sw);
								t.getCause().printStackTrace(pw);
								result.append(sw);
							}
						}
					}
				} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ignored) {
					System.out.println("Test class should have exactly one public zero-argument constructor");
				}
				long endTime = System.currentTimeMillis();
				System.out.println();
				System.out.println("Time: " + (endTime - startTime) / 1000d);
				if (testsFailed != 0) {
					System.out.println("There " + (testsFailed == 1 ? "was " : "were ") + testsFailed + " failure" + (testsFailed == 1 ? "" : "s") + ":");
					System.out.println(result);
					System.out.println("FAILURES!!!");
					System.out.println("Tests run: " + testsRun + ",  Failures: " + testsFailed);
				} else {
					System.out.println();
					System.out.println("OK (" + testsRun + " test" + (testsRun == 1 ? "" : "s") + ")");
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Error: Could not find or load main class " + args[0]);
			}
		}
	}
}