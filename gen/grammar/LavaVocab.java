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
		XOR=17, RUPTURE=18, ERUPT=19, RETURN=20, SHARED=21, NOT=22, WITH=23, SIZE=24, 
		STATIC_STRING=25, VARID=26, ID=27, NUM=28, CHARACTER=29, LBLOCK=30, RBLOCK=31, 
		DOLLAR=32, ASS=33, COMMA=34, DOT=35, EQ=36, GE=37, GT=38, LE=39, LBRACE=40, 
		LPAR=41, LT=42, MINUS=43, PLUS=44, RBRACE=45, RPAR=46, SEMI=47, SLASH=48, 
		STAR=49, WS=50, COMMENT=51;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INTEGER", "BOOLEAN", "DOUBLE", "CHAR", "LONG", "STRING", "VOID", "IF", 
		"THEN", "ELSE", "CHAMBER", "WHILE", "TRUE", "FALSE", "AND", "OR", "XOR", 
		"RUPTURE", "ERUPT", "RETURN", "SHARED", "NOT", "WITH", "SIZE", "STATIC_STRING", 
		"VARID", "ID", "NUM", "CHARACTER", "LBLOCK", "RBLOCK", "DOLLAR", "ASS", 
		"COMMA", "DOT", "EQ", "GE", "GT", "LE", "LBRACE", "LPAR", "LT", "MINUS", 
		"PLUS", "RBRACE", "RPAR", "SEMI", "SLASH", "STAR", "WS", "COMMENT", "LETTER", 
		"DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'rock'", "'temperature'", "'pebble'", "'mineral'", "'brock'", "'mine'", 
		"'void'", "'if'", "'then'", "'else'", "'chamber'", "'while'", "'hot'", 
		"'cold'", "'and'", "'or'", "'xor'", "'rupture'", "'erupt'", "'return'", 
		"'shared'", "'not'", "'with'", "'size'", null, null, null, null, null, 
		"'['", "']'", "'$'", "'='", "','", "'.'", "'=='", "'>='", "'>'", "'<='", 
		"'{'", "'('", "'<'", "'-'", "'+'", "'}'", "')'", "';'", "'/'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INTEGER", "BOOLEAN", "DOUBLE", "CHAR", "LONG", "STRING", "VOID", 
		"IF", "THEN", "ELSE", "CHAMBER", "WHILE", "TRUE", "FALSE", "AND", "OR", 
		"XOR", "RUPTURE", "ERUPT", "RETURN", "SHARED", "NOT", "WITH", "SIZE", 
		"STATIC_STRING", "VARID", "ID", "NUM", "CHARACTER", "LBLOCK", "RBLOCK", 
		"DOLLAR", "ASS", "COMMA", "DOT", "EQ", "GE", "GT", "LE", "LBRACE", "LPAR", 
		"LT", "MINUS", "PLUS", "RBRACE", "RPAR", "SEMI", "SLASH", "STAR", "WS", 
		"COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\65\u0159\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u00fb\n\32\f\32\16\32\u00fe\13"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\7\34\u0108\n\34\f\34\16\34"+
		"\u010b\13\34\3\35\6\35\u010e\n\35\r\35\16\35\u010f\3\36\3\36\5\36\u0114"+
		"\n\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&"+
		"\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60"+
		"\3\60\3\61\3\61\3\62\3\62\3\63\6\63\u0144\n\63\r\63\16\63\u0145\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\7\64\u014f\n\64\f\64\16\64\u0152\13\64\3"+
		"\64\3\64\3\65\3\65\3\66\3\66\2\2\67\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\2k\2\3\2\7\4\2$$^^\5\2\13\f\17\17\"\"\4\2\f"+
		"\f\17\17\4\2C\\c|\3\2\62;\u015e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\3m\3\2\2\2\5r\3\2\2\2\7~\3\2\2\2\t\u0085\3\2\2\2\13\u008d\3\2\2\2\r\u0093"+
		"\3\2\2\2\17\u0098\3\2\2\2\21\u009d\3\2\2\2\23\u00a0\3\2\2\2\25\u00a5\3"+
		"\2\2\2\27\u00aa\3\2\2\2\31\u00b2\3\2\2\2\33\u00b8\3\2\2\2\35\u00bc\3\2"+
		"\2\2\37\u00c1\3\2\2\2!\u00c5\3\2\2\2#\u00c8\3\2\2\2%\u00cc\3\2\2\2\'\u00d4"+
		"\3\2\2\2)\u00da\3\2\2\2+\u00e1\3\2\2\2-\u00e8\3\2\2\2/\u00ec\3\2\2\2\61"+
		"\u00f1\3\2\2\2\63\u00f6\3\2\2\2\65\u0101\3\2\2\2\67\u0104\3\2\2\29\u010d"+
		"\3\2\2\2;\u0111\3\2\2\2=\u0117\3\2\2\2?\u0119\3\2\2\2A\u011b\3\2\2\2C"+
		"\u011d\3\2\2\2E\u011f\3\2\2\2G\u0121\3\2\2\2I\u0123\3\2\2\2K\u0126\3\2"+
		"\2\2M\u0129\3\2\2\2O\u012b\3\2\2\2Q\u012e\3\2\2\2S\u0130\3\2\2\2U\u0132"+
		"\3\2\2\2W\u0134\3\2\2\2Y\u0136\3\2\2\2[\u0138\3\2\2\2]\u013a\3\2\2\2_"+
		"\u013c\3\2\2\2a\u013e\3\2\2\2c\u0140\3\2\2\2e\u0143\3\2\2\2g\u0149\3\2"+
		"\2\2i\u0155\3\2\2\2k\u0157\3\2\2\2mn\7t\2\2no\7q\2\2op\7e\2\2pq\7m\2\2"+
		"q\4\3\2\2\2rs\7v\2\2st\7g\2\2tu\7o\2\2uv\7r\2\2vw\7g\2\2wx\7t\2\2xy\7"+
		"c\2\2yz\7v\2\2z{\7w\2\2{|\7t\2\2|}\7g\2\2}\6\3\2\2\2~\177\7r\2\2\177\u0080"+
		"\7g\2\2\u0080\u0081\7d\2\2\u0081\u0082\7d\2\2\u0082\u0083\7n\2\2\u0083"+
		"\u0084\7g\2\2\u0084\b\3\2\2\2\u0085\u0086\7o\2\2\u0086\u0087\7k\2\2\u0087"+
		"\u0088\7p\2\2\u0088\u0089\7g\2\2\u0089\u008a\7t\2\2\u008a\u008b\7c\2\2"+
		"\u008b\u008c\7n\2\2\u008c\n\3\2\2\2\u008d\u008e\7d\2\2\u008e\u008f\7t"+
		"\2\2\u008f\u0090\7q\2\2\u0090\u0091\7e\2\2\u0091\u0092\7m\2\2\u0092\f"+
		"\3\2\2\2\u0093\u0094\7o\2\2\u0094\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096"+
		"\u0097\7g\2\2\u0097\16\3\2\2\2\u0098\u0099\7x\2\2\u0099\u009a\7q\2\2\u009a"+
		"\u009b\7k\2\2\u009b\u009c\7f\2\2\u009c\20\3\2\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7h\2\2\u009f\22\3\2\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7j\2\2\u00a2"+
		"\u00a3\7g\2\2\u00a3\u00a4\7p\2\2\u00a4\24\3\2\2\2\u00a5\u00a6\7g\2\2\u00a6"+
		"\u00a7\7n\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7g\2\2\u00a9\26\3\2\2\2\u00aa"+
		"\u00ab\7e\2\2\u00ab\u00ac\7j\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7o\2\2"+
		"\u00ae\u00af\7d\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7t\2\2\u00b1\30\3\2"+
		"\2\2\u00b2\u00b3\7y\2\2\u00b3\u00b4\7j\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6"+
		"\7n\2\2\u00b6\u00b7\7g\2\2\u00b7\32\3\2\2\2\u00b8\u00b9\7j\2\2\u00b9\u00ba"+
		"\7q\2\2\u00ba\u00bb\7v\2\2\u00bb\34\3\2\2\2\u00bc\u00bd\7e\2\2\u00bd\u00be"+
		"\7q\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7f\2\2\u00c0\36\3\2\2\2\u00c1\u00c2"+
		"\7c\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7f\2\2\u00c4 \3\2\2\2\u00c5\u00c6"+
		"\7q\2\2\u00c6\u00c7\7t\2\2\u00c7\"\3\2\2\2\u00c8\u00c9\7z\2\2\u00c9\u00ca"+
		"\7q\2\2\u00ca\u00cb\7t\2\2\u00cb$\3\2\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce"+
		"\7w\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7w\2\2\u00d1"+
		"\u00d2\7t\2\2\u00d2\u00d3\7g\2\2\u00d3&\3\2\2\2\u00d4\u00d5\7g\2\2\u00d5"+
		"\u00d6\7t\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\7r\2\2\u00d8\u00d9\7v\2\2"+
		"\u00d9(\3\2\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7v\2"+
		"\2\u00dd\u00de\7w\2\2\u00de\u00df\7t\2\2\u00df\u00e0\7p\2\2\u00e0*\3\2"+
		"\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7j\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5"+
		"\7t\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7f\2\2\u00e7,\3\2\2\2\u00e8\u00e9"+
		"\7p\2\2\u00e9\u00ea\7q\2\2\u00ea\u00eb\7v\2\2\u00eb.\3\2\2\2\u00ec\u00ed"+
		"\7y\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7j\2\2\u00f0"+
		"\60\3\2\2\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7|\2\2\u00f4"+
		"\u00f5\7g\2\2\u00f5\62\3\2\2\2\u00f6\u00fc\7$\2\2\u00f7\u00fb\n\2\2\2"+
		"\u00f8\u00f9\7^\2\2\u00f9\u00fb\13\2\2\2\u00fa\u00f7\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\7$\2\2\u0100\64\3\2\2\2"+
		"\u0101\u0102\5A!\2\u0102\u0103\5\67\34\2\u0103\66\3\2\2\2\u0104\u0109"+
		"\5i\65\2\u0105\u0108\5i\65\2\u0106\u0108\5k\66\2\u0107\u0105\3\2\2\2\u0107"+
		"\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a8\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u010e\5k\66\2\u010d\u010c"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		":\3\2\2\2\u0111\u0113\7)\2\2\u0112\u0114\13\2\2\2\u0113\u0112\3\2\2\2"+
		"\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\7)\2\2\u0116<\3\2"+
		"\2\2\u0117\u0118\7]\2\2\u0118>\3\2\2\2\u0119\u011a\7_\2\2\u011a@\3\2\2"+
		"\2\u011b\u011c\7&\2\2\u011cB\3\2\2\2\u011d\u011e\7?\2\2\u011eD\3\2\2\2"+
		"\u011f\u0120\7.\2\2\u0120F\3\2\2\2\u0121\u0122\7\60\2\2\u0122H\3\2\2\2"+
		"\u0123\u0124\7?\2\2\u0124\u0125\7?\2\2\u0125J\3\2\2\2\u0126\u0127\7@\2"+
		"\2\u0127\u0128\7?\2\2\u0128L\3\2\2\2\u0129\u012a\7@\2\2\u012aN\3\2\2\2"+
		"\u012b\u012c\7>\2\2\u012c\u012d\7?\2\2\u012dP\3\2\2\2\u012e\u012f\7}\2"+
		"\2\u012fR\3\2\2\2\u0130\u0131\7*\2\2\u0131T\3\2\2\2\u0132\u0133\7>\2\2"+
		"\u0133V\3\2\2\2\u0134\u0135\7/\2\2\u0135X\3\2\2\2\u0136\u0137\7-\2\2\u0137"+
		"Z\3\2\2\2\u0138\u0139\7\177\2\2\u0139\\\3\2\2\2\u013a\u013b\7+\2\2\u013b"+
		"^\3\2\2\2\u013c\u013d\7=\2\2\u013d`\3\2\2\2\u013e\u013f\7\61\2\2\u013f"+
		"b\3\2\2\2\u0140\u0141\7,\2\2\u0141d\3\2\2\2\u0142\u0144\t\3\2\2\u0143"+
		"\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u0148\b\63\2\2\u0148f\3\2\2\2\u0149\u014a"+
		"\7\61\2\2\u014a\u014b\7`\2\2\u014b\u014c\7^\2\2\u014c\u0150\3\2\2\2\u014d"+
		"\u014f\n\4\2\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2"+
		"\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2\2\2\u0153"+
		"\u0154\b\64\2\2\u0154h\3\2\2\2\u0155\u0156\t\5\2\2\u0156j\3\2\2\2\u0157"+
		"\u0158\t\6\2\2\u0158l\3\2\2\2\13\2\u00fa\u00fc\u0107\u0109\u010f\u0113"+
		"\u0145\u0150\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}