package org.angularjs.codeInsight.messageFormat;

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import org.angularjs.AngularTestUtil;
import org.jetbrains.annotations.NotNull;

/**
 * @author Irina.Chernushina on 12/3/2015.
 */
public class AngularMessageFormatAnnotatorTest extends LightPlatformCodeInsightFixtureTestCase {
  public static final String[] PLURAL = new String[]{"other", "one", "many", "few", "two", "zero", "=0", "=1", "=2", "=3"};

  @Override
  protected String getTestDataPath() {
    return AngularTestUtil.getBaseTestDataPath(AngularMessageFormatAnnotatorTest.class);
  }

  public void testCase1() throws Exception {
    doTest("case1.html");
  }

  public void testCase2() throws Exception {
    doTest("case2.html");
  }

  public void testCase3() throws Exception {
    doTest("case3.html");
  }

  public void testCase4() throws Exception {
    doTest("case4.html");
  }

  public void testCase5() throws Exception {
    doTest("case5.html");
  }

  public void testCompletion1() throws Exception {
    doCompletionTest("completion1.html", PLURAL);
  }

  public void testCompletion2() throws Exception {
    doCompletionTest("completion2.html", "one", "many");
  }

  public void testCompletion3() throws Exception {
    myFixture.testCompletionTyping("completion3_before.html", "3\n", "completion3_after.html", "controller.js", "angular.js");
  }

  public void testCompletion4() throws Exception {
    myFixture.testCompletionTyping("completion4_before.html", "3\n", "completion4_after.html", "controller.js", "angular.js");
  }

  private void doCompletionTest(final String fileName, final String... variants) {
    myFixture.configureByFiles(fileName, "controller.js", "angular.js");
    myFixture.completeBasic();
    myFixture.assertPreferredCompletionItems(0, variants);
  }

  public void doTest(@NotNull final String fileName) throws Exception {
    myFixture.configureByFiles(fileName, "controller.js", "angular.js");
    myFixture.checkHighlighting();
  }
}
