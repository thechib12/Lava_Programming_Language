// Generated from D:/UTwente/Module 8/Lava Programming Language/src/main/java/grammar\LavaVocab.g4 by ANTLR 4.5.1
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
public class LavaVocab extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=1, BOOLEAN=2, DOUBLE=3, CHAR=4, LONG=5, STRING=6, VOID=7, IF=8, 
		THEN=9, ELSE=10, CHAMBER=11, WHILE=12, TRUE=13, FALSE=14, AND=15, OR=16, 
		XOR=17, RUPTURE=18, ERUPT=19, RETURN=20, STATIC_STRING=21, VARID=22, ID=23, 
		NUM=24, LBLOCK=25, RBLOCK=26, DOLLAR=27, ASS=28, COMMA=29, DOT=30, EQ=31, 
		GE=32, GT=33, LE=34, LBRACE=35, LPAR=36, LT=37, MINUS=38, NOT=39, PLUS=40, 
		RBRACE=41, RPAR=42, SEMI=43, SLASH=44, STAR=45, WS=46, COMMENT=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INTEGER", "BOOLEAN", "DOUBLE", "CHAR", "LONG", "STRING", "VOID", "IF", 
		"THEN", "ELSE", "CHAMBER", "WHILE", "TRUE", "FALSE", "AND", "OR", "XOR", 
		"RUPTURE", "ERUPT", "RETURN", "STATIC_STRING", "VARID", "ID", "NUM", "LBLOCK", 
		"RBLOCK", "DOLLAR", "ASS", "COMMA", "DOT", "EQ", "GE", "GT", "LE", "LBRACE", 
		"LPAR", "LT", "MINUS", "NOT", "PLUS", "RBRACE", "RPAR", "SEMI", "SLASH", 
		"STAR", "WS", "COMMENT", "LETTER", "DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'rock'", "'temperature'", "'pebble'", "'mineral'", "'brock'", "'mine'", 
		"'void'", "'if'", "'then'", "'else'", "'chamber'", "'while'", "'hot'", 
		"'cold'", "'and'", "'or'", "'xor'", "'rupture'", "'erupt'", "'return'", 
		null, null, null, null, "'['", "']'", "'$'", "'='", "','", "'.'", "'=='", 
		"'>='", "'>'", "'<='", "'{'", "'('", "'<'", "'-'", "'!'", "'+'", "'}'", 
		"')'", "';'", "'/'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INTEGER", "BOOLEAN", "DOUBLE", "CHAR", "LONG", "STRING", "VOID", 
		"IF", "THEN", "ELSE", "CHAMBER", "WHILE", "TRUE", "FALSE", "AND", "OR", 
		"XOR", "RUPTURE", "ERUPT", "RETURN", "STATIC_STRING", "VARID", "ID", "NUM", 
		"LBLOCK", "RBLOCK", "DOLLAR", "ASS", "COMMA", "DOT", "EQ", "GE", "GT", 
		"LE", "LBRACE", "LPAR", "LT", "MINUS", "NOT", "PLUS", "RBRACE", "RPAR", 
		"SEMI", "SLASH", "STAR", "WS", "COMMENT"
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


	public LavaVocab(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LavaVocab.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u0138\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\7\26\u00de\n\26\f\26\16\26\u00e1\13\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\7\30\u00eb\n\30\f\30\16\30\u00ee"+
		"\13\30\3\31\6\31\u00f1\n\31\r\31\16\31\u00f2\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3."+
		"\3/\6/\u0123\n/\r/\16/\u0124\3/\3/\3\60\3\60\3\60\3\60\3\60\7\60\u012e"+
		"\n\60\f\60\16\60\u0131\13\60\3\60\3\60\3\61\3\61\3\62\3\62\2\2\63\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\2c\2\3\2\7\4\2$$^^\5\2\13\f\17"+
		"\17\"\"\4\2\f\f\17\17\4\2C\\c|\3\2\62;\u013c\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3e\3\2\2\2\5j\3\2\2\2\7v\3\2\2"+
		"\2\t}\3\2\2\2\13\u0085\3\2\2\2\r\u008b\3\2\2\2\17\u0090\3\2\2\2\21\u0095"+
		"\3\2\2\2\23\u0098\3\2\2\2\25\u009d\3\2\2\2\27\u00a2\3\2\2\2\31\u00aa\3"+
		"\2\2\2\33\u00b0\3\2\2\2\35\u00b4\3\2\2\2\37\u00b9\3\2\2\2!\u00bd\3\2\2"+
		"\2#\u00c0\3\2\2\2%\u00c4\3\2\2\2\'\u00cc\3\2\2\2)\u00d2\3\2\2\2+\u00d9"+
		"\3\2\2\2-\u00e4\3\2\2\2/\u00e7\3\2\2\2\61\u00f0\3\2\2\2\63\u00f4\3\2\2"+
		"\2\65\u00f6\3\2\2\2\67\u00f8\3\2\2\29\u00fa\3\2\2\2;\u00fc\3\2\2\2=\u00fe"+
		"\3\2\2\2?\u0100\3\2\2\2A\u0103\3\2\2\2C\u0106\3\2\2\2E\u0108\3\2\2\2G"+
		"\u010b\3\2\2\2I\u010d\3\2\2\2K\u010f\3\2\2\2M\u0111\3\2\2\2O\u0113\3\2"+
		"\2\2Q\u0115\3\2\2\2S\u0117\3\2\2\2U\u0119\3\2\2\2W\u011b\3\2\2\2Y\u011d"+
		"\3\2\2\2[\u011f\3\2\2\2]\u0122\3\2\2\2_\u0128\3\2\2\2a\u0134\3\2\2\2c"+
		"\u0136\3\2\2\2ef\7t\2\2fg\7q\2\2gh\7e\2\2hi\7m\2\2i\4\3\2\2\2jk\7v\2\2"+
		"kl\7g\2\2lm\7o\2\2mn\7r\2\2no\7g\2\2op\7t\2\2pq\7c\2\2qr\7v\2\2rs\7w\2"+
		"\2st\7t\2\2tu\7g\2\2u\6\3\2\2\2vw\7r\2\2wx\7g\2\2xy\7d\2\2yz\7d\2\2z{"+
		"\7n\2\2{|\7g\2\2|\b\3\2\2\2}~\7o\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080"+
		"\u0081\7g\2\2\u0081\u0082\7t\2\2\u0082\u0083\7c\2\2\u0083\u0084\7n\2\2"+
		"\u0084\n\3\2\2\2\u0085\u0086\7d\2\2\u0086\u0087\7t\2\2\u0087\u0088\7q"+
		"\2\2\u0088\u0089\7e\2\2\u0089\u008a\7m\2\2\u008a\f\3\2\2\2\u008b\u008c"+
		"\7o\2\2\u008c\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7g\2\2\u008f"+
		"\16\3\2\2\2\u0090\u0091\7x\2\2\u0091\u0092\7q\2\2\u0092\u0093\7k\2\2\u0093"+
		"\u0094\7f\2\2\u0094\20\3\2\2\2\u0095\u0096\7k\2\2\u0096\u0097\7h\2\2\u0097"+
		"\22\3\2\2\2\u0098\u0099\7v\2\2\u0099\u009a\7j\2\2\u009a\u009b\7g\2\2\u009b"+
		"\u009c\7p\2\2\u009c\24\3\2\2\2\u009d\u009e\7g\2\2\u009e\u009f\7n\2\2\u009f"+
		"\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1\26\3\2\2\2\u00a2\u00a3\7e\2\2\u00a3"+
		"\u00a4\7j\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7o\2\2\u00a6\u00a7\7d\2\2"+
		"\u00a7\u00a8\7g\2\2\u00a8\u00a9\7t\2\2\u00a9\30\3\2\2\2\u00aa\u00ab\7"+
		"y\2\2\u00ab\u00ac\7j\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7n\2\2\u00ae\u00af"+
		"\7g\2\2\u00af\32\3\2\2\2\u00b0\u00b1\7j\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3"+
		"\7v\2\2\u00b3\34\3\2\2\2\u00b4\u00b5\7e\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7"+
		"\7n\2\2\u00b7\u00b8\7f\2\2\u00b8\36\3\2\2\2\u00b9\u00ba\7c\2\2\u00ba\u00bb"+
		"\7p\2\2\u00bb\u00bc\7f\2\2\u00bc \3\2\2\2\u00bd\u00be\7q\2\2\u00be\u00bf"+
		"\7t\2\2\u00bf\"\3\2\2\2\u00c0\u00c1\7z\2\2\u00c1\u00c2\7q\2\2\u00c2\u00c3"+
		"\7t\2\2\u00c3$\3\2\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7"+
		"\7r\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca\7t\2\2\u00ca"+
		"\u00cb\7g\2\2\u00cb&\3\2\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7t\2\2\u00ce"+
		"\u00cf\7w\2\2\u00cf\u00d0\7r\2\2\u00d0\u00d1\7v\2\2\u00d1(\3\2\2\2\u00d2"+
		"\u00d3\7t\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7w\2\2"+
		"\u00d6\u00d7\7t\2\2\u00d7\u00d8\7p\2\2\u00d8*\3\2\2\2\u00d9\u00df\7$\2"+
		"\2\u00da\u00de\n\2\2\2\u00db\u00dc\7^\2\2\u00dc\u00de\13\2\2\2\u00dd\u00da"+
		"\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7$"+
		"\2\2\u00e3,\3\2\2\2\u00e4\u00e5\5\67\34\2\u00e5\u00e6\5/\30\2\u00e6.\3"+
		"\2\2\2\u00e7\u00ec\5a\61\2\u00e8\u00eb\5a\61\2\u00e9\u00eb\5c\62\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\60\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f1"+
		"\5c\62\2\u00f0\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\62\3\2\2\2\u00f4\u00f5\7]\2\2\u00f5\64\3\2\2\2\u00f6"+
		"\u00f7\7_\2\2\u00f7\66\3\2\2\2\u00f8\u00f9\7&\2\2\u00f98\3\2\2\2\u00fa"+
		"\u00fb\7?\2\2\u00fb:\3\2\2\2\u00fc\u00fd\7.\2\2\u00fd<\3\2\2\2\u00fe\u00ff"+
		"\7\60\2\2\u00ff>\3\2\2\2\u0100\u0101\7?\2\2\u0101\u0102\7?\2\2\u0102@"+
		"\3\2\2\2\u0103\u0104\7@\2\2\u0104\u0105\7?\2\2\u0105B\3\2\2\2\u0106\u0107"+
		"\7@\2\2\u0107D\3\2\2\2\u0108\u0109\7>\2\2\u0109\u010a\7?\2\2\u010aF\3"+
		"\2\2\2\u010b\u010c\7}\2\2\u010cH\3\2\2\2\u010d\u010e\7*\2\2\u010eJ\3\2"+
		"\2\2\u010f\u0110\7>\2\2\u0110L\3\2\2\2\u0111\u0112\7/\2\2\u0112N\3\2\2"+
		"\2\u0113\u0114\7#\2\2\u0114P\3\2\2\2\u0115\u0116\7-\2\2\u0116R\3\2\2\2"+
		"\u0117\u0118\7\177\2\2\u0118T\3\2\2\2\u0119\u011a\7+\2\2\u011aV\3\2\2"+
		"\2\u011b\u011c\7=\2\2\u011cX\3\2\2\2\u011d\u011e\7\61\2\2\u011eZ\3\2\2"+
		"\2\u011f\u0120\7,\2\2\u0120\\\3\2\2\2\u0121\u0123\t\3\2\2\u0122\u0121"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0127\b/\2\2\u0127^\3\2\2\2\u0128\u0129\7\61\2\2"+
		"\u0129\u012a\7`\2\2\u012a\u012b\7^\2\2\u012b\u012f\3\2\2\2\u012c\u012e"+
		"\n\4\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\b\60"+
		"\2\2\u0133`\3\2\2\2\u0134\u0135\t\5\2\2\u0135b\3\2\2\2\u0136\u0137\t\6"+
		"\2\2\u0137d\3\2\2\2\n\2\u00dd\u00df\u00ea\u00ec\u00f2\u0124\u012f\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}