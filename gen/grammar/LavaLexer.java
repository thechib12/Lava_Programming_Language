// Generated from D:/UTwente/Module 8/Lava Programming Language/src/main/java/grammar\Lava.g4 by ANTLR 4.5.1
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=1, BOOLEAN=2, DOUBLE=3, CHAR=4, LONG=5, STRING=6, VOID=7, IF=8, 
		THEN=9, ELSE=10, CHAMBER=11, WHILE=12, TRUE=13, FALSE=14, AND=15, OR=16, 
		XOR=17, RUPTURE=18, ERUPT=19, RETURN=20, SHARED=21, STATIC_STRING=22, 
		VARID=23, ID=24, NUM=25, LBLOCK=26, RBLOCK=27, DOLLAR=28, ASS=29, COMMA=30, 
		DOT=31, EQ=32, GE=33, GT=34, LE=35, LBRACE=36, LPAR=37, LT=38, MINUS=39, 
		NOT=40, PLUS=41, RBRACE=42, RPAR=43, SEMI=44, SLASH=45, STAR=46, WS=47, 
		COMMENT=48;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INTEGER", "BOOLEAN", "DOUBLE", "CHAR", "LONG", "STRING", "VOID", "IF", 
		"THEN", "ELSE", "CHAMBER", "WHILE", "TRUE", "FALSE", "AND", "OR", "XOR", 
		"RUPTURE", "ERUPT", "RETURN", "SHARED", "STATIC_STRING", "VARID", "ID", 
		"NUM", "LBLOCK", "RBLOCK", "DOLLAR", "ASS", "COMMA", "DOT", "EQ", "GE", 
		"GT", "LE", "LBRACE", "LPAR", "LT", "MINUS", "NOT", "PLUS", "RBRACE", 
		"RPAR", "SEMI", "SLASH", "STAR", "WS", "COMMENT", "LETTER", "DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'rock'", "'temperature'", "'pebble'", "'mineral'", "'brock'", "'mine'", 
		"'void'", "'if'", "'then'", "'else'", "'chamber'", "'while'", "'hot'", 
		"'cold'", "'and'", "'or'", "'xor'", "'rupture'", "'erupt'", "'return'", 
		"'shared'", null, null, null, null, "'['", "']'", "'$'", "'='", "','", 
		"'.'", "'=='", "'>='", "'>'", "'<='", "'{'", "'('", "'<'", "'-'", "'not'", 
		"'+'", "'}'", "')'", "';'", "'/'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INTEGER", "BOOLEAN", "DOUBLE", "CHAR", "LONG", "STRING", "VOID", 
		"IF", "THEN", "ELSE", "CHAMBER", "WHILE", "TRUE", "FALSE", "AND", "OR", 
		"XOR", "RUPTURE", "ERUPT", "RETURN", "SHARED", "STATIC_STRING", "VARID", 
		"ID", "NUM", "LBLOCK", "RBLOCK", "DOLLAR", "ASS", "COMMA", "DOT", "EQ", 
		"GE", "GT", "LE", "LBRACE", "LPAR", "LT", "MINUS", "NOT", "PLUS", "RBRACE", 
		"RPAR", "SEMI", "SLASH", "STAR", "WS", "COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\62\u0143\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\7\27\u00e7\n\27\f\27\16\27\u00ea\13\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\7\31\u00f4\n\31\f\31\16\31\u00f7\13\31\3\32\6\32\u00fa\n"+
		"\32\r\32\16\32\u00fb\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3"+
		")\3)\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\6\60\u012e\n\60\r"+
		"\60\16\60\u012f\3\60\3\60\3\61\3\61\3\61\3\61\3\61\7\61\u0139\n\61\f\61"+
		"\16\61\u013c\13\61\3\61\3\61\3\62\3\62\3\63\3\63\2\2\64\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\2e\2\3\2\7\4\2$$^^\5\2\13\f\17\17"+
		"\"\"\4\2\f\f\17\17\4\2C\\c|\3\2\62;\u0147\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3g\3\2\2\2\5l\3\2\2\2"+
		"\7x\3\2\2\2\t\177\3\2\2\2\13\u0087\3\2\2\2\r\u008d\3\2\2\2\17\u0092\3"+
		"\2\2\2\21\u0097\3\2\2\2\23\u009a\3\2\2\2\25\u009f\3\2\2\2\27\u00a4\3\2"+
		"\2\2\31\u00ac\3\2\2\2\33\u00b2\3\2\2\2\35\u00b6\3\2\2\2\37\u00bb\3\2\2"+
		"\2!\u00bf\3\2\2\2#\u00c2\3\2\2\2%\u00c6\3\2\2\2\'\u00ce\3\2\2\2)\u00d4"+
		"\3\2\2\2+\u00db\3\2\2\2-\u00e2\3\2\2\2/\u00ed\3\2\2\2\61\u00f0\3\2\2\2"+
		"\63\u00f9\3\2\2\2\65\u00fd\3\2\2\2\67\u00ff\3\2\2\29\u0101\3\2\2\2;\u0103"+
		"\3\2\2\2=\u0105\3\2\2\2?\u0107\3\2\2\2A\u0109\3\2\2\2C\u010c\3\2\2\2E"+
		"\u010f\3\2\2\2G\u0111\3\2\2\2I\u0114\3\2\2\2K\u0116\3\2\2\2M\u0118\3\2"+
		"\2\2O\u011a\3\2\2\2Q\u011c\3\2\2\2S\u0120\3\2\2\2U\u0122\3\2\2\2W\u0124"+
		"\3\2\2\2Y\u0126\3\2\2\2[\u0128\3\2\2\2]\u012a\3\2\2\2_\u012d\3\2\2\2a"+
		"\u0133\3\2\2\2c\u013f\3\2\2\2e\u0141\3\2\2\2gh\7t\2\2hi\7q\2\2ij\7e\2"+
		"\2jk\7m\2\2k\4\3\2\2\2lm\7v\2\2mn\7g\2\2no\7o\2\2op\7r\2\2pq\7g\2\2qr"+
		"\7t\2\2rs\7c\2\2st\7v\2\2tu\7w\2\2uv\7t\2\2vw\7g\2\2w\6\3\2\2\2xy\7r\2"+
		"\2yz\7g\2\2z{\7d\2\2{|\7d\2\2|}\7n\2\2}~\7g\2\2~\b\3\2\2\2\177\u0080\7"+
		"o\2\2\u0080\u0081\7k\2\2\u0081\u0082\7p\2\2\u0082\u0083\7g\2\2\u0083\u0084"+
		"\7t\2\2\u0084\u0085\7c\2\2\u0085\u0086\7n\2\2\u0086\n\3\2\2\2\u0087\u0088"+
		"\7d\2\2\u0088\u0089\7t\2\2\u0089\u008a\7q\2\2\u008a\u008b\7e\2\2\u008b"+
		"\u008c\7m\2\2\u008c\f\3\2\2\2\u008d\u008e\7o\2\2\u008e\u008f\7k\2\2\u008f"+
		"\u0090\7p\2\2\u0090\u0091\7g\2\2\u0091\16\3\2\2\2\u0092\u0093\7x\2\2\u0093"+
		"\u0094\7q\2\2\u0094\u0095\7k\2\2\u0095\u0096\7f\2\2\u0096\20\3\2\2\2\u0097"+
		"\u0098\7k\2\2\u0098\u0099\7h\2\2\u0099\22\3\2\2\2\u009a\u009b\7v\2\2\u009b"+
		"\u009c\7j\2\2\u009c\u009d\7g\2\2\u009d\u009e\7p\2\2\u009e\24\3\2\2\2\u009f"+
		"\u00a0\7g\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7u\2\2\u00a2\u00a3\7g\2\2"+
		"\u00a3\26\3\2\2\2\u00a4\u00a5\7e\2\2\u00a5\u00a6\7j\2\2\u00a6\u00a7\7"+
		"c\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7d\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab"+
		"\7t\2\2\u00ab\30\3\2\2\2\u00ac\u00ad\7y\2\2\u00ad\u00ae\7j\2\2\u00ae\u00af"+
		"\7k\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7g\2\2\u00b1\32\3\2\2\2\u00b2\u00b3"+
		"\7j\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7v\2\2\u00b5\34\3\2\2\2\u00b6\u00b7"+
		"\7e\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7f\2\2\u00ba"+
		"\36\3\2\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7f\2\2\u00be"+
		" \3\2\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7t\2\2\u00c1\"\3\2\2\2\u00c2"+
		"\u00c3\7z\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7t\2\2\u00c5$\3\2\2\2\u00c6"+
		"\u00c7\7t\2\2\u00c7\u00c8\7w\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7v\2\2"+
		"\u00ca\u00cb\7w\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7g\2\2\u00cd&\3\2\2"+
		"\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7w\2\2\u00d1\u00d2"+
		"\7r\2\2\u00d2\u00d3\7v\2\2\u00d3(\3\2\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6"+
		"\7g\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7t\2\2\u00d9"+
		"\u00da\7p\2\2\u00da*\3\2\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7j\2\2\u00dd"+
		"\u00de\7c\2\2\u00de\u00df\7t\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7f\2\2"+
		"\u00e1,\3\2\2\2\u00e2\u00e8\7$\2\2\u00e3\u00e7\n\2\2\2\u00e4\u00e5\7^"+
		"\2\2\u00e5\u00e7\13\2\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7"+
		"\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2"+
		"\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7$\2\2\u00ec.\3\2\2\2\u00ed\u00ee"+
		"\59\35\2\u00ee\u00ef\5\61\31\2\u00ef\60\3\2\2\2\u00f0\u00f5\5c\62\2\u00f1"+
		"\u00f4\5c\62\2\u00f2\u00f4\5e\63\2\u00f3\u00f1\3\2\2\2\u00f3\u00f2\3\2"+
		"\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\62\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fa\5e\63\2\u00f9\u00f8\3\2\2"+
		"\2\u00fa\u00fb\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\64"+
		"\3\2\2\2\u00fd\u00fe\7]\2\2\u00fe\66\3\2\2\2\u00ff\u0100\7_\2\2\u0100"+
		"8\3\2\2\2\u0101\u0102\7&\2\2\u0102:\3\2\2\2\u0103\u0104\7?\2\2\u0104<"+
		"\3\2\2\2\u0105\u0106\7.\2\2\u0106>\3\2\2\2\u0107\u0108\7\60\2\2\u0108"+
		"@\3\2\2\2\u0109\u010a\7?\2\2\u010a\u010b\7?\2\2\u010bB\3\2\2\2\u010c\u010d"+
		"\7@\2\2\u010d\u010e\7?\2\2\u010eD\3\2\2\2\u010f\u0110\7@\2\2\u0110F\3"+
		"\2\2\2\u0111\u0112\7>\2\2\u0112\u0113\7?\2\2\u0113H\3\2\2\2\u0114\u0115"+
		"\7}\2\2\u0115J\3\2\2\2\u0116\u0117\7*\2\2\u0117L\3\2\2\2\u0118\u0119\7"+
		">\2\2\u0119N\3\2\2\2\u011a\u011b\7/\2\2\u011bP\3\2\2\2\u011c\u011d\7p"+
		"\2\2\u011d\u011e\7q\2\2\u011e\u011f\7v\2\2\u011fR\3\2\2\2\u0120\u0121"+
		"\7-\2\2\u0121T\3\2\2\2\u0122\u0123\7\177\2\2\u0123V\3\2\2\2\u0124\u0125"+
		"\7+\2\2\u0125X\3\2\2\2\u0126\u0127\7=\2\2\u0127Z\3\2\2\2\u0128\u0129\7"+
		"\61\2\2\u0129\\\3\2\2\2\u012a\u012b\7,\2\2\u012b^\3\2\2\2\u012c\u012e"+
		"\t\3\2\2\u012d\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\b\60\2\2\u0132`\3\2\2\2"+
		"\u0133\u0134\7\61\2\2\u0134\u0135\7`\2\2\u0135\u0136\7^\2\2\u0136\u013a"+
		"\3\2\2\2\u0137\u0139\n\4\2\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013d\u013e\b\61\2\2\u013eb\3\2\2\2\u013f\u0140\t\5\2\2\u0140d\3"+
		"\2\2\2\u0141\u0142\t\6\2\2\u0142f\3\2\2\2\n\2\u00e6\u00e8\u00f3\u00f5"+
		"\u00fb\u012f\u013a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}