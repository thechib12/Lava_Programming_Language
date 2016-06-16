package grammar;

import org.junit.Test;

/**
 * Created by Christiaan on 15-06-16.
 */
public class LavaVocabLexerTester {
    private static LexerTester tester = new LexerTester(LavaVocab.class);

    @Test
    public void TypesTest() {
        tester.correct("rock rock rock temperature pebble");

        tester.correct("pebble mineral brock mineral mine");
        tester.yields("rock temperature mineral brock mine void pebble", LavaVocab.INTEGER, LavaVocab.BOOLEAN,
                LavaVocab.CHAR, LavaVocab.LONG, LavaVocab.STRING, LavaVocab.VOID, LavaVocab.DOUBLE);
        tester.yields("rock[] temperature[] mineral[] brock[] mine[] pebble[]", LavaVocab.INTEGER, LavaVocab.LBLOCK, LavaVocab.RBLOCK,
                LavaVocab.BOOLEAN, LavaVocab.LBLOCK, LavaVocab.RBLOCK,
                LavaVocab.CHAR, LavaVocab.LBLOCK, LavaVocab.RBLOCK, LavaVocab.LONG, LavaVocab.LBLOCK, LavaVocab.RBLOCK,
                LavaVocab.STRING, LavaVocab.LBLOCK, LavaVocab.RBLOCK, LavaVocab.DOUBLE, LavaVocab.LBLOCK, LavaVocab.RBLOCK);
    }


    @Test
    public void statementTest() {
        tester.yields("rock $count = 0;", LavaVocab.INTEGER, LavaVocab.VARID, LavaVocab.ASS, LavaVocab.NUM, LavaVocab.SEMI);
        tester.yields(" while ($count < $x1)", LavaVocab.WHILE, LavaVocab.LPAR, LavaVocab.VARID, LavaVocab.LT, LavaVocab.VARID, LavaVocab.RPAR);
        tester.yields(" if    (    $a[$counter]   >=            $maximum  ) then       ", LavaVocab.IF, LavaVocab.LPAR,
                LavaVocab.VARID, LavaVocab.LBLOCK, LavaVocab.VARID, LavaVocab.RBLOCK,
                LavaVocab.GE, LavaVocab.VARID, LavaVocab.RPAR, LavaVocab.THEN);
        tester.yields("/^\\ hey tokenizer ignore this pls \n  return $maximum;", LavaVocab.RETURN, LavaVocab.VARID, LavaVocab.SEMI);
        tester.yields();
    }

    @Test
    public void exprTest() {
        tester.yields("$y = $y + $count;", LavaVocab.VARID, LavaVocab.ASS, LavaVocab.VARID, LavaVocab.PLUS, LavaVocab.VARID, LavaVocab.SEMI);
    }
//
//    @Test
//    public void noSpacesBetweenKeywordsTest() {
//        // the following is perfectly fine, so claiming it's wrong will fail
//        tester.yields("whilewhiledodo", Example.WHILE, Example.WHILE,
//                Example.DO, Example.DO);
//    }
}
