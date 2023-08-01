// Generated from /home/chayso/code/Mx-Compiler/src/antlr4/MxParser.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Add=1, Sub=2, Mul=3, Div=4, Mod=5, Ge=6, Le=7, Geq=8, Leq=9, Neq=10, Eq=11, 
		LAnd=12, LOr=13, LNot=14, RShift=15, LShift=16, And=17, Or=18, Xor=19, 
		Not=20, Assign=21, SelfAdd=22, SelfSub=23, Component=24, LBracket=25, 
		RBracket=26, LParen=27, RParen=28, Question=29, Colon=30, Semi=31, Comma=32, 
		LBrace=33, RBrace=34, Void=35, Bool=36, Int=37, String=38, New=39, Class=40, 
		Null=41, True=42, False=43, This=44, If=45, Else=46, For=47, While=48, 
		Break=49, Continue=50, Return=51, Blank=52, CommentLine=53, CommentPara=54, 
		Identifier=55, Const=56, IntConst=57, Quote=58, StringConst=59;
	public static final int
		RULE_program = 0, RULE_basicType = 1, RULE_typename = 2, RULE_type = 3, 
		RULE_varDefUnit = 4, RULE_varDef = 5, RULE_arrayDefUnit = 6, RULE_classConstructor = 7, 
		RULE_classDef = 8, RULE_returnType = 9, RULE_parameter = 10, RULE_funcDef = 11, 
		RULE_statement = 12, RULE_ifStmt = 13, RULE_whileStmt = 14, RULE_forStmt = 15, 
		RULE_breakStmt = 16, RULE_continueStmt = 17, RULE_returnStmt = 18, RULE_exprStmt = 19, 
		RULE_exprList = 20, RULE_expr = 21, RULE_basicExpr = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "basicType", "typename", "type", "varDefUnit", "varDef", "arrayDefUnit", 
			"classConstructor", "classDef", "returnType", "parameter", "funcDef", 
			"statement", "ifStmt", "whileStmt", "forStmt", "breakStmt", "continueStmt", 
			"returnStmt", "exprStmt", "exprList", "expr", "basicExpr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", "'<'", "'>='", "'<='", 
			"'!='", "'=='", "'&&'", "'||'", "'!'", "'>>'", "'<<'", "'&'", "'|'", 
			"'^'", "'~'", "'='", "'++'", "'--'", "'.'", "'['", "']'", "'('", "')'", 
			"'?'", "':'", "';'", "','", "'{'", "'}'", "'void'", "'bool'", "'int'", 
			"'string'", "'new'", "'class'", "'null'", "'true'", "'false'", "'this'", 
			"'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", 
			null, null, null, null, "'const'", null, "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Add", "Sub", "Mul", "Div", "Mod", "Ge", "Le", "Geq", "Leq", "Neq", 
			"Eq", "LAnd", "LOr", "LNot", "RShift", "LShift", "And", "Or", "Xor", 
			"Not", "Assign", "SelfAdd", "SelfSub", "Component", "LBracket", "RBracket", 
			"LParen", "RParen", "Question", "Colon", "Semi", "Comma", "LBrace", "RBrace", 
			"Void", "Bool", "Int", "String", "New", "Class", "Null", "True", "False", 
			"This", "If", "Else", "For", "While", "Break", "Continue", "Return", 
			"Blank", "CommentLine", "CommentPara", "Identifier", "Const", "IntConst", 
			"Quote", "StringConst"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "MxParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(46);
					funcDef();
					}
					break;
				case 2:
					{
					setState(47);
					classDef();
					}
					break;
				case 3:
					{
					setState(48);
					varDef();
					}
					break;
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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

	public static class BasicTypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(MxParser.Int, 0); }
		public TerminalNode Bool() { return getToken(MxParser.Bool, 0); }
		public TerminalNode String() { return getToken(MxParser.String, 0); }
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class TypenameContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TypenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typename; }
	}

	public final TypenameContext typename() throws RecognitionException {
		TypenameContext _localctx = new TypenameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typename);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				basicType();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(Identifier);
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

	public static class TypeContext extends ParserRuleContext {
		public TypenameContext typename() {
			return getRuleContext(TypenameContext.class,0);
		}
		public List<TerminalNode> LBracket() { return getTokens(MxParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(MxParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParser.RBracket, i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			typename();
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(63);
					match(LBracket);
					setState(64);
					match(RBracket);
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class VarDefUnitContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDefUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefUnit; }
	}

	public final VarDefUnitContext varDefUnit() throws RecognitionException {
		VarDefUnitContext _localctx = new VarDefUnitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDefUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(Identifier);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(71);
				match(Assign);
				setState(72);
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

	public static class VarDefContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VarDefUnitContext> varDefUnit() {
			return getRuleContexts(VarDefUnitContext.class);
		}
		public VarDefUnitContext varDefUnit(int i) {
			return getRuleContext(VarDefUnitContext.class,i);
		}
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			type();
			setState(76);
			varDefUnit();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(77);
				match(Comma);
				setState(78);
				varDefUnit();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(Semi);
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

	public static class ArrayDefUnitContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayDefUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDefUnit; }
	}

	public final ArrayDefUnitContext arrayDefUnit() throws RecognitionException {
		ArrayDefUnitContext _localctx = new ArrayDefUnitContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrayDefUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(LBracket);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(87);
				expr(0);
				}
			}

			setState(90);
			match(RBracket);
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

	public static class ClassConstructorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ClassConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classConstructor; }
	}

	public final ClassConstructorContext classConstructor() throws RecognitionException {
		ClassConstructorContext _localctx = new ClassConstructorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(Identifier);
			setState(93);
			match(LParen);
			setState(94);
			match(RParen);
			setState(95);
			match(LBrace);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << Semi) | (1L << LBrace) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(96);
				statement();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(RBrace);
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

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<ClassConstructorContext> classConstructor() {
			return getRuleContexts(ClassConstructorContext.class);
		}
		public ClassConstructorContext classConstructor(int i) {
			return getRuleContext(ClassConstructorContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(Class);
			setState(105);
			match(Identifier);
			setState(106);
			match(LBrace);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(110);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(107);
					varDef();
					}
					break;
				case 2:
					{
					setState(108);
					classConstructor();
					}
					break;
				case 3:
					{
					setState(109);
					funcDef();
					}
					break;
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			match(RBrace);
			setState(116);
			match(Semi);
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

	public static class ReturnTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Void() { return getToken(MxParser.Void, 0); }
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_returnType);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				type();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(Void);
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

	public static class ParameterContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(122);
			type();
			setState(123);
			match(Identifier);
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(125);
				match(Comma);
				setState(126);
				type();
				setState(127);
				match(Identifier);
				}
				}
				setState(133);
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

	public static class FuncDefContext extends ParserRuleContext {
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			returnType();
			setState(135);
			match(Identifier);
			setState(136);
			match(LParen);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(137);
				parameter();
				}
			}

			setState(140);
			match(RParen);
			setState(141);
			match(LBrace);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << Semi) | (1L << LBrace) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(142);
				statement();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			match(RBrace);
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
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		int _la;
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(LBrace);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << Semi) | (1L << LBrace) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
					{
					{
					setState(151);
					statement();
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(157);
				match(RBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				varDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(161);
				forStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
				breakStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(163);
				continueStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(164);
				returnStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(165);
				exprStmt();
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

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(If);
			setState(169);
			match(LParen);
			setState(170);
			expr(0);
			setState(171);
			match(RParen);
			setState(172);
			statement();
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(173);
				match(Else);
				setState(174);
				statement();
				}
				break;
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(While);
			setState(178);
			match(LParen);
			setState(179);
			expr(0);
			setState(180);
			match(RParen);
			setState(181);
			statement();
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public List<ExprStmtContext> exprStmt() {
			return getRuleContexts(ExprStmtContext.class);
		}
		public ExprStmtContext exprStmt(int i) {
			return getRuleContext(ExprStmtContext.class,i);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(For);
			setState(184);
			match(LParen);
			setState(185);
			exprStmt();
			setState(186);
			exprStmt();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(187);
				expr(0);
				}
			}

			setState(190);
			match(RParen);
			setState(191);
			statement();
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

	public static class BreakStmtContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(Break);
			setState(194);
			match(Semi);
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

	public static class ContinueStmtContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(Continue);
			setState(197);
			match(Semi);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(Return);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(200);
				expr(0);
				}
			}

			setState(203);
			match(Semi);
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

	public static class ExprStmtContext extends ParserRuleContext {
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(205);
				expr(0);
				}
			}

			setState(208);
			match(Semi);
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

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			expr(0);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(211);
				match(Comma);
				setState(212);
				expr(0);
				}
				}
				setState(217);
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

	public static class ExprContext extends ParserRuleContext {
		public Token op;
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ArrayDefUnitContext> arrayDefUnit() {
			return getRuleContexts(ArrayDefUnitContext.class);
		}
		public ArrayDefUnitContext arrayDefUnit(int i) {
			return getRuleContext(ArrayDefUnitContext.class,i);
		}
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(MxParser.SelfSub, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode LNot() { return getToken(MxParser.LNot, 0); }
		public BasicExprContext basicExpr() {
			return getRuleContext(BasicExprContext.class,0);
		}
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode LShift() { return getToken(MxParser.LShift, 0); }
		public TerminalNode RShift() { return getToken(MxParser.RShift, 0); }
		public TerminalNode Ge() { return getToken(MxParser.Ge, 0); }
		public TerminalNode Le() { return getToken(MxParser.Le, 0); }
		public TerminalNode Geq() { return getToken(MxParser.Geq, 0); }
		public TerminalNode Leq() { return getToken(MxParser.Leq, 0); }
		public TerminalNode Eq() { return getToken(MxParser.Eq, 0); }
		public TerminalNode Neq() { return getToken(MxParser.Neq, 0); }
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public TerminalNode Xor() { return getToken(MxParser.Xor, 0); }
		public TerminalNode Or() { return getToken(MxParser.Or, 0); }
		public TerminalNode LAnd() { return getToken(MxParser.LAnd, 0); }
		public TerminalNode LOr() { return getToken(MxParser.LOr, 0); }
		public TerminalNode Question() { return getToken(MxParser.Question, 0); }
		public TerminalNode Colon() { return getToken(MxParser.Colon, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public TerminalNode Component() { return getToken(MxParser.Component, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParen:
				{
				setState(219);
				match(LParen);
				setState(220);
				expr(0);
				setState(221);
				match(RParen);
				}
				break;
			case New:
				{
				setState(223);
				match(New);
				setState(224);
				type();
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(225);
						arrayDefUnit();
						}
						} 
					}
					setState(230);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				setState(233);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(231);
					match(LParen);
					setState(232);
					match(RParen);
					}
					break;
				}
				}
				break;
			case SelfAdd:
			case SelfSub:
				{
				setState(235);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfAdd || _la==SelfSub) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(236);
				expr(16);
				}
				break;
			case Add:
			case Sub:
				{
				setState(237);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Add || _la==Sub) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(238);
				expr(15);
				}
				break;
			case LNot:
			case Not:
				{
				setState(239);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LNot || _la==Not) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				expr(14);
				}
				break;
			case Null:
			case True:
			case False:
			case This:
			case Identifier:
			case IntConst:
			case StringConst:
				{
				setState(241);
				basicExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(299);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(245);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(246);
						expr(14);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(248);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						expr(13);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(251);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==RShift || _la==LShift) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(252);
						expr(12);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(254);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Ge) | (1L << Le) | (1L << Geq) | (1L << Leq))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(255);
						expr(11);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(257);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Neq || _la==Eq) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(258);
						expr(10);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(260);
						((ExprContext)_localctx).op = match(And);
						setState(261);
						expr(9);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(263);
						((ExprContext)_localctx).op = match(Xor);
						setState(264);
						expr(8);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(266);
						((ExprContext)_localctx).op = match(Or);
						setState(267);
						expr(7);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(269);
						((ExprContext)_localctx).op = match(LAnd);
						setState(270);
						expr(6);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(272);
						((ExprContext)_localctx).op = match(LOr);
						setState(273);
						expr(5);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(275);
						match(Question);
						setState(276);
						expr(0);
						setState(277);
						match(Colon);
						setState(278);
						expr(4);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(280);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(281);
						((ExprContext)_localctx).op = match(Assign);
						setState(282);
						expr(2);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(283);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(284);
						match(Component);
						setState(285);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(286);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(287);
						match(LParen);
						setState(289);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
							{
							setState(288);
							exprList();
							}
						}

						setState(291);
						match(RParen);
						}
						break;
					case 15:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(292);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(293);
						match(LBracket);
						setState(294);
						expr(0);
						setState(295);
						match(RBracket);
						}
						break;
					case 16:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(298);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfAdd || _la==SelfSub) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class BasicExprContext extends ParserRuleContext {
		public TerminalNode IntConst() { return getToken(MxParser.IntConst, 0); }
		public TerminalNode StringConst() { return getToken(MxParser.StringConst, 0); }
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public TerminalNode Null() { return getToken(MxParser.Null, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public BasicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicExpr; }
	}

	public final BasicExprContext basicExpr() throws RecognitionException {
		BasicExprContext _localctx = new BasicExprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_basicExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 20);
		case 13:
			return precpred(_ctx, 19);
		case 14:
			return precpred(_ctx, 18);
		case 15:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u0135\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\4\3\4\5\4?\n\4\3\5\3"+
		"\5\3\5\7\5D\n\5\f\5\16\5G\13\5\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\7"+
		"\7R\n\7\f\7\16\7U\13\7\3\7\3\7\3\b\3\b\5\b[\n\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\7\td\n\t\f\t\16\tg\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\nq\n"+
		"\n\f\n\16\nt\13\n\3\n\3\n\3\n\3\13\3\13\5\13{\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u0084\n\f\f\f\16\f\u0087\13\f\3\r\3\r\3\r\3\r\5\r\u008d\n"+
		"\r\3\r\3\r\3\r\7\r\u0092\n\r\f\r\16\r\u0095\13\r\3\r\3\r\3\16\3\16\7\16"+
		"\u009b\n\16\f\16\16\16\u009e\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00a9\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b2"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21\u00bf"+
		"\n\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\5\24\u00cc"+
		"\n\24\3\24\3\24\3\25\5\25\u00d1\n\25\3\25\3\25\3\26\3\26\3\26\7\26\u00d8"+
		"\n\26\f\26\16\26\u00db\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7"+
		"\27\u00e5\n\27\f\27\16\27\u00e8\13\27\3\27\3\27\5\27\u00ec\n\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\5\27\u00f5\n\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0124"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u012e\n\27\f\27\16"+
		"\27\u0131\13\27\3\30\3\30\3\30\2\3,\31\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\2\13\3\2&(\3\2\30\31\3\2\3\4\4\2\20\20\26\26\3\2\5\7\3"+
		"\2\21\22\3\2\b\13\3\2\f\r\6\2+.99;;==\2\u0153\2\65\3\2\2\2\4:\3\2\2\2"+
		"\6>\3\2\2\2\b@\3\2\2\2\nH\3\2\2\2\fM\3\2\2\2\16X\3\2\2\2\20^\3\2\2\2\22"+
		"j\3\2\2\2\24z\3\2\2\2\26|\3\2\2\2\30\u0088\3\2\2\2\32\u00a8\3\2\2\2\34"+
		"\u00aa\3\2\2\2\36\u00b3\3\2\2\2 \u00b9\3\2\2\2\"\u00c3\3\2\2\2$\u00c6"+
		"\3\2\2\2&\u00c9\3\2\2\2(\u00d0\3\2\2\2*\u00d4\3\2\2\2,\u00f4\3\2\2\2."+
		"\u0132\3\2\2\2\60\64\5\30\r\2\61\64\5\22\n\2\62\64\5\f\7\2\63\60\3\2\2"+
		"\2\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2"+
		"\2\668\3\2\2\2\67\65\3\2\2\289\7\2\2\39\3\3\2\2\2:;\t\2\2\2;\5\3\2\2\2"+
		"<?\5\4\3\2=?\79\2\2><\3\2\2\2>=\3\2\2\2?\7\3\2\2\2@E\5\6\4\2AB\7\33\2"+
		"\2BD\7\34\2\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GE\3\2"+
		"\2\2HK\79\2\2IJ\7\27\2\2JL\5,\27\2KI\3\2\2\2KL\3\2\2\2L\13\3\2\2\2MN\5"+
		"\b\5\2NS\5\n\6\2OP\7\"\2\2PR\5\n\6\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3"+
		"\2\2\2TV\3\2\2\2US\3\2\2\2VW\7!\2\2W\r\3\2\2\2XZ\7\33\2\2Y[\5,\27\2ZY"+
		"\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\34\2\2]\17\3\2\2\2^_\79\2\2_`\7\35"+
		"\2\2`a\7\36\2\2ae\7#\2\2bd\5\32\16\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3"+
		"\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7$\2\2i\21\3\2\2\2jk\7*\2\2kl\79\2\2lr\7"+
		"#\2\2mq\5\f\7\2nq\5\20\t\2oq\5\30\r\2pm\3\2\2\2pn\3\2\2\2po\3\2\2\2qt"+
		"\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7$\2\2vw\7!\2\2w\23"+
		"\3\2\2\2x{\5\b\5\2y{\7%\2\2zx\3\2\2\2zy\3\2\2\2{\25\3\2\2\2|}\5\b\5\2"+
		"}~\79\2\2~\u0085\3\2\2\2\177\u0080\7\"\2\2\u0080\u0081\5\b\5\2\u0081\u0082"+
		"\79\2\2\u0082\u0084\3\2\2\2\u0083\177\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\27\3\2\2\2\u0087\u0085\3\2\2"+
		"\2\u0088\u0089\5\24\13\2\u0089\u008a\79\2\2\u008a\u008c\7\35\2\2\u008b"+
		"\u008d\5\26\f\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\7\36\2\2\u008f\u0093\7#\2\2\u0090\u0092\5\32\16\2\u0091"+
		"\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7$\2\2\u0097"+
		"\31\3\2\2\2\u0098\u009c\7#\2\2\u0099\u009b\5\32\16\2\u009a\u0099\3\2\2"+
		"\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f"+
		"\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a9\7$\2\2\u00a0\u00a9\5\f\7\2\u00a1"+
		"\u00a9\5\34\17\2\u00a2\u00a9\5\36\20\2\u00a3\u00a9\5 \21\2\u00a4\u00a9"+
		"\5\"\22\2\u00a5\u00a9\5$\23\2\u00a6\u00a9\5&\24\2\u00a7\u00a9\5(\25\2"+
		"\u00a8\u0098\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8\u00a2"+
		"\3\2\2\2\u00a8\u00a3\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\33\3\2\2\2\u00aa\u00ab\7/\2\2"+
		"\u00ab\u00ac\7\35\2\2\u00ac\u00ad\5,\27\2\u00ad\u00ae\7\36\2\2\u00ae\u00b1"+
		"\5\32\16\2\u00af\u00b0\7\60\2\2\u00b0\u00b2\5\32\16\2\u00b1\u00af\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\35\3\2\2\2\u00b3\u00b4\7\62\2\2\u00b4\u00b5"+
		"\7\35\2\2\u00b5\u00b6\5,\27\2\u00b6\u00b7\7\36\2\2\u00b7\u00b8\5\32\16"+
		"\2\u00b8\37\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00bb\7\35\2\2\u00bb\u00bc"+
		"\5(\25\2\u00bc\u00be\5(\25\2\u00bd\u00bf\5,\27\2\u00be\u00bd\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\36\2\2\u00c1\u00c2\5"+
		"\32\16\2\u00c2!\3\2\2\2\u00c3\u00c4\7\63\2\2\u00c4\u00c5\7!\2\2\u00c5"+
		"#\3\2\2\2\u00c6\u00c7\7\64\2\2\u00c7\u00c8\7!\2\2\u00c8%\3\2\2\2\u00c9"+
		"\u00cb\7\65\2\2\u00ca\u00cc\5,\27\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3"+
		"\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7!\2\2\u00ce\'\3\2\2\2\u00cf\u00d1"+
		"\5,\27\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\7!\2\2\u00d3)\3\2\2\2\u00d4\u00d9\5,\27\2\u00d5\u00d6\7\"\2\2\u00d6"+
		"\u00d8\5,\27\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2"+
		"\2\2\u00d9\u00da\3\2\2\2\u00da+\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd"+
		"\b\27\1\2\u00dd\u00de\7\35\2\2\u00de\u00df\5,\27\2\u00df\u00e0\7\36\2"+
		"\2\u00e0\u00f5\3\2\2\2\u00e1\u00e2\7)\2\2\u00e2\u00e6\5\b\5\2\u00e3\u00e5"+
		"\5\16\b\2\u00e4\u00e3\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2"+
		"\u00e6\u00e7\3\2\2\2\u00e7\u00eb\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea"+
		"\7\35\2\2\u00ea\u00ec\7\36\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2"+
		"\u00ec\u00f5\3\2\2\2\u00ed\u00ee\t\3\2\2\u00ee\u00f5\5,\27\22\u00ef\u00f0"+
		"\t\4\2\2\u00f0\u00f5\5,\27\21\u00f1\u00f2\t\5\2\2\u00f2\u00f5\5,\27\20"+
		"\u00f3\u00f5\5.\30\2\u00f4\u00dc\3\2\2\2\u00f4\u00e1\3\2\2\2\u00f4\u00ed"+
		"\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5"+
		"\u012f\3\2\2\2\u00f6\u00f7\f\17\2\2\u00f7\u00f8\t\6\2\2\u00f8\u012e\5"+
		",\27\20\u00f9\u00fa\f\16\2\2\u00fa\u00fb\t\4\2\2\u00fb\u012e\5,\27\17"+
		"\u00fc\u00fd\f\r\2\2\u00fd\u00fe\t\7\2\2\u00fe\u012e\5,\27\16\u00ff\u0100"+
		"\f\f\2\2\u0100\u0101\t\b\2\2\u0101\u012e\5,\27\r\u0102\u0103\f\13\2\2"+
		"\u0103\u0104\t\t\2\2\u0104\u012e\5,\27\f\u0105\u0106\f\n\2\2\u0106\u0107"+
		"\7\23\2\2\u0107\u012e\5,\27\13\u0108\u0109\f\t\2\2\u0109\u010a\7\25\2"+
		"\2\u010a\u012e\5,\27\n\u010b\u010c\f\b\2\2\u010c\u010d\7\24\2\2\u010d"+
		"\u012e\5,\27\t\u010e\u010f\f\7\2\2\u010f\u0110\7\16\2\2\u0110\u012e\5"+
		",\27\b\u0111\u0112\f\6\2\2\u0112\u0113\7\17\2\2\u0113\u012e\5,\27\7\u0114"+
		"\u0115\f\5\2\2\u0115\u0116\7\37\2\2\u0116\u0117\5,\27\2\u0117\u0118\7"+
		" \2\2\u0118\u0119\5,\27\6\u0119\u012e\3\2\2\2\u011a\u011b\f\4\2\2\u011b"+
		"\u011c\7\27\2\2\u011c\u012e\5,\27\4\u011d\u011e\f\26\2\2\u011e\u011f\7"+
		"\32\2\2\u011f\u012e\79\2\2\u0120\u0121\f\25\2\2\u0121\u0123\7\35\2\2\u0122"+
		"\u0124\5*\26\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u012e\7\36\2\2\u0126\u0127\f\24\2\2\u0127\u0128\7\33\2\2\u0128"+
		"\u0129\5,\27\2\u0129\u012a\7\34\2\2\u012a\u012e\3\2\2\2\u012b\u012c\f"+
		"\23\2\2\u012c\u012e\t\3\2\2\u012d\u00f6\3\2\2\2\u012d\u00f9\3\2\2\2\u012d"+
		"\u00fc\3\2\2\2\u012d\u00ff\3\2\2\2\u012d\u0102\3\2\2\2\u012d\u0105\3\2"+
		"\2\2\u012d\u0108\3\2\2\2\u012d\u010b\3\2\2\2\u012d\u010e\3\2\2\2\u012d"+
		"\u0111\3\2\2\2\u012d\u0114\3\2\2\2\u012d\u011a\3\2\2\2\u012d\u011d\3\2"+
		"\2\2\u012d\u0120\3\2\2\2\u012d\u0126\3\2\2\2\u012d\u012b\3\2\2\2\u012e"+
		"\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130-\3\2\2\2"+
		"\u0131\u012f\3\2\2\2\u0132\u0133\t\n\2\2\u0133/\3\2\2\2\35\63\65>EKSZ"+
		"eprz\u0085\u008c\u0093\u009c\u00a8\u00b1\u00be\u00cb\u00d0\u00d9\u00e6"+
		"\u00eb\u00f4\u0123\u012d\u012f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}