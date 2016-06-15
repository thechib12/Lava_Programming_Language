//package grammar;
//
//import org.junit.Test;
//
///**
// * Created by Christiaan on 15-06-16.
// */
//public class LavaVocabLexerTester {
//    private static LexerTester tester = new LexerTester(LavaVocab.class);
//
//    @Test
//    public void succeedingTest() {
//        tester.correct("while do");
//
//        tester.correct("while while do");
//        tester.yields("while while do", Example.WHILE, Example.WHILE,
//                Example.DO);
//        tester.wrong("whiledo done");
//    }
//
//    @Test
//    public void spacesInKeywordTest() {
//        // spaces in keywords are not in the rules
//        tester.wrong("whi le do");
//    }
//
//    @Test
//    public void yieldCountTest() {
//        tester.yields("do dodo", Example.DO, Example.DO, Example.DO);
//    }
//
//    @Test
//    public void noSpacesBetweenKeywordsTest() {
//        // the following is perfectly fine, so claiming it's wrong will fail
//        tester.yields("whilewhiledodo", Example.WHILE, Example.WHILE,
//                Example.DO, Example.DO);
//    }
//}
