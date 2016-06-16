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

    }

    @Test
    public void exprTest() {
        tester.yields("$y = $y + $count;", LavaVocab.VARID, LavaVocab.ASS, LavaVocab.VARID, LavaVocab.PLUS, LavaVocab.VARID, LavaVocab.SEMI);
        tester.yields("not not not hot", LavaVocab.NOT, LavaVocab.NOT, LavaVocab.NOT, LavaVocab.TRUE);
        tester.yields("hot and cold == cold ", LavaVocab.TRUE, LavaVocab.AND, LavaVocab.FALSE, LavaVocab.EQ, LavaVocab.FALSE);
        tester.yields("$a = (3.3* 5.5);", LavaVocab.VARID, LavaVocab.ASS, LavaVocab.LPAR, LavaVocab.NUM, LavaVocab.DOT, LavaVocab.NUM, LavaVocab.STAR,
                LavaVocab.NUM, LavaVocab.DOT, LavaVocab.NUM, LavaVocab.RPAR, LavaVocab.SEMI);
        tester.yields("3 + 5", LavaVocab.NUM, LavaVocab.PLUS, LavaVocab.NUM);
        tester.yields("0 - 1", LavaVocab.NUM, LavaVocab.MINUS, LavaVocab.NUM);
        tester.yields("(hot or cold) and hot", LavaVocab.LPAR, LavaVocab.TRUE, LavaVocab.OR, LavaVocab.FALSE, LavaVocab.RPAR, LavaVocab.AND, LavaVocab.TRUE);
    }

    @Test
    public void otherKeywordsTest() {
        tester.yields("chamber chambername { erupt(){ dosomething(); } }", LavaVocab.CHAMBER, LavaVocab.ID, LavaVocab.LBRACE, LavaVocab.ERUPT,
                LavaVocab.LPAR, LavaVocab.RPAR, LavaVocab.LBRACE, LavaVocab.ID, LavaVocab.LPAR, LavaVocab.RPAR, LavaVocab.SEMI,
                LavaVocab.RBRACE, LavaVocab.RBRACE);
        tester.yields(" rupture       rock     max (               rock[        ] $a){", LavaVocab.RUPTURE, LavaVocab.INTEGER,
                LavaVocab.ID, LavaVocab.LPAR, LavaVocab.INTEGER,
                LavaVocab.LBLOCK, LavaVocab.RBLOCK, LavaVocab.VARID, LavaVocab.RPAR, LavaVocab.LBRACE);
    }

    @Test
    public void rejectsTest() {
        tester.allWrong("!@#€|&%~:'");
    }
}
