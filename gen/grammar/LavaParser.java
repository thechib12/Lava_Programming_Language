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

/**
 * The type Lava parser.
 */
@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	/**
	 * The constant _decisionToDFA.
	 */
	protected static final DFA[] _decisionToDFA;
	/**
	 * The constant _sharedContextCache.
	 */
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	/**
	 * The constant INTEGER.
	 */
	public static final int
		INTEGER=1, /**
	 * The Boolean.
	 */
	BOOLEAN=2, /**
	 * The Double.
	 */
	DOUBLE=3, /**
	 * The Char.
	 */
	CHAR=4, /**
	 * The Long.
	 */
	LONG=5, /**
	 * The String.
	 */
	STRING=6, /**
	 * The Void.
	 */
	VOID=7, /**
	 * The If.
	 */
	IF=8,
	/**
	 * The Then.
	 */
	THEN=9, /**
	 * The Else.
	 */
	ELSE=10, /**
	 * The Chamber.
	 */
	CHAMBER=11, /**
	 * The While.
	 */
	WHILE=12, /**
	 * The True.
	 */
	TRUE=13, /**
	 * The False.
	 */
	FALSE=14, /**
	 * The And.
	 */
	AND=15, /**
	 * The Or.
	 */
	OR=16,
	/**
	 * The Xor.
	 */
	XOR=17, /**
	 * The Rupture.
	 */
	RUPTURE=18, /**
	 * The Erupt.
	 */
	ERUPT=19, /**
	 * The Return.
	 */
	RETURN=20, /**
	 * The Shared.
	 */
	SHARED=21, /**
	 * The Not.
	 */
	NOT=22, /**
	 * The With.
	 */
	WITH=23, /**
	 * The Size.
	 */
	SIZE=24,
	/**
	 * The Static string.
	 */
	STATIC_STRING=25, /**
	 * The Varid.
	 */
	VARID=26, /**
	 * The Id.
	 */
	ID=27, /**
	 * The Num.
	 */
	NUM=28, /**
	 * The Character.
	 */
	CHARACTER=29, /**
	 * The Lblock.
	 */
	LBLOCK=30, /**
	 * The Rblock.
	 */
	RBLOCK=31,
	/**
	 * The Dollar.
	 */
	DOLLAR=32, /**
	 * The Ass.
	 */
	ASS=33, /**
	 * The Comma.
	 */
	COMMA=34, /**
	 * The Dot.
	 */
	DOT=35, /**
	 * The Eq.
	 */
	EQ=36, /**
	 * The Ge.
	 */
	GE=37, /**
	 * The Gt.
	 */
	GT=38, /**
	 * The Le.
	 */
	LE=39, /**
	 * The Lbrace.
	 */
	LBRACE=40,
	/**
	 * The Lpar.
	 */
	LPAR=41, /**
	 * The Lt.
	 */
	LT=42, /**
	 * The Minus.
	 */
	MINUS=43, /**
	 * The Plus.
	 */
	PLUS=44, /**
	 * The Rbrace.
	 */
	RBRACE=45, /**
	 * The Rpar.
	 */
	RPAR=46, /**
	 * The Semi.
	 */
	SEMI=47, /**
	 * The Slash.
	 */
	SLASH=48,
	/**
	 * The Star.
	 */
	STAR=49, /**
	 * The Ws.
	 */
	WS=50, /**
	 * The Comment.
	 */
	COMMENT=51;
	/**
	 * The constant RULE_program.
	 */
	public static final int
		RULE_program = 0, /**
	 * The Rule body.
	 */
	RULE_body = 1, /**
	 * The Rule statement.
	 */
	RULE_statement = 2, /**
	 * The Rule block.
	 */
	RULE_block = 3, /**
	 * The Rule block statement.
	 */
	RULE_blockStatement = 4,
	/**
	 * The Rule local variable declaration statement.
	 */
	RULE_localVariableDeclarationStatement = 5, /**
	 * The Rule local variable declaration.
	 */
	RULE_localVariableDeclaration = 6,
	/**
	 * The Rule main.
	 */
	RULE_main = 7, /**
	 * The Rule function declaration.
	 */
	RULE_functionDeclaration = 8, /**
	 * The Rule function call.
	 */
	RULE_functionCall = 9, /**
	 * The Rule parameters declaration.
	 */
	RULE_parametersDeclaration = 10,
	/**
	 * The Rule target.
	 */
	RULE_target = 11, /**
	 * The Rule parameters.
	 */
	RULE_parameters = 12, /**
	 * The Rule comp op.
	 */
	RULE_compOp = 13, /**
	 * The Rule bool op.
	 */
	RULE_boolOp = 14,
	/**
	 * The Rule mult op.
	 */
	RULE_multOp = 15, /**
	 * The Rule plus op.
	 */
	RULE_plusOp = 16, /**
	 * The Rule nega op.
	 */
	RULE_negaOp = 17, /**
	 * The Rule expr.
	 */
	RULE_expr = 18,
	/**
	 * The Rule type.
	 */
	RULE_type = 19, /**
	 * The Rule shared.
	 */
	RULE_shared = 20, /**
	 * The Rule primitive type.
	 */
	RULE_primitiveType = 21;
	/**
	 * The constant ruleNames.
	 */
	public static final String[] ruleNames = {
		"program", "body", "statement", "block", "blockStatement", "localVariableDeclarationStatement", 
		"localVariableDeclaration", "main", "functionDeclaration", "functionCall", 
		"parametersDeclaration", "target", "parameters", "compOp", "boolOp", "multOp", 
		"plusOp", "negaOp", "expr", "type", "shared", "primitiveType"
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
	/**
	 * The constant VOCABULARY.
	 */
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * The constant tokenNames.
	 *
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

	/**
	 * Instantiates a new Lava parser.
	 *
	 * @param input the input
	 */
	public LavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	/**
	 * The type Program context.
	 */
	public static class ProgramContext extends ParserRuleContext {
		/**
		 * Chamber terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode CHAMBER() { return getToken(LavaParser.CHAMBER, 0); }

		/**
		 * Id terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode ID() { return getToken(LavaParser.ID, 0); }

		/**
		 * Lbrace terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LBRACE() { return getToken(LavaParser.LBRACE, 0); }

		/**
		 * Body body context.
		 *
		 * @return the body context
		 */
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}

		/**
		 * Rbrace terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RBRACE() { return getToken(LavaParser.RBRACE, 0); }

		/**
		 * Eof terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode EOF() { return getToken(LavaParser.EOF, 0); }

		/**
		 * Instantiates a new Program context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Program program context.
	 *
	 * @return the program context
	 * @throws RecognitionException the recognition exception
	 */
	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(CHAMBER);
			setState(45);
			match(ID);
			setState(46);
			match(LBRACE);
			setState(47);
			body();
			setState(48);
			match(RBRACE);
			setState(49);
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

	/**
	 * The type Body context.
	 */
	public static class BodyContext extends ParserRuleContext {
		/**
		 * Local variable declaration statement list.
		 *
		 * @return the list
		 */
		public List<LocalVariableDeclarationStatementContext> localVariableDeclarationStatement() {
			return getRuleContexts(LocalVariableDeclarationStatementContext.class);
		}

		/**
		 * Local variable declaration statement local variable declaration statement context.
		 *
		 * @param i the
		 * @return the local variable declaration statement context
		 */
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement(int i) {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,i);
		}

		/**
		 * Function declaration list.
		 *
		 * @return the list
		 */
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}

		/**
		 * Function declaration function declaration context.
		 *
		 * @param i the
		 * @return the function declaration context
		 */
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}

		/**
		 * Main main context.
		 *
		 * @return the main context
		 */
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}

		/**
		 * Instantiates a new Body context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Body body context.
	 *
	 * @return the body context
	 * @throws RecognitionException the recognition exception
	 */
	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << BOOLEAN) | (1L << CHAR) | (1L << VOID) | (1L << SHARED))) != 0)) {
				{
				{
				setState(51);
				localVariableDeclarationStatement();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RUPTURE) {
				{
				{
				setState(57);
				functionDeclaration();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			_la = _input.LA(1);
			if (_la==ERUPT) {
				{
				setState(63);
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

	/**
	 * The type Statement context.
	 */
	public static class StatementContext extends ParserRuleContext {
		/**
		 * Instantiates a new Statement context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }

		/**
		 * Instantiates a new Statement context.
		 */
		public StatementContext() { }

		/**
		 * Copy from.
		 *
		 * @param ctx the ctx
		 */
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}

	/**
	 * The type If stat context.
	 */
	public static class IfStatContext extends StatementContext {
		/**
		 * If list.
		 *
		 * @return the list
		 */
		public List<TerminalNode> IF() { return getTokens(LavaParser.IF); }

		/**
		 * If terminal node.
		 *
		 * @param i the
		 * @return the terminal node
		 */
		public TerminalNode IF(int i) {
			return getToken(LavaParser.IF, i);
		}

		/**
		 * Lpar list.
		 *
		 * @return the list
		 */
		public List<TerminalNode> LPAR() { return getTokens(LavaParser.LPAR); }

		/**
		 * Lpar terminal node.
		 *
		 * @param i the
		 * @return the terminal node
		 */
		public TerminalNode LPAR(int i) {
			return getToken(LavaParser.LPAR, i);
		}

		/**
		 * Expr list.
		 *
		 * @return the list
		 */
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		/**
		 * Expr expr context.
		 *
		 * @param i the
		 * @return the expr context
		 */
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}

		/**
		 * Rpar list.
		 *
		 * @return the list
		 */
		public List<TerminalNode> RPAR() { return getTokens(LavaParser.RPAR); }

		/**
		 * Rpar terminal node.
		 *
		 * @param i the
		 * @return the terminal node
		 */
		public TerminalNode RPAR(int i) {
			return getToken(LavaParser.RPAR, i);
		}

		/**
		 * Then list.
		 *
		 * @return the list
		 */
		public List<TerminalNode> THEN() { return getTokens(LavaParser.THEN); }

		/**
		 * Then terminal node.
		 *
		 * @param i the
		 * @return the terminal node
		 */
		public TerminalNode THEN(int i) {
			return getToken(LavaParser.THEN, i);
		}

		/**
		 * Block list.
		 *
		 * @return the list
		 */
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}

		/**
		 * Block block context.
		 *
		 * @param i the
		 * @return the block context
		 */
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}

		/**
		 * Else list.
		 *
		 * @return the list
		 */
		public List<TerminalNode> ELSE() { return getTokens(LavaParser.ELSE); }

		/**
		 * Else terminal node.
		 *
		 * @param i the
		 * @return the terminal node
		 */
		public TerminalNode ELSE(int i) {
			return getToken(LavaParser.ELSE, i);
		}

		/**
		 * Instantiates a new If stat context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Function stat context.
	 */
	public static class FunctionStatContext extends StatementContext {
		/**
		 * Function call function call context.
		 *
		 * @return the function call context
		 */
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}

		/**
		 * Semi terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }

		/**
		 * Instantiates a new Function stat context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Return stat context.
	 */
	public static class ReturnStatContext extends StatementContext {
		/**
		 * Return terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RETURN() { return getToken(LavaParser.RETURN, 0); }

		/**
		 * Expr expr context.
		 *
		 * @return the expr context
		 */
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}

		/**
		 * Semi terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }

		/**
		 * Instantiates a new Return stat context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Assign stat context.
	 */
	public static class AssignStatContext extends StatementContext {
		/**
		 * Target target context.
		 *
		 * @return the target context
		 */
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}

		/**
		 * Ass terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode ASS() { return getToken(LavaParser.ASS, 0); }

		/**
		 * Expr expr context.
		 *
		 * @return the expr context
		 */
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}

		/**
		 * Semi terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }

		/**
		 * Instantiates a new Assign stat context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Empty stat context.
	 */
	public static class EmptyStatContext extends StatementContext {
		/**
		 * Semi terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }

		/**
		 * Instantiates a new Empty stat context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type While stat context.
	 */
	public static class WhileStatContext extends StatementContext {
		/**
		 * While terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode WHILE() { return getToken(LavaParser.WHILE, 0); }

		/**
		 * Lpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }

		/**
		 * Expr expr context.
		 *
		 * @return the expr context
		 */
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}

		/**
		 * Rpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }

		/**
		 * Block block context.
		 *
		 * @return the block context
		 */
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}

		/**
		 * Instantiates a new While stat context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * Statement statement context.
	 *
	 * @return the statement context
	 * @throws RecognitionException the recognition exception
	 */
	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(108);
			switch (_input.LA(1)) {
			case VARID:
				_localctx = new AssignStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				target();
				setState(67);
				match(ASS);
				setState(68);
				expr(0);
				setState(69);
				match(SEMI);
				}
				break;
			case IF:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				match(IF);
				setState(72);
				match(LPAR);
				setState(73);
				expr(0);
				setState(74);
				match(RPAR);
				setState(75);
				match(THEN);
				setState(76);
				block();
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(77);
						match(ELSE);
						setState(78);
						match(IF);
						setState(79);
						match(LPAR);
						setState(80);
						expr(0);
						setState(81);
						match(RPAR);
						setState(82);
						match(THEN);
						setState(83);
						block();
						}
						} 
					}
					setState(89);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(92);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(90);
					match(ELSE);
					setState(91);
					block();
					}
				}

				}
				break;
			case WHILE:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(WHILE);
				setState(95);
				match(LPAR);
				setState(96);
				expr(0);
				setState(97);
				match(RPAR);
				setState(98);
				block();
				}
				break;
			case ID:
				_localctx = new FunctionStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				functionCall();
				setState(101);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				match(RETURN);
				setState(104);
				expr(0);
				setState(105);
				match(SEMI);
				}
				break;
			case SEMI:
				_localctx = new EmptyStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(107);
				match(SEMI);
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

	/**
	 * The type Block context.
	 */
	public static class BlockContext extends ParserRuleContext {
		/**
		 * Lbrace terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LBRACE() { return getToken(LavaParser.LBRACE, 0); }

		/**
		 * Rbrace terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RBRACE() { return getToken(LavaParser.RBRACE, 0); }

		/**
		 * Block statement list.
		 *
		 * @return the list
		 */
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}

		/**
		 * Block statement block statement context.
		 *
		 * @param i the
		 * @return the block statement context
		 */
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}

		/**
		 * Instantiates a new Block context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Block block context.
	 *
	 * @return the block context
	 * @throws RecognitionException the recognition exception
	 */
	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(LBRACE);
			{
			setState(111);
			blockStatement();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << BOOLEAN) | (1L << CHAR) | (1L << VOID) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << SHARED) | (1L << VARID) | (1L << ID) | (1L << SEMI))) != 0)) {
				{
				{
				setState(112);
				blockStatement();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(118);
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

	/**
	 * The type Block statement context.
	 */
	public static class BlockStatementContext extends ParserRuleContext {
		/**
		 * Local variable declaration statement local variable declaration statement context.
		 *
		 * @return the local variable declaration statement context
		 */
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}

		/**
		 * Statement statement context.
		 *
		 * @return the statement context
		 */
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}

		/**
		 * Instantiates a new Block statement context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Block statement block statement context.
	 *
	 * @return the block statement context
	 * @throws RecognitionException the recognition exception
	 */
	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_blockStatement);
		try {
			setState(122);
			switch (_input.LA(1)) {
			case INTEGER:
			case BOOLEAN:
			case CHAR:
			case VOID:
			case SHARED:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
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
				setState(121);
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

	/**
	 * The type Local variable declaration statement context.
	 */
	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		/**
		 * Local variable declaration local variable declaration context.
		 *
		 * @return the local variable declaration context
		 */
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}

		/**
		 * Semi terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode SEMI() { return getToken(LavaParser.SEMI, 0); }

		/**
		 * Instantiates a new Local variable declaration statement context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Local variable declaration statement local variable declaration statement context.
	 *
	 * @return the local variable declaration statement context
	 * @throws RecognitionException the recognition exception
	 */
	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			localVariableDeclaration();
			setState(125);
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

	/**
	 * The type Local variable declaration context.
	 */
	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		/**
		 * Instantiates a new Local variable declaration context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }

		/**
		 * Instantiates a new Local variable declaration context.
		 */
		public LocalVariableDeclarationContext() { }

		/**
		 * Copy from.
		 *
		 * @param ctx the ctx
		 */
		public void copyFrom(LocalVariableDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}

	/**
	 * The type Primitive declaration context.
	 */
	public static class PrimitiveDeclarationContext extends LocalVariableDeclarationContext {
		/**
		 * Primitive type primitive type context.
		 *
		 * @return the primitive type context
		 */
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}

		/**
		 * Varid terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }

		/**
		 * Shared shared context.
		 *
		 * @return the shared context
		 */
		public SharedContext shared() {
			return getRuleContext(SharedContext.class,0);
		}

		/**
		 * Ass terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode ASS() { return getToken(LavaParser.ASS, 0); }

		/**
		 * Expr expr context.
		 *
		 * @return the expr context
		 */
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}

		/**
		 * Instantiates a new Primitive declaration context.
		 *
		 * @param ctx the ctx
		 */
		public PrimitiveDeclarationContext(LocalVariableDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterPrimitiveDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitPrimitiveDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitPrimitiveDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	/**
	 * Local variable declaration local variable declaration context.
	 *
	 * @return the local variable declaration context
	 * @throws RecognitionException the recognition exception
	 */
	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_localVariableDeclaration);
		int _la;
		try {
			_localctx = new PrimitiveDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if (_la==SHARED) {
				{
				setState(127);
				shared();
				}
			}

			setState(130);
			primitiveType();
			setState(131);
			match(VARID);
			setState(134);
			_la = _input.LA(1);
			if (_la==ASS) {
				{
				setState(132);
				match(ASS);
				setState(133);
				expr(0);
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

	/**
	 * The type Main context.
	 */
	public static class MainContext extends ParserRuleContext {
		/**
		 * Erupt terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode ERUPT() { return getToken(LavaParser.ERUPT, 0); }

		/**
		 * Lpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }

		/**
		 * Rpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }

		/**
		 * Block block context.
		 *
		 * @return the block context
		 */
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}

		/**
		 * Instantiates a new Main context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Main main context.
	 *
	 * @return the main context
	 * @throws RecognitionException the recognition exception
	 */
	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(ERUPT);
			setState(137);
			match(LPAR);
			setState(138);
			match(RPAR);
			setState(139);
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

	/**
	 * The type Function declaration context.
	 */
	public static class FunctionDeclarationContext extends ParserRuleContext {
		/**
		 * Rupture terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RUPTURE() { return getToken(LavaParser.RUPTURE, 0); }

		/**
		 * Type type context.
		 *
		 * @return the type context
		 */
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}

		/**
		 * Id terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode ID() { return getToken(LavaParser.ID, 0); }

		/**
		 * Lpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }

		/**
		 * Parameters declaration parameters declaration context.
		 *
		 * @return the parameters declaration context
		 */
		public ParametersDeclarationContext parametersDeclaration() {
			return getRuleContext(ParametersDeclarationContext.class,0);
		}

		/**
		 * Rpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }

		/**
		 * Block block context.
		 *
		 * @return the block context
		 */
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}

		/**
		 * Instantiates a new Function declaration context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	/**
	 * Function declaration function declaration context.
	 *
	 * @return the function declaration context
	 * @throws RecognitionException the recognition exception
	 */
	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(141);
			match(RUPTURE);
			setState(142);
			type();
			setState(143);
			match(ID);
			setState(144);
			match(LPAR);
			setState(145);
			parametersDeclaration();
			setState(146);
			match(RPAR);
			setState(147);
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

	/**
	 * The type Function call context.
	 */
	public static class FunctionCallContext extends ParserRuleContext {
		/**
		 * Id terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode ID() { return getToken(LavaParser.ID, 0); }

		/**
		 * Lpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }

		/**
		 * Parameters parameters context.
		 *
		 * @return the parameters context
		 */
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}

		/**
		 * Rpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }

		/**
		 * Instantiates a new Function call context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	/**
	 * Function call function call context.
	 *
	 * @return the function call context
	 * @throws RecognitionException the recognition exception
	 */
	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(ID);
			setState(150);
			match(LPAR);
			setState(151);
			parameters();
			setState(152);
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

	/**
	 * The type Parameters declaration context.
	 */
	public static class ParametersDeclarationContext extends ParserRuleContext {
		/**
		 * Type list.
		 *
		 * @return the list
		 */
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}

		/**
		 * Type type context.
		 *
		 * @param i the
		 * @return the type context
		 */
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}

		/**
		 * Varid list.
		 *
		 * @return the list
		 */
		public List<TerminalNode> VARID() { return getTokens(LavaParser.VARID); }

		/**
		 * Varid terminal node.
		 *
		 * @param i the
		 * @return the terminal node
		 */
		public TerminalNode VARID(int i) {
			return getToken(LavaParser.VARID, i);
		}

		/**
		 * Comma list.
		 *
		 * @return the list
		 */
		public List<TerminalNode> COMMA() { return getTokens(LavaParser.COMMA); }

		/**
		 * Comma terminal node.
		 *
		 * @param i the
		 * @return the terminal node
		 */
		public TerminalNode COMMA(int i) {
			return getToken(LavaParser.COMMA, i);
		}

		/**
		 * Instantiates a new Parameters declaration context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
		public ParametersDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).enterParametersDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LavaListener ) ((LavaListener)listener).exitParametersDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LavaVisitor ) return ((LavaVisitor<? extends T>)visitor).visitParametersDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	/**
	 * Parameters declaration parameters declaration context.
	 *
	 * @return the parameters declaration context
	 * @throws RecognitionException the recognition exception
	 */
	public final ParametersDeclarationContext parametersDeclaration() throws RecognitionException {
		ParametersDeclarationContext _localctx = new ParametersDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parametersDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << BOOLEAN) | (1L << CHAR) | (1L << VOID) | (1L << SHARED))) != 0)) {
				{
				setState(154);
				type();
				setState(155);
				match(VARID);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(156);
					match(COMMA);
					setState(157);
					type();
					setState(158);
					match(VARID);
					}
					}
					setState(164);
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

	/**
	 * The type Target context.
	 */
	public static class TargetContext extends ParserRuleContext {
		/**
		 * Instantiates a new Target context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }

		/**
		 * Instantiates a new Target context.
		 */
		public TargetContext() { }

		/**
		 * Copy from.
		 *
		 * @param ctx the ctx
		 */
		public void copyFrom(TargetContext ctx) {
			super.copyFrom(ctx);
		}
	}

	/**
	 * The type Variable target context.
	 */
	public static class VariableTargetContext extends TargetContext {
		/**
		 * Varid terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }

		/**
		 * Instantiates a new Variable target context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * Target target context.
	 *
	 * @return the target context
	 * @throws RecognitionException the recognition exception
	 */
	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_target);
		try {
			_localctx = new VariableTargetContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(VARID);
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

	/**
	 * The type Parameters context.
	 */
	public static class ParametersContext extends ParserRuleContext {
		/**
		 * Expr list.
		 *
		 * @return the list
		 */
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		/**
		 * Expr expr context.
		 *
		 * @param i the
		 * @return the expr context
		 */
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}

		/**
		 * Comma list.
		 *
		 * @return the list
		 */
		public List<TerminalNode> COMMA() { return getTokens(LavaParser.COMMA); }

		/**
		 * Comma terminal node.
		 *
		 * @param i the
		 * @return the terminal node
		 */
		public TerminalNode COMMA(int i) {
			return getToken(LavaParser.COMMA, i);
		}

		/**
		 * Instantiates a new Parameters context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Parameters parameters context.
	 *
	 * @return the parameters context
	 * @throws RecognitionException the recognition exception
	 */
	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << VARID) | (1L << ID) | (1L << NUM) | (1L << CHARACTER) | (1L << LPAR) | (1L << MINUS))) != 0)) {
				{
				setState(169);
				expr(0);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(170);
					match(COMMA);
					setState(171);
					expr(0);
					}
					}
					setState(176);
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

	/**
	 * The type Comp op context.
	 */
	public static class CompOpContext extends ParserRuleContext {
		/**
		 * Eq terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode EQ() { return getToken(LavaParser.EQ, 0); }

		/**
		 * Ge terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode GE() { return getToken(LavaParser.GE, 0); }

		/**
		 * Gt terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode GT() { return getToken(LavaParser.GT, 0); }

		/**
		 * Le terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LE() { return getToken(LavaParser.LE, 0); }

		/**
		 * Lt terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LT() { return getToken(LavaParser.LT, 0); }

		/**
		 * Instantiates a new Comp op context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Comp op comp op context.
	 *
	 * @return the comp op context
	 * @throws RecognitionException the recognition exception
	 */
	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
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

	/**
	 * The type Bool op context.
	 */
	public static class BoolOpContext extends ParserRuleContext {
		/**
		 * And terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode AND() { return getToken(LavaParser.AND, 0); }

		/**
		 * Or terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode OR() { return getToken(LavaParser.OR, 0); }

		/**
		 * Xor terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode XOR() { return getToken(LavaParser.XOR, 0); }

		/**
		 * Instantiates a new Bool op context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Bool op bool op context.
	 *
	 * @return the bool op context
	 * @throws RecognitionException the recognition exception
	 */
	public final BoolOpContext boolOp() throws RecognitionException {
		BoolOpContext _localctx = new BoolOpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_boolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
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

	/**
	 * The type Mult op context.
	 */
	public static class MultOpContext extends ParserRuleContext {
		/**
		 * Star terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode STAR() { return getToken(LavaParser.STAR, 0); }

		/**
		 * Slash terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode SLASH() { return getToken(LavaParser.SLASH, 0); }

		/**
		 * Instantiates a new Mult op context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Mult op mult op context.
	 *
	 * @return the mult op context
	 * @throws RecognitionException the recognition exception
	 */
	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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

	/**
	 * The type Plus op context.
	 */
	public static class PlusOpContext extends ParserRuleContext {
		/**
		 * Plus terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode PLUS() { return getToken(LavaParser.PLUS, 0); }

		/**
		 * Minus terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode MINUS() { return getToken(LavaParser.MINUS, 0); }

		/**
		 * Instantiates a new Plus op context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Plus op plus op context.
	 *
	 * @return the plus op context
	 * @throws RecognitionException the recognition exception
	 */
	public final PlusOpContext plusOp() throws RecognitionException {
		PlusOpContext _localctx = new PlusOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_plusOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
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

	/**
	 * The type Nega op context.
	 */
	public static class NegaOpContext extends ParserRuleContext {
		/**
		 * Not terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode NOT() { return getToken(LavaParser.NOT, 0); }

		/**
		 * Minus terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode MINUS() { return getToken(LavaParser.MINUS, 0); }

		/**
		 * Instantiates a new Nega op context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Nega op nega op context.
	 *
	 * @return the nega op context
	 * @throws RecognitionException the recognition exception
	 */
	public final NegaOpContext negaOp() throws RecognitionException {
		NegaOpContext _localctx = new NegaOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_negaOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
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

	/**
	 * The type Expr context.
	 */
	public static class ExprContext extends ParserRuleContext {
		/**
		 * Instantiates a new Expr context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }

		/**
		 * Instantiates a new Expr context.
		 */
		public ExprContext() { }

		/**
		 * Copy from.
		 *
		 * @param ctx the ctx
		 */
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}

	/**
	 * The type Par expr context.
	 */
	public static class ParExprContext extends ExprContext {
		/**
		 * Lpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode LPAR() { return getToken(LavaParser.LPAR, 0); }

		/**
		 * Expr expr context.
		 *
		 * @return the expr context
		 */
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}

		/**
		 * Rpar terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode RPAR() { return getToken(LavaParser.RPAR, 0); }

		/**
		 * Instantiates a new Par expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Char expr context.
	 */
	public static class CharExprContext extends ExprContext {
		/**
		 * Character terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode CHARACTER() { return getToken(LavaParser.CHARACTER, 0); }

		/**
		 * Instantiates a new Char expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Not expr context.
	 */
	public static class NotExprContext extends ExprContext {
		/**
		 * Nega op nega op context.
		 *
		 * @return the nega op context
		 */
		public NegaOpContext negaOp() {
			return getRuleContext(NegaOpContext.class,0);
		}

		/**
		 * Expr expr context.
		 *
		 * @return the expr context
		 */
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}

		/**
		 * Instantiates a new Not expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type True expr context.
	 */
	public static class TrueExprContext extends ExprContext {
		/**
		 * True terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode TRUE() { return getToken(LavaParser.TRUE, 0); }

		/**
		 * Instantiates a new True expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Comp expr context.
	 */
	public static class CompExprContext extends ExprContext {
		/**
		 * Expr list.
		 *
		 * @return the list
		 */
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		/**
		 * Expr expr context.
		 *
		 * @param i the
		 * @return the expr context
		 */
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}

		/**
		 * Comp op comp op context.
		 *
		 * @return the comp op context
		 */
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}

		/**
		 * Instantiates a new Comp expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type False expr context.
	 */
	public static class FalseExprContext extends ExprContext {
		/**
		 * False terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode FALSE() { return getToken(LavaParser.FALSE, 0); }

		/**
		 * Instantiates a new False expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Bool expr context.
	 */
	public static class BoolExprContext extends ExprContext {
		/**
		 * Expr list.
		 *
		 * @return the list
		 */
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		/**
		 * Expr expr context.
		 *
		 * @param i the
		 * @return the expr context
		 */
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}

		/**
		 * Bool op bool op context.
		 *
		 * @return the bool op context
		 */
		public BoolOpContext boolOp() {
			return getRuleContext(BoolOpContext.class,0);
		}

		/**
		 * Instantiates a new Bool expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Mult expr context.
	 */
	public static class MultExprContext extends ExprContext {
		/**
		 * Expr list.
		 *
		 * @return the list
		 */
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		/**
		 * Expr expr context.
		 *
		 * @param i the
		 * @return the expr context
		 */
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}

		/**
		 * Mult op mult op context.
		 *
		 * @return the mult op context
		 */
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}

		/**
		 * Instantiates a new Mult expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Num expr context.
	 */
	public static class NumExprContext extends ExprContext {
		/**
		 * Num terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode NUM() { return getToken(LavaParser.NUM, 0); }

		/**
		 * Instantiates a new Num expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Plus expr context.
	 */
	public static class PlusExprContext extends ExprContext {
		/**
		 * Expr list.
		 *
		 * @return the list
		 */
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}

		/**
		 * Expr expr context.
		 *
		 * @param i the
		 * @return the expr context
		 */
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}

		/**
		 * Plus op plus op context.
		 *
		 * @return the plus op context
		 */
		public PlusOpContext plusOp() {
			return getRuleContext(PlusOpContext.class,0);
		}

		/**
		 * Instantiates a new Plus expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Function expr context.
	 */
	public static class FunctionExprContext extends ExprContext {
		/**
		 * Function call function call context.
		 *
		 * @return the function call context
		 */
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}

		/**
		 * Instantiates a new Function expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Id expr context.
	 */
	public static class IdExprContext extends ExprContext {
		/**
		 * Varid terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode VARID() { return getToken(LavaParser.VARID, 0); }

		/**
		 * Instantiates a new Id expr context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * Expr expr context.
	 *
	 * @return the expr context
	 * @throws RecognitionException the recognition exception
	 */
	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			switch (_input.LA(1)) {
			case NOT:
			case MINUS:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(190);
				negaOp();
				setState(191);
				expr(12);
				}
				break;
			case LPAR:
				{
				_localctx = new ParExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(LPAR);
				setState(194);
				expr(0);
				setState(195);
				match(RPAR);
				}
				break;
			case NUM:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(NUM);
				}
				break;
			case CHARACTER:
				{
				_localctx = new CharExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(CHARACTER);
				}
				break;
			case TRUE:
				{
				_localctx = new TrueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				_localctx = new FalseExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(FALSE);
				}
				break;
			case ID:
				{
				_localctx = new FunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				functionCall();
				}
				break;
			case VARID:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(VARID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(206);
						multOp();
						setState(207);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(210);
						plusOp();
						setState(211);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(214);
						boolOp();
						setState(215);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new CompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(218);
						compOp();
						setState(219);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	/**
	 * The type Type context.
	 */
	public static class TypeContext extends ParserRuleContext {
		/**
		 * Primitive type primitive type context.
		 *
		 * @return the primitive type context
		 */
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}

		/**
		 * Shared shared context.
		 *
		 * @return the shared context
		 */
		public SharedContext shared() {
			return getRuleContext(SharedContext.class,0);
		}

		/**
		 * Instantiates a new Type context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Type type context.
	 *
	 * @return the type context
	 * @throws RecognitionException the recognition exception
	 */
	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if (_la==SHARED) {
				{
				setState(226);
				shared();
				}
			}

			setState(229);
			primitiveType();
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

	/**
	 * The type Shared context.
	 */
	public static class SharedContext extends ParserRuleContext {
		/**
		 * Shared terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode SHARED() { return getToken(LavaParser.SHARED, 0); }

		/**
		 * Instantiates a new Shared context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
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

	/**
	 * Shared shared context.
	 *
	 * @return the shared context
	 * @throws RecognitionException the recognition exception
	 */
	public final SharedContext shared() throws RecognitionException {
		SharedContext _localctx = new SharedContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_shared);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
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

	/**
	 * The type Primitive type context.
	 */
	public static class PrimitiveTypeContext extends ParserRuleContext {
		/**
		 * Instantiates a new Primitive type context.
		 *
		 * @param parent        the parent
		 * @param invokingState the invoking state
		 */
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }

		/**
		 * Instantiates a new Primitive type context.
		 */
		public PrimitiveTypeContext() { }

		/**
		 * Copy from.
		 *
		 * @param ctx the ctx
		 */
		public void copyFrom(PrimitiveTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}

	/**
	 * The type Char type context.
	 */
	public static class CharTypeContext extends PrimitiveTypeContext {
		/**
		 * Char terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode CHAR() { return getToken(LavaParser.CHAR, 0); }

		/**
		 * Instantiates a new Char type context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Int type context.
	 */
	public static class IntTypeContext extends PrimitiveTypeContext {
		/**
		 * Integer terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode INTEGER() { return getToken(LavaParser.INTEGER, 0); }

		/**
		 * Instantiates a new Int type context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Void type context.
	 */
	public static class VoidTypeContext extends PrimitiveTypeContext {
		/**
		 * Void terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode VOID() { return getToken(LavaParser.VOID, 0); }

		/**
		 * Instantiates a new Void type context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * The type Bool type context.
	 */
	public static class BoolTypeContext extends PrimitiveTypeContext {
		/**
		 * Boolean terminal node.
		 *
		 * @return the terminal node
		 */
		public TerminalNode BOOLEAN() { return getToken(LavaParser.BOOLEAN, 0); }

		/**
		 * Instantiates a new Bool type context.
		 *
		 * @param ctx the ctx
		 */
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

	/**
	 * Primitive type primitive type context.
	 *
	 * @return the primitive type context
	 * @throws RecognitionException the recognition exception
	 */
	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_primitiveType);
		try {
			setState(237);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(INTEGER);
				}
				break;
			case BOOLEAN:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(235);
				match(CHAR);
				}
				break;
			case VOID:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(236);
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
		case 18:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		}
		return true;
	}

	/**
	 * The constant _serializedATN.
	 */
	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u00f2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\7\3=\n\3\f\3\16\3@\13\3\3\3"+
		"\5\3C\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4X\n\4\f\4\16\4[\13\4\3\4\3\4\5\4_\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4o\n\4\3\5\3\5\3\5\7\5"+
		"t\n\5\f\5\16\5w\13\5\3\5\3\5\3\6\3\6\5\6}\n\6\3\7\3\7\3\7\3\b\5\b\u0083"+
		"\n\b\3\b\3\b\3\b\3\b\5\b\u0089\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f"+
		"\u00a3\n\f\f\f\16\f\u00a6\13\f\5\f\u00a8\n\f\3\r\3\r\3\16\3\16\3\16\7"+
		"\16\u00af\n\16\f\16\16\16\u00b2\13\16\5\16\u00b4\n\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00ce\n\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00e0"+
		"\n\24\f\24\16\24\u00e3\13\24\3\25\5\25\u00e6\n\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\5\27\u00f0\n\27\3\27\2\3&\30\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,\2\7\4\2&),,\3\2\21\23\3\2\62\63\3\2-.\4\2\30"+
		"\30--\u00fc\2.\3\2\2\2\48\3\2\2\2\6n\3\2\2\2\bp\3\2\2\2\n|\3\2\2\2\f~"+
		"\3\2\2\2\16\u0082\3\2\2\2\20\u008a\3\2\2\2\22\u008f\3\2\2\2\24\u0097\3"+
		"\2\2\2\26\u00a7\3\2\2\2\30\u00a9\3\2\2\2\32\u00b3\3\2\2\2\34\u00b5\3\2"+
		"\2\2\36\u00b7\3\2\2\2 \u00b9\3\2\2\2\"\u00bb\3\2\2\2$\u00bd\3\2\2\2&\u00cd"+
		"\3\2\2\2(\u00e5\3\2\2\2*\u00e9\3\2\2\2,\u00ef\3\2\2\2./\7\r\2\2/\60\7"+
		"\35\2\2\60\61\7*\2\2\61\62\5\4\3\2\62\63\7/\2\2\63\64\7\2\2\3\64\3\3\2"+
		"\2\2\65\67\5\f\7\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29>\3"+
		"\2\2\2:8\3\2\2\2;=\5\22\n\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?B"+
		"\3\2\2\2@>\3\2\2\2AC\5\20\t\2BA\3\2\2\2BC\3\2\2\2C\5\3\2\2\2DE\5\30\r"+
		"\2EF\7#\2\2FG\5&\24\2GH\7\61\2\2Ho\3\2\2\2IJ\7\n\2\2JK\7+\2\2KL\5&\24"+
		"\2LM\7\60\2\2MN\7\13\2\2NY\5\b\5\2OP\7\f\2\2PQ\7\n\2\2QR\7+\2\2RS\5&\24"+
		"\2ST\7\60\2\2TU\7\13\2\2UV\5\b\5\2VX\3\2\2\2WO\3\2\2\2X[\3\2\2\2YW\3\2"+
		"\2\2YZ\3\2\2\2Z^\3\2\2\2[Y\3\2\2\2\\]\7\f\2\2]_\5\b\5\2^\\\3\2\2\2^_\3"+
		"\2\2\2_o\3\2\2\2`a\7\16\2\2ab\7+\2\2bc\5&\24\2cd\7\60\2\2de\5\b\5\2eo"+
		"\3\2\2\2fg\5\24\13\2gh\7\61\2\2ho\3\2\2\2ij\7\26\2\2jk\5&\24\2kl\7\61"+
		"\2\2lo\3\2\2\2mo\7\61\2\2nD\3\2\2\2nI\3\2\2\2n`\3\2\2\2nf\3\2\2\2ni\3"+
		"\2\2\2nm\3\2\2\2o\7\3\2\2\2pq\7*\2\2qu\5\n\6\2rt\5\n\6\2sr\3\2\2\2tw\3"+
		"\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7/\2\2y\t\3\2\2\2z}\5"+
		"\f\7\2{}\5\6\4\2|z\3\2\2\2|{\3\2\2\2}\13\3\2\2\2~\177\5\16\b\2\177\u0080"+
		"\7\61\2\2\u0080\r\3\2\2\2\u0081\u0083\5*\26\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\5,\27\2\u0085\u0088\7\34"+
		"\2\2\u0086\u0087\7#\2\2\u0087\u0089\5&\24\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\17\3\2\2\2\u008a\u008b\7\25\2\2\u008b\u008c\7+\2"+
		"\2\u008c\u008d\7\60\2\2\u008d\u008e\5\b\5\2\u008e\21\3\2\2\2\u008f\u0090"+
		"\7\24\2\2\u0090\u0091\5(\25\2\u0091\u0092\7\35\2\2\u0092\u0093\7+\2\2"+
		"\u0093\u0094\5\26\f\2\u0094\u0095\7\60\2\2\u0095\u0096\5\b\5\2\u0096\23"+
		"\3\2\2\2\u0097\u0098\7\35\2\2\u0098\u0099\7+\2\2\u0099\u009a\5\32\16\2"+
		"\u009a\u009b\7\60\2\2\u009b\25\3\2\2\2\u009c\u009d\5(\25\2\u009d\u00a4"+
		"\7\34\2\2\u009e\u009f\7$\2\2\u009f\u00a0\5(\25\2\u00a0\u00a1\7\34\2\2"+
		"\u00a1\u00a3\3\2\2\2\u00a2\u009e\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\u009c\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\27\3\2\2\2\u00a9\u00aa\7\34\2"+
		"\2\u00aa\31\3\2\2\2\u00ab\u00b0\5&\24\2\u00ac\u00ad\7$\2\2\u00ad\u00af"+
		"\5&\24\2\u00ae\u00ac\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00ab\3\2"+
		"\2\2\u00b3\u00b4\3\2\2\2\u00b4\33\3\2\2\2\u00b5\u00b6\t\2\2\2\u00b6\35"+
		"\3\2\2\2\u00b7\u00b8\t\3\2\2\u00b8\37\3\2\2\2\u00b9\u00ba\t\4\2\2\u00ba"+
		"!\3\2\2\2\u00bb\u00bc\t\5\2\2\u00bc#\3\2\2\2\u00bd\u00be\t\6\2\2\u00be"+
		"%\3\2\2\2\u00bf\u00c0\b\24\1\2\u00c0\u00c1\5$\23\2\u00c1\u00c2\5&\24\16"+
		"\u00c2\u00ce\3\2\2\2\u00c3\u00c4\7+\2\2\u00c4\u00c5\5&\24\2\u00c5\u00c6"+
		"\7\60\2\2\u00c6\u00ce\3\2\2\2\u00c7\u00ce\7\36\2\2\u00c8\u00ce\7\37\2"+
		"\2\u00c9\u00ce\7\17\2\2\u00ca\u00ce\7\20\2\2\u00cb\u00ce\5\24\13\2\u00cc"+
		"\u00ce\7\34\2\2\u00cd\u00bf\3\2\2\2\u00cd\u00c3\3\2\2\2\u00cd\u00c7\3"+
		"\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00e1\3\2\2\2\u00cf\u00d0\f\r"+
		"\2\2\u00d0\u00d1\5 \21\2\u00d1\u00d2\5&\24\16\u00d2\u00e0\3\2\2\2\u00d3"+
		"\u00d4\f\f\2\2\u00d4\u00d5\5\"\22\2\u00d5\u00d6\5&\24\r\u00d6\u00e0\3"+
		"\2\2\2\u00d7\u00d8\f\13\2\2\u00d8\u00d9\5\36\20\2\u00d9\u00da\5&\24\f"+
		"\u00da\u00e0\3\2\2\2\u00db\u00dc\f\n\2\2\u00dc\u00dd\5\34\17\2\u00dd\u00de"+
		"\5&\24\13\u00de\u00e0\3\2\2\2\u00df\u00cf\3\2\2\2\u00df\u00d3\3\2\2\2"+
		"\u00df\u00d7\3\2\2\2\u00df\u00db\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\'\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e6\5*\26\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00e8\5,\27\2\u00e8)\3\2\2\2\u00e9\u00ea\7\27\2\2\u00ea+\3"+
		"\2\2\2\u00eb\u00f0\7\3\2\2\u00ec\u00f0\7\4\2\2\u00ed\u00f0\7\6\2\2\u00ee"+
		"\u00f0\7\t\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2"+
		"\2\2\u00ef\u00ee\3\2\2\2\u00f0-\3\2\2\2\258>BY^nu|\u0082\u0088\u00a4\u00a7"+
		"\u00b0\u00b3\u00cd\u00df\u00e1\u00e5\u00ef";
	/**
	 * The constant _ATN.
	 */
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}