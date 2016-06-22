// Generated from /Users/Rogier/Library/Mobile Documents/com~apple~CloudDocs/Universiteit Twente/Programming Paradigms/Compiler Construction/Lava_Programming_Language/src/main/java/grammar/Lava.g4 by ANTLR 4.5.3
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

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
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_statement = 2, RULE_block = 3, RULE_blockStatements = 4, 
		RULE_blockStatement = 5, RULE_localVariableDeclarationStatement = 6, RULE_emptyStatement = 7, 
		RULE_localVariableDeclaration = 8, RULE_main = 9, RULE_functiondecl = 10, 
		RULE_function = 11, RULE_parametersdecl = 12, RULE_target = 13, RULE_arrayInit = 14, 
		RULE_parameters = 15, RULE_compOp = 16, RULE_boolOp = 17, RULE_multOp = 18, 
		RULE_plusOp = 19, RULE_negaOp = 20, RULE_expr = 21, RULE_type = 22, RULE_arrayType = 23, 
		RULE_shared = 24, RULE_primitiveType = 25;
	public static final String[] ruleNames = {
		"program", "body", "statement", "block", "blockStatements", "blockStatement", 
		"localVariableDeclarationStatement", "emptyStatement", "localVariableDeclaration", 
		"main", "functiondecl", "function", "parametersdecl", "target", "arrayInit", 
		"parameters", "compOp", "boolOp", "multOp", "plusOp", "negaOp", "expr", 
		"type", "arrayType", "shared", "primitiveType"
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

	@Override
	public String getGrammarFileName() { return "Lava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode CHAMBER() { return getToken(LavaParser.CHAMBER, 0); }
		public TerminalNode ID() { return getToken(LavaParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(LavaParser.LBRACE, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LavaParser.RBRACE, 0); }
		public TerminalNode EOF() { return getToken(LavaParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(CHAMBER);
			setState(53);
			match(ID);
			setState(54);
			match(LBRACE);
			setState(55);
			body();
			setState(56);
			match(RBRACE);
			setState(57);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public List<LocalVariableDeclarationStatementContext> localVariableDeclarationStatement() {
			return getRuleContexts(LocalVariableDeclarationStatementContext.class);
		}
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement(int i) {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,i);
		}
		public List<FunctiondeclContext> functiondecl() {
			return getRuleContexts(FunctiondeclContext.class);
		}
		public FunctiondeclContext functiondecl(int i) {
			return getRuleContext(FunctiondeclContext.class,i);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << BOOLEAN) | (1L << CHAR) | (1L << VOID))) != 0)) {
				{
				{
				setState(59);
				localVariableDeclarationStatement();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RUPTURE) {
				{
				{
				setState(65);
				functiondecl();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			_la = _input.LA(1);
			if (_la==ERUPT) {
				{
				setState(71);
				main();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatementContext {
		public List<TerminalNode> IF() { return getTokens(LavaParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(LavaParser.IF, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(LavaParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(LavaParser.LPAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RPAR() { return getTokens(LavaParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(LavaParser.RPAR, i);
		}
		public List<TerminalNode> THEN() { return getTokens(LavaParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(LavaParser.THEN, i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> ELSE() { return getTokens(LavaParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(LavaParser.ELSE, i);
		}
		public IfStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionStatContext extends StatementContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }
		public FunctionStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterFunctionStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitFunctionStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitFunctionStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(LavaParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }
		public ReturnStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignStatContext extends StatementContext {
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public TerminalNode ASS() { return getToken(LavaParser.ASS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }
		public AssignStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterAssignStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitAssignStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitAssignStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyStatContext extends StatementContext {
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public EmptyStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterEmptyStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitEmptyStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitEmptyStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(LavaParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(116);
			switch (_input.LA(1)) {
			case VARID:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				target();
				setState(75);
				match(ASS);
				setState(76);
				expr(0);
				setState(77);
				match(SEMI);
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(IF);
				setState(80);
				match(LPAR);
				setState(81);
				expr(0);
				setState(82);
				match(RPAR);
				setState(83);
				match(THEN);
				setState(84);
				block();
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(85);
						match(ELSE);
						setState(86);
						match(IF);
						setState(87);
						match(LPAR);
						setState(88);
						expr(0);
						setState(89);
						match(RPAR);
						setState(90);
						match(THEN);
						setState(91);
						block();
						}
						} 
					}
					setState(97);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(100);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(98);
					match(ELSE);
					setState(99);
					block();
					}
				}

				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(WHILE);
				setState(103);
				match(LPAR);
				setState(104);
				expr(0);
				setState(105);
				match(RPAR);
				setState(106);
				block();
				}
				break;
			case ID:
				_localctx = new FunctionStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				function();
				setState(109);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				match(RETURN);
				setState(112);
				expr(0);
				setState(113);
				match(SEMI);
				}
				break;
			case SEMI:
				_localctx = new EmptyStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(115);
				emptyStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LavaParser.LBRACE, 0); }
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LavaParser.RBRACE, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(LBRACE);
			setState(119);
			blockStatements();
			setState(120);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementsContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterBlockStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitBlockStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitBlockStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementsContext blockStatements() throws RecognitionException {
		BlockStatementsContext _localctx = new BlockStatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_blockStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			blockStatement();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << BOOLEAN) | (1L << CHAR) | (1L << VOID) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << VARID) | (1L << ID) | (1L << SEMI))) != 0)) {
				{
				{
				setState(123);
				blockStatement();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_blockStatement);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case INTEGER:
			case BOOLEAN:
			case CHAR:
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				localVariableDeclarationStatement();
				}
				break;
			case IF:
			case WHILE:
			case RETURN:
			case VARID:
			case ID:
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			localVariableDeclaration();
			setState(134);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
	 
		public LocalVariableDeclarationContext() { }
		public void copyFrom(LocalVariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrimDeclContext extends LocalVariableDeclarationContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }
		public TerminalNode ASS() { return getToken(LavaParser.ASS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrimDeclContext(LocalVariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterPrimDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitPrimDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitPrimDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayDeclContext extends LocalVariableDeclarationContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }
		public TerminalNode ASS() { return getToken(LavaParser.ASS, 0); }
		public TerminalNode WITH() { return getToken(LavaParser.WITH, 0); }
		public TerminalNode SIZE() { return getToken(LavaParser.SIZE, 0); }
		public TerminalNode NUM() { return getToken(LavaParser.NUM, 0); }
		public ArrayDeclContext(LocalVariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitArrayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitArrayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_localVariableDeclaration);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new PrimDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				primitiveType();
				setState(139);
				match(VARID);
				setState(142);
				_la = _input.LA(1);
				if (_la==ASS) {
					{
					setState(140);
					match(ASS);
					setState(141);
					expr(0);
					}
				}

				}
				break;
			case 2:
				_localctx = new ArrayDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				primitiveType();
				setState(145);
				arrayType();
				setState(146);
				match(VARID);
				setState(147);
				match(ASS);
				setState(148);
				match(WITH);
				setState(149);
				match(SIZE);
				setState(150);
				match(NUM);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode ERUPT() { return getToken(LavaParser.ERUPT, 0); }
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ERUPT);
			setState(155);
			match(LPAR);
			setState(156);
			match(RPAR);
			setState(157);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiondeclContext extends ParserRuleContext {
		public TerminalNode RUPTURE() { return getToken(LavaParser.RUPTURE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(LavaParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }
		public ParametersdeclContext parametersdecl() {
			return getRuleContext(ParametersdeclContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctiondeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterFunctiondecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitFunctiondecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitFunctiondecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiondeclContext functiondecl() throws RecognitionException {
		FunctiondeclContext _localctx = new FunctiondeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functiondecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(159);
			match(RUPTURE);
			setState(160);
			type();
			setState(161);
			match(ID);
			setState(162);
			match(LPAR);
			setState(163);
			parametersdecl();
			setState(164);
			match(RPAR);
			setState(165);
			block();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LavaParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(ID);
			setState(168);
			match(LPAR);
			setState(169);
			parameters();
			setState(170);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersdeclContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> VARID() { return getTokens(LavaParser.VARID); }
		public TerminalNode VARID(int i) {
			return getToken(LavaParser.VARID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LavaParser.COMMA, i);
		}
		public ParametersdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterParametersdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitParametersdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitParametersdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersdeclContext parametersdecl() throws RecognitionException {
		ParametersdeclContext _localctx = new ParametersdeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parametersdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << BOOLEAN) | (1L << CHAR) | (1L << VOID) | (1L << SHARED))) != 0)) {
				{
				setState(172);
				type();
				setState(173);
				match(VARID);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(174);
					match(COMMA);
					setState(175);
					type();
					setState(176);
					match(VARID);
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetContext extends ParserRuleContext {
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
	 
		public TargetContext() { }
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VariableTargetContext extends TargetContext {
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }
		public VariableTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterVariableTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitVariableTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitVariableTarget(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayIndexTargetContext extends TargetContext {
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }
		public TerminalNode LBLOCK() { return getToken(LavaParser.LBLOCK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBLOCK() { return getToken(LavaParser.RBLOCK, 0); }
		public ArrayIndexTargetContext(TargetContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterArrayIndexTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitArrayIndexTarget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitArrayIndexTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_target);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new VariableTargetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(VARID);
				}
				break;
			case 2:
				_localctx = new ArrayIndexTargetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(VARID);
				setState(187);
				match(LBLOCK);
				setState(188);
				expr(0);
				setState(189);
				match(RBLOCK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitContext extends ParserRuleContext {
		public TerminalNode LBLOCK() { return getToken(LavaParser.LBLOCK, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RBLOCK() { return getToken(LavaParser.RBLOCK, 0); }
		public ArrayInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterArrayInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitArrayInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitArrayInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitContext arrayInit() throws RecognitionException {
		ArrayInitContext _localctx = new ArrayInitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arrayInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(LBLOCK);
			setState(194);
			parameters();
			setState(195);
			match(RBLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LavaParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << VARID) | (1L << ID) | (1L << NUM) | (1L << CHARACTER) | (1L << LBLOCK) | (1L << LPAR) | (1L << MINUS))) != 0)) {
				{
				setState(197);
				expr(0);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(198);
					match(COMMA);
					setState(199);
					expr(0);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompOpContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(LavaParser.EQ, 0); }
		public TerminalNode GE() { return getToken(LavaParser.GE, 0); }
		public TerminalNode GT() { return getToken(LavaParser.GT, 0); }
		public TerminalNode LE() { return getToken(LavaParser.LE, 0); }
		public TerminalNode LT() { return getToken(LavaParser.LT, 0); }
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GE) | (1L << GT) | (1L << LE) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolOpContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(LavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(LavaParser.OR, 0); }
		public TerminalNode XOR() { return getToken(LavaParser.XOR, 0); }
		public BoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitBoolOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitBoolOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << XOR))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultOpContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(LavaParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(LavaParser.SLASH, 0); }
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitMultOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitMultOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !(_la==SLASH || _la==STAR) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusOpContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(LavaParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LavaParser.MINUS, 0); }
		public PlusOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterPlusOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitPlusOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitPlusOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusOpContext plusOp() throws RecognitionException {
		PlusOpContext _localctx = new PlusOpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_plusOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==PLUS) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NegaOpContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(LavaParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(LavaParser.MINUS, 0); }
		public NegaOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negaOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterNegaOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitNegaOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitNegaOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegaOpContext negaOp() throws RecognitionException {
		NegaOpContext _localctx = new NegaOpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_negaOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_la = _input.LA(1);
			if ( !(_la==NOT || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharExprContext extends ExprContext {
		public TerminalNode CHARACTER() { return getToken(LavaParser.CHARACTER, 0); }
		public CharExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterCharExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitCharExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitCharExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }
		public TerminalNode LBLOCK() { return getToken(LavaParser.LBLOCK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBLOCK() { return getToken(LavaParser.RBLOCK, 0); }
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueExprContext extends ExprContext {
		public TerminalNode TRUE() { return getToken(LavaParser.TRUE, 0); }
		public TrueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterTrueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitTrueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitTrueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayInitExprContext extends ExprContext {
		public ArrayInitContext arrayInit() {
			return getRuleContext(ArrayInitContext.class,0);
		}
		public ArrayInitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterArrayInitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitArrayInitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitArrayInitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOT() { return getToken(LavaParser.DOT, 0); }
		public FieldExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterFieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitFieldExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitFieldExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public MultExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumExprContext extends ExprContext {
		public TerminalNode NUM() { return getToken(LavaParser.NUM, 0); }
		public NumExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitNumExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitNumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PlusOpContext plusOp() {
			return getRuleContext(PlusOpContext.class,0);
		}
		public PlusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterPlusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitPlusExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionExprContext extends ExprContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitFunctionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitFunctionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParExprContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }
		public ParExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExprContext {
		public NegaOpContext negaOp() {
			return getRuleContext(NegaOpContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public CompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseExprContext extends ExprContext {
		public TerminalNode FALSE() { return getToken(LavaParser.FALSE, 0); }
		public FalseExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterFalseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitFalseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitFalseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExprContext {
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }
		public IdExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(218);
				negaOp();
				setState(219);
				expr(14);
				}
				break;
			case 2:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				match(LPAR);
				setState(222);
				expr(0);
				setState(223);
				match(RPAR);
				}
				break;
			case 3:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(NUM);
				}
				break;
			case 4:
				{
				_localctx = new CharExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(CHARACTER);
				}
				break;
			case 5:
				{
				_localctx = new TrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(TRUE);
				}
				break;
			case 6:
				{
				_localctx = new FalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(FALSE);
				}
				break;
			case 7:
				{
				_localctx = new FunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				function();
				}
				break;
			case 8:
				{
				_localctx = new ArrayInitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				arrayInit();
				}
				break;
			case 9:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(VARID);
				setState(232);
				match(LBLOCK);
				setState(233);
				expr(0);
				setState(234);
				match(RBLOCK);
				}
				break;
			case 10:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(VARID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new FieldExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(240);
						match(DOT);
						setState(241);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(243);
						multOp();
						setState(244);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(247);
						plusOp();
						setState(248);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(251);
						boolOp();
						setState(252);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(255);
						compOp();
						setState(256);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public SharedContext shared() {
			return getRuleContext(SharedContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if (_la==SHARED) {
				{
				setState(263);
				shared();
				}
			}

			setState(266);
			primitiveType();
			setState(268);
			_la = _input.LA(1);
			if (_la==LBLOCK) {
				{
				setState(267);
				arrayType();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode LBLOCK() { return getToken(LavaParser.LBLOCK, 0); }
		public TerminalNode RBLOCK() { return getToken(LavaParser.RBLOCK, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(LBLOCK);
			setState(271);
			match(RBLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SharedContext extends ParserRuleContext {
		public TerminalNode SHARED() { return getToken(LavaParser.SHARED, 0); }
		public SharedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shared; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterShared(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitShared(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitShared(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SharedContext shared() throws RecognitionException {
		SharedContext _localctx = new SharedContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_shared);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(SHARED);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
	 
		public PrimitiveTypeContext() { }
		public void copyFrom(PrimitiveTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CharTypeContext extends PrimitiveTypeContext {
		public TerminalNode CHAR() { return getToken(LavaParser.CHAR, 0); }
		public CharTypeContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterCharType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitCharType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends PrimitiveTypeContext {
		public TerminalNode INTEGER() { return getToken(LavaParser.INTEGER, 0); }
		public IntTypeContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VoidTypeContext extends PrimitiveTypeContext {
		public TerminalNode VOID() { return getToken(LavaParser.VOID, 0); }
		public VoidTypeContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitVoidType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends PrimitiveTypeContext {
		public TerminalNode BOOLEAN() { return getToken(LavaParser.BOOLEAN, 0); }
		public BoolTypeContext(PrimitiveTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_primitiveType);
		try {
			setState(279);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				match(INTEGER);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(277);
				match(CHAR);
				}
				break;
			case VOID:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(278);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u011c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3?\n\3\f\3\16\3"+
		"B\13\3\3\3\7\3E\n\3\f\3\16\3H\13\3\3\3\5\3K\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4`\n\4\f\4\16"+
		"\4c\13\4\3\4\3\4\5\4g\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4w\n\4\3\5\3\5\3\5\3\5\3\6\3\6\7\6\177\n\6\f\6\16\6\u0082"+
		"\13\6\3\7\3\7\5\7\u0086\n\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u0091"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009b\n\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\7\16\u00b5\n\16\f\16\16\16\u00b8\13\16\5\16\u00ba\n"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c2\n\17\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\7\21\u00cb\n\21\f\21\16\21\u00ce\13\21\5\21\u00d0\n\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u00f0\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0105\n\27\f\27"+
		"\16\27\u0108\13\27\3\30\5\30\u010b\n\30\3\30\3\30\5\30\u010f\n\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u011a\n\33\3\33\2\3,\34"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\7\4\2&),,"+
		"\3\2\21\23\3\2\62\63\3\2-.\4\2\30\30--\u0127\2\66\3\2\2\2\4@\3\2\2\2\6"+
		"v\3\2\2\2\bx\3\2\2\2\n|\3\2\2\2\f\u0085\3\2\2\2\16\u0087\3\2\2\2\20\u008a"+
		"\3\2\2\2\22\u009a\3\2\2\2\24\u009c\3\2\2\2\26\u00a1\3\2\2\2\30\u00a9\3"+
		"\2\2\2\32\u00b9\3\2\2\2\34\u00c1\3\2\2\2\36\u00c3\3\2\2\2 \u00cf\3\2\2"+
		"\2\"\u00d1\3\2\2\2$\u00d3\3\2\2\2&\u00d5\3\2\2\2(\u00d7\3\2\2\2*\u00d9"+
		"\3\2\2\2,\u00ef\3\2\2\2.\u010a\3\2\2\2\60\u0110\3\2\2\2\62\u0113\3\2\2"+
		"\2\64\u0119\3\2\2\2\66\67\7\r\2\2\678\7\35\2\289\7*\2\29:\5\4\3\2:;\7"+
		"/\2\2;<\7\2\2\3<\3\3\2\2\2=?\5\16\b\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A"+
		"\3\2\2\2AF\3\2\2\2B@\3\2\2\2CE\5\26\f\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2"+
		"FG\3\2\2\2GJ\3\2\2\2HF\3\2\2\2IK\5\24\13\2JI\3\2\2\2JK\3\2\2\2K\5\3\2"+
		"\2\2LM\5\34\17\2MN\7#\2\2NO\5,\27\2OP\7\61\2\2Pw\3\2\2\2QR\7\n\2\2RS\7"+
		"+\2\2ST\5,\27\2TU\7\60\2\2UV\7\13\2\2Va\5\b\5\2WX\7\f\2\2XY\7\n\2\2YZ"+
		"\7+\2\2Z[\5,\27\2[\\\7\60\2\2\\]\7\13\2\2]^\5\b\5\2^`\3\2\2\2_W\3\2\2"+
		"\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bf\3\2\2\2ca\3\2\2\2de\7\f\2\2eg\5\b\5"+
		"\2fd\3\2\2\2fg\3\2\2\2gw\3\2\2\2hi\7\16\2\2ij\7+\2\2jk\5,\27\2kl\7\60"+
		"\2\2lm\5\b\5\2mw\3\2\2\2no\5\30\r\2op\7\61\2\2pw\3\2\2\2qr\7\26\2\2rs"+
		"\5,\27\2st\7\61\2\2tw\3\2\2\2uw\5\20\t\2vL\3\2\2\2vQ\3\2\2\2vh\3\2\2\2"+
		"vn\3\2\2\2vq\3\2\2\2vu\3\2\2\2w\7\3\2\2\2xy\7*\2\2yz\5\n\6\2z{\7/\2\2"+
		"{\t\3\2\2\2|\u0080\5\f\7\2}\177\5\f\7\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\13\3\2\2\2\u0082\u0080\3\2\2\2\u0083"+
		"\u0086\5\16\b\2\u0084\u0086\5\6\4\2\u0085\u0083\3\2\2\2\u0085\u0084\3"+
		"\2\2\2\u0086\r\3\2\2\2\u0087\u0088\5\22\n\2\u0088\u0089\7\61\2\2\u0089"+
		"\17\3\2\2\2\u008a\u008b\7\61\2\2\u008b\21\3\2\2\2\u008c\u008d\5\64\33"+
		"\2\u008d\u0090\7\34\2\2\u008e\u008f\7#\2\2\u008f\u0091\5,\27\2\u0090\u008e"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u009b\3\2\2\2\u0092\u0093\5\64\33\2"+
		"\u0093\u0094\5\60\31\2\u0094\u0095\7\34\2\2\u0095\u0096\7#\2\2\u0096\u0097"+
		"\7\31\2\2\u0097\u0098\7\32\2\2\u0098\u0099\7\36\2\2\u0099\u009b\3\2\2"+
		"\2\u009a\u008c\3\2\2\2\u009a\u0092\3\2\2\2\u009b\23\3\2\2\2\u009c\u009d"+
		"\7\25\2\2\u009d\u009e\7+\2\2\u009e\u009f\7\60\2\2\u009f\u00a0\5\b\5\2"+
		"\u00a0\25\3\2\2\2\u00a1\u00a2\7\24\2\2\u00a2\u00a3\5.\30\2\u00a3\u00a4"+
		"\7\35\2\2\u00a4\u00a5\7+\2\2\u00a5\u00a6\5\32\16\2\u00a6\u00a7\7\60\2"+
		"\2\u00a7\u00a8\5\b\5\2\u00a8\27\3\2\2\2\u00a9\u00aa\7\35\2\2\u00aa\u00ab"+
		"\7+\2\2\u00ab\u00ac\5 \21\2\u00ac\u00ad\7\60\2\2\u00ad\31\3\2\2\2\u00ae"+
		"\u00af\5.\30\2\u00af\u00b6\7\34\2\2\u00b0\u00b1\7$\2\2\u00b1\u00b2\5."+
		"\30\2\u00b2\u00b3\7\34\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00ba\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ae\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\33\3\2\2\2\u00bb\u00c2\7\34\2\2\u00bc\u00bd\7\34\2\2\u00bd\u00be\7 \2"+
		"\2\u00be\u00bf\5,\27\2\u00bf\u00c0\7!\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bb"+
		"\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c2\35\3\2\2\2\u00c3\u00c4\7 \2\2\u00c4"+
		"\u00c5\5 \21\2\u00c5\u00c6\7!\2\2\u00c6\37\3\2\2\2\u00c7\u00cc\5,\27\2"+
		"\u00c8\u00c9\7$\2\2\u00c9\u00cb\5,\27\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00c7\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0!\3\2\2\2"+
		"\u00d1\u00d2\t\2\2\2\u00d2#\3\2\2\2\u00d3\u00d4\t\3\2\2\u00d4%\3\2\2\2"+
		"\u00d5\u00d6\t\4\2\2\u00d6\'\3\2\2\2\u00d7\u00d8\t\5\2\2\u00d8)\3\2\2"+
		"\2\u00d9\u00da\t\6\2\2\u00da+\3\2\2\2\u00db\u00dc\b\27\1\2\u00dc\u00dd"+
		"\5*\26\2\u00dd\u00de\5,\27\20\u00de\u00f0\3\2\2\2\u00df\u00e0\7+\2\2\u00e0"+
		"\u00e1\5,\27\2\u00e1\u00e2\7\60\2\2\u00e2\u00f0\3\2\2\2\u00e3\u00f0\7"+
		"\36\2\2\u00e4\u00f0\7\37\2\2\u00e5\u00f0\7\17\2\2\u00e6\u00f0\7\20\2\2"+
		"\u00e7\u00f0\5\30\r\2\u00e8\u00f0\5\36\20\2\u00e9\u00ea\7\34\2\2\u00ea"+
		"\u00eb\7 \2\2\u00eb\u00ec\5,\27\2\u00ec\u00ed\7!\2\2\u00ed\u00f0\3\2\2"+
		"\2\u00ee\u00f0\7\34\2\2\u00ef\u00db\3\2\2\2\u00ef\u00df\3\2\2\2\u00ef"+
		"\u00e3\3\2\2\2\u00ef\u00e4\3\2\2\2\u00ef\u00e5\3\2\2\2\u00ef\u00e6\3\2"+
		"\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00e8\3\2\2\2\u00ef\u00e9\3\2\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\u0106\3\2\2\2\u00f1\u00f2\f\21\2\2\u00f2\u00f3\7"+
		"%\2\2\u00f3\u0105\5,\27\22\u00f4\u00f5\f\17\2\2\u00f5\u00f6\5&\24\2\u00f6"+
		"\u00f7\5,\27\20\u00f7\u0105\3\2\2\2\u00f8\u00f9\f\16\2\2\u00f9\u00fa\5"+
		"(\25\2\u00fa\u00fb\5,\27\17\u00fb\u0105\3\2\2\2\u00fc\u00fd\f\r\2\2\u00fd"+
		"\u00fe\5$\23\2\u00fe\u00ff\5,\27\16\u00ff\u0105\3\2\2\2\u0100\u0101\f"+
		"\f\2\2\u0101\u0102\5\"\22\2\u0102\u0103\5,\27\r\u0103\u0105\3\2\2\2\u0104"+
		"\u00f1\3\2\2\2\u0104\u00f4\3\2\2\2\u0104\u00f8\3\2\2\2\u0104\u00fc\3\2"+
		"\2\2\u0104\u0100\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107-\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010b\5\62\32"+
		"\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e"+
		"\5\64\33\2\u010d\u010f\5\60\31\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2"+
		"\2\u010f/\3\2\2\2\u0110\u0111\7 \2\2\u0111\u0112\7!\2\2\u0112\61\3\2\2"+
		"\2\u0113\u0114\7\27\2\2\u0114\63\3\2\2\2\u0115\u011a\7\3\2\2\u0116\u011a"+
		"\7\4\2\2\u0117\u011a\7\6\2\2\u0118\u011a\7\t\2\2\u0119\u0115\3\2\2\2\u0119"+
		"\u0116\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a\65\3\2\2"+
		"\2\27@FJafv\u0080\u0085\u0090\u009a\u00b6\u00b9\u00c1\u00cc\u00cf\u00ef"+
		"\u0104\u0106\u010a\u010e\u0119";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}