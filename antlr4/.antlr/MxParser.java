// Generated from /home/chayso/code/Mx-Compiler/antlr4/MxParser.g4 by ANTLR 4.9.2
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
		Identifier=55, IntConst=56, Quote=57, StringConst=58;
	public static final int
		RULE_program = 0, RULE_basicType = 1, RULE_typename = 2, RULE_type = 3, 
		RULE_varDefUnit = 4, RULE_varDef = 5, RULE_classConstructor = 6, RULE_classDef = 7, 
		RULE_returnType = 8, RULE_parameter = 9, RULE_funcDef = 10, RULE_statement = 11, 
		RULE_suite = 12, RULE_ifStmt = 13, RULE_whileStmt = 14, RULE_forStmt = 15, 
		RULE_breakStmt = 16, RULE_continueStmt = 17, RULE_returnStmt = 18, RULE_exprStmt = 19, 
		RULE_exprList = 20, RULE_arrayDef = 21, RULE_expr = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "basicType", "typename", "type", "varDefUnit", "varDef", "classConstructor", 
			"classDef", "returnType", "parameter", "funcDef", "statement", "suite", 
			"ifStmt", "whileStmt", "forStmt", "breakStmt", "continueStmt", "returnStmt", 
			"exprStmt", "exprList", "arrayDef", "expr"
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
			null, null, null, null, null, "'\"'"
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
			"Blank", "CommentLine", "CommentPara", "Identifier", "IntConst", "Quote", 
			"StringConst"
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBasicType(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitTypename(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitVarDefUnit(this);
			else return visitor.visitChildren(this);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
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

	public static class ClassConstructorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public ClassConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classConstructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitClassConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassConstructorContext classConstructor() throws RecognitionException {
		ClassConstructorContext _localctx = new ClassConstructorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(Identifier);
			setState(87);
			match(LParen);
			setState(88);
			match(RParen);
			setState(89);
			match(LBrace);
			setState(90);
			suite();
			setState(91);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(Class);
			setState(94);
			match(Identifier);
			setState(95);
			match(LBrace);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Void) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(96);
					varDef();
					}
					break;
				case 2:
					{
					setState(97);
					classConstructor();
					}
					break;
				case 3:
					{
					setState(98);
					funcDef();
					}
					break;
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			match(RBrace);
			setState(105);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_returnType);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				type();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(111);
			type();
			setState(112);
			match(Identifier);
			}
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(114);
				match(Comma);
				setState(115);
				type();
				setState(116);
				match(Identifier);
				}
				}
				setState(122);
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
		public Token funcName;
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			returnType();
			{
			setState(124);
			((FuncDefContext)_localctx).funcName = match(Identifier);
			}
			setState(125);
			match(LParen);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(126);
				parameter();
				}
			}

			setState(129);
			match(RParen);
			setState(130);
			match(LBrace);
			setState(131);
			suite();
			setState(132);
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
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(LBrace);
				setState(135);
				suite();
				setState(136);
				match(RBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				varDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				forStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(142);
				breakStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(143);
				continueStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(144);
				returnStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(145);
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

	public static class SuiteContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << Semi) | (1L << LBrace) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				{
				setState(148);
				statement();
				}
				}
				setState(153);
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

	public static class IfStmtContext extends ParserRuleContext {
		public ExprContext condition;
		public StatementContext trueStmt;
		public StatementContext falseStmt;
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(If);
			setState(155);
			match(LParen);
			setState(156);
			((IfStmtContext)_localctx).condition = expr(0);
			setState(157);
			match(RParen);
			setState(158);
			((IfStmtContext)_localctx).trueStmt = statement();
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(159);
				match(Else);
				setState(160);
				((IfStmtContext)_localctx).falseStmt = statement();
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
		public ExprContext condition;
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(While);
			setState(164);
			match(LParen);
			setState(165);
			((WhileStmtContext)_localctx).condition = expr(0);
			setState(166);
			match(RParen);
			setState(167);
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
		public ExprStmtContext initial;
		public ExprStmtContext condition;
		public ExprContext step;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExprStmtContext> exprStmt() {
			return getRuleContexts(ExprStmtContext.class);
		}
		public ExprStmtContext exprStmt(int i) {
			return getRuleContext(ExprStmtContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(For);
			setState(170);
			match(LParen);
			setState(171);
			((ForStmtContext)_localctx).initial = exprStmt();
			setState(172);
			((ForStmtContext)_localctx).condition = exprStmt();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(173);
				((ForStmtContext)_localctx).step = expr(0);
				}
			}

			setState(176);
			match(RParen);
			setState(177);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBreakStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(Break);
			setState(180);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitContinueStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(Continue);
			setState(183);
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
		public ExprContext returnValue;
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(MxParser.Semi, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(Return);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(186);
				((ReturnStmtContext)_localctx).returnValue = expr(0);
				}
			}

			setState(189);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
				{
				setState(191);
				expr(0);
				}
			}

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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			expr(0);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(197);
				match(Comma);
				setState(198);
				expr(0);
				}
				}
				setState(203);
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

	public static class ArrayDefContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitArrayDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDefContext arrayDef() throws RecognitionException {
		ArrayDefContext _localctx = new ArrayDefContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arrayDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(LBracket);
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
	public static class FunctionExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FunctionExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitFunctionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(MxParser.SelfSub, 0); }
		public IncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitIncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExprContext {
		public ExprContext lhs;
		public Token op;
		public ExprContext rhs;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Mul() { return getToken(MxParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
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
		public BinaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExprContext extends ExprContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ArrayDefContext> arrayDef() {
			return getRuleContexts(ArrayDefContext.class);
		}
		public ArrayDefContext arrayDef(int i) {
			return getRuleContext(ArrayDefContext.class,i);
		}
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExprContext extends ExprContext {
		public TerminalNode IntConst() { return getToken(MxParser.IntConst, 0); }
		public TerminalNode StringConst() { return getToken(MxParser.StringConst, 0); }
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public TerminalNode Null() { return getToken(MxParser.Null, 0); }
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AccessArrayExprContext extends ExprContext {
		public ExprContext array;
		public ExprContext index;
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AccessArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitAccessArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedExprContext extends ExprContext {
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public NestedExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitNestedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComponentExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Component() { return getToken(MxParser.Component, 0); }
		public TerminalNode Identifier() { return getToken(MxParser.Identifier, 0); }
		public ComponentExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitComponentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfSub() { return getToken(MxParser.SelfSub, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxParser.Sub, 0); }
		public TerminalNode Not() { return getToken(MxParser.Not, 0); }
		public TerminalNode LNot() { return getToken(MxParser.LNot, 0); }
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitUnaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExprContext extends ExprContext {
		public ExprContext condition;
		public ExprContext trueExpr;
		public ExprContext falseExpr;
		public TerminalNode Question() { return getToken(MxParser.Question, 0); }
		public TerminalNode Colon() { return getToken(MxParser.Colon, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TernaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitTernaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public ExprContext lhs;
		public ExprContext rhs;
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxParserVisitor ) return ((MxParserVisitor<? extends T>)visitor).visitAssignExpr(this);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParen:
				{
				_localctx = new NestedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(211);
				match(LParen);
				setState(212);
				expr(0);
				setState(213);
				match(RParen);
				}
				break;
			case New:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(New);
				setState(216);
				type();
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(217);
						arrayDef();
						}
						} 
					}
					setState(222);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				}
				break;
			case SelfAdd:
			case SelfSub:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SelfAdd || _la==SelfSub) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(224);
				expr(17);
				}
				break;
			case Add:
			case Sub:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Add || _la==Sub) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(226);
				expr(16);
				}
				break;
			case LNot:
			case Not:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LNot || _la==Not) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(228);
				expr(15);
				}
				break;
			case Null:
			case True:
			case False:
			case IntConst:
			case StringConst:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << True) | (1L << False) | (1L << IntConst) | (1L << StringConst))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case This:
			case Identifier:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				_la = _input.LA(1);
				if ( !(_la==This || _la==Identifier) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(290);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(288);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(234);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(235);
						((BinaryExprContext)_localctx).rhs = expr(15);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(237);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(238);
						((BinaryExprContext)_localctx).rhs = expr(14);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(240);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==RShift || _la==LShift) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						((BinaryExprContext)_localctx).rhs = expr(13);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(243);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Ge) | (1L << Le) | (1L << Geq) | (1L << Leq))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						((BinaryExprContext)_localctx).rhs = expr(12);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(246);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Neq || _la==Eq) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						((BinaryExprContext)_localctx).rhs = expr(11);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(249);
						((BinaryExprContext)_localctx).op = match(And);
						setState(250);
						((BinaryExprContext)_localctx).rhs = expr(10);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(252);
						((BinaryExprContext)_localctx).op = match(Xor);
						setState(253);
						((BinaryExprContext)_localctx).rhs = expr(9);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(255);
						((BinaryExprContext)_localctx).op = match(Or);
						setState(256);
						((BinaryExprContext)_localctx).rhs = expr(8);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(258);
						((BinaryExprContext)_localctx).op = match(LAnd);
						setState(259);
						((BinaryExprContext)_localctx).rhs = expr(7);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						((BinaryExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(260);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(261);
						((BinaryExprContext)_localctx).op = match(LOr);
						setState(262);
						((BinaryExprContext)_localctx).rhs = expr(6);
						}
						break;
					case 11:
						{
						_localctx = new TernaryExprContext(new ExprContext(_parentctx, _parentState));
						((TernaryExprContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(263);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(264);
						match(Question);
						setState(265);
						((TernaryExprContext)_localctx).trueExpr = expr(0);
						setState(266);
						match(Colon);
						setState(267);
						((TernaryExprContext)_localctx).falseExpr = expr(5);
						}
						break;
					case 12:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						((AssignExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(269);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(270);
						match(Assign);
						setState(271);
						((AssignExprContext)_localctx).rhs = expr(3);
						}
						break;
					case 13:
						{
						_localctx = new ComponentExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(272);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(273);
						match(Component);
						setState(274);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new FunctionExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(275);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(276);
						match(LParen);
						setState(278);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << LNot) | (1L << Not) | (1L << SelfAdd) | (1L << SelfSub) | (1L << LParen) | (1L << New) | (1L << Null) | (1L << True) | (1L << False) | (1L << This) | (1L << Identifier) | (1L << IntConst) | (1L << StringConst))) != 0)) {
							{
							setState(277);
							exprList();
							}
						}

						setState(280);
						match(RParen);
						}
						break;
					case 15:
						{
						_localctx = new AccessArrayExprContext(new ExprContext(_parentctx, _parentState));
						((AccessArrayExprContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(281);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(282);
						match(LBracket);
						setState(283);
						((AccessArrayExprContext)_localctx).index = expr(0);
						setState(284);
						match(RBracket);
						}
						break;
					case 16:
						{
						_localctx = new IncExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(286);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(287);
						((IncExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SelfAdd || _la==SelfSub) ) {
							((IncExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
				setState(292);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 21);
		case 13:
			return precpred(_ctx, 20);
		case 14:
			return precpred(_ctx, 19);
		case 15:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3<\u0128\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\4\3\4\5\4?\n\4\3\5\3"+
		"\5\3\5\7\5D\n\5\f\5\16\5G\13\5\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\7"+
		"\7R\n\7\f\7\16\7U\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\7\tf\n\t\f\t\16\ti\13\t\3\t\3\t\3\t\3\n\3\n\5\np\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13y\n\13\f\13\16\13|\13\13\3\f\3\f\3"+
		"\f\3\f\5\f\u0082\n\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0095\n\r\3\16\7\16\u0098\n\16\f\16\16\16\u009b"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a4\n\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21\u00b1\n\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\5\24\u00be\n\24\3\24\3\24"+
		"\3\25\5\25\u00c3\n\25\3\25\3\25\3\26\3\26\3\26\7\26\u00ca\n\26\f\26\16"+
		"\26\u00cd\13\26\3\27\3\27\5\27\u00d1\n\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\7\30\u00dd\n\30\f\30\16\30\u00e0\13\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00ea\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0119"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0123\n\30\f\30\16"+
		"\30\u0126\13\30\3\30\2\3.\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\2\f\3\2&(\3\2\30\31\3\2\3\4\4\2\20\20\26\26\5\2+-::<<\4\2..99\3"+
		"\2\5\7\3\2\21\22\3\2\b\13\3\2\f\r\2\u0144\2\65\3\2\2\2\4:\3\2\2\2\6>\3"+
		"\2\2\2\b@\3\2\2\2\nH\3\2\2\2\fM\3\2\2\2\16X\3\2\2\2\20_\3\2\2\2\22o\3"+
		"\2\2\2\24q\3\2\2\2\26}\3\2\2\2\30\u0094\3\2\2\2\32\u0099\3\2\2\2\34\u009c"+
		"\3\2\2\2\36\u00a5\3\2\2\2 \u00ab\3\2\2\2\"\u00b5\3\2\2\2$\u00b8\3\2\2"+
		"\2&\u00bb\3\2\2\2(\u00c2\3\2\2\2*\u00c6\3\2\2\2,\u00ce\3\2\2\2.\u00e9"+
		"\3\2\2\2\60\64\5\26\f\2\61\64\5\20\t\2\62\64\5\f\7\2\63\60\3\2\2\2\63"+
		"\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66"+
		"8\3\2\2\2\67\65\3\2\2\289\7\2\2\39\3\3\2\2\2:;\t\2\2\2;\5\3\2\2\2<?\5"+
		"\4\3\2=?\79\2\2><\3\2\2\2>=\3\2\2\2?\7\3\2\2\2@E\5\6\4\2AB\7\33\2\2BD"+
		"\7\34\2\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GE\3\2\2\2"+
		"HK\79\2\2IJ\7\27\2\2JL\5.\30\2KI\3\2\2\2KL\3\2\2\2L\13\3\2\2\2MN\5\b\5"+
		"\2NS\5\n\6\2OP\7\"\2\2PR\5\n\6\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2"+
		"\2TV\3\2\2\2US\3\2\2\2VW\7!\2\2W\r\3\2\2\2XY\79\2\2YZ\7\35\2\2Z[\7\36"+
		"\2\2[\\\7#\2\2\\]\5\32\16\2]^\7$\2\2^\17\3\2\2\2_`\7*\2\2`a\79\2\2ag\7"+
		"#\2\2bf\5\f\7\2cf\5\16\b\2df\5\26\f\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2fi"+
		"\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7$\2\2kl\7!\2\2l\21"+
		"\3\2\2\2mp\5\b\5\2np\7%\2\2om\3\2\2\2on\3\2\2\2p\23\3\2\2\2qr\5\b\5\2"+
		"rs\79\2\2sz\3\2\2\2tu\7\"\2\2uv\5\b\5\2vw\79\2\2wy\3\2\2\2xt\3\2\2\2y"+
		"|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\25\3\2\2\2|z\3\2\2\2}~\5\22\n\2~\177\7"+
		"9\2\2\177\u0081\7\35\2\2\u0080\u0082\5\24\13\2\u0081\u0080\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\36\2\2\u0084\u0085\7"+
		"#\2\2\u0085\u0086\5\32\16\2\u0086\u0087\7$\2\2\u0087\27\3\2\2\2\u0088"+
		"\u0089\7#\2\2\u0089\u008a\5\32\16\2\u008a\u008b\7$\2\2\u008b\u0095\3\2"+
		"\2\2\u008c\u0095\5\f\7\2\u008d\u0095\5\34\17\2\u008e\u0095\5\36\20\2\u008f"+
		"\u0095\5 \21\2\u0090\u0095\5\"\22\2\u0091\u0095\5$\23\2\u0092\u0095\5"+
		"&\24\2\u0093\u0095\5(\25\2\u0094\u0088\3\2\2\2\u0094\u008c\3\2\2\2\u0094"+
		"\u008d\3\2\2\2\u0094\u008e\3\2\2\2\u0094\u008f\3\2\2\2\u0094\u0090\3\2"+
		"\2\2\u0094\u0091\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095"+
		"\31\3\2\2\2\u0096\u0098\5\30\r\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2"+
		"\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\33\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009c\u009d\7/\2\2\u009d\u009e\7\35\2\2\u009e\u009f\5.\30\2\u009f"+
		"\u00a0\7\36\2\2\u00a0\u00a3\5\30\r\2\u00a1\u00a2\7\60\2\2\u00a2\u00a4"+
		"\5\30\r\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\35\3\2\2\2\u00a5"+
		"\u00a6\7\62\2\2\u00a6\u00a7\7\35\2\2\u00a7\u00a8\5.\30\2\u00a8\u00a9\7"+
		"\36\2\2\u00a9\u00aa\5\30\r\2\u00aa\37\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac"+
		"\u00ad\7\35\2\2\u00ad\u00ae\5(\25\2\u00ae\u00b0\5(\25\2\u00af\u00b1\5"+
		".\30\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\7\36\2\2\u00b3\u00b4\5\30\r\2\u00b4!\3\2\2\2\u00b5\u00b6\7\63\2"+
		"\2\u00b6\u00b7\7!\2\2\u00b7#\3\2\2\2\u00b8\u00b9\7\64\2\2\u00b9\u00ba"+
		"\7!\2\2\u00ba%\3\2\2\2\u00bb\u00bd\7\65\2\2\u00bc\u00be\5.\30\2\u00bd"+
		"\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7!"+
		"\2\2\u00c0\'\3\2\2\2\u00c1\u00c3\5.\30\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7!\2\2\u00c5)\3\2\2\2\u00c6\u00cb"+
		"\5.\30\2\u00c7\u00c8\7\"\2\2\u00c8\u00ca\5.\30\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc+\3\2\2\2"+
		"\u00cd\u00cb\3\2\2\2\u00ce\u00d0\7\33\2\2\u00cf\u00d1\5.\30\2\u00d0\u00cf"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\7\34\2\2"+
		"\u00d3-\3\2\2\2\u00d4\u00d5\b\30\1\2\u00d5\u00d6\7\35\2\2\u00d6\u00d7"+
		"\5.\30\2\u00d7\u00d8\7\36\2\2\u00d8\u00ea\3\2\2\2\u00d9\u00da\7)\2\2\u00da"+
		"\u00de\5\b\5\2\u00db\u00dd\5,\27\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2"+
		"\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00ea\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e1\u00e2\t\3\2\2\u00e2\u00ea\5.\30\23\u00e3\u00e4\t"+
		"\4\2\2\u00e4\u00ea\5.\30\22\u00e5\u00e6\t\5\2\2\u00e6\u00ea\5.\30\21\u00e7"+
		"\u00ea\t\6\2\2\u00e8\u00ea\t\7\2\2\u00e9\u00d4\3\2\2\2\u00e9\u00d9\3\2"+
		"\2\2\u00e9\u00e1\3\2\2\2\u00e9\u00e3\3\2\2\2\u00e9\u00e5\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u0124\3\2\2\2\u00eb\u00ec\f\20"+
		"\2\2\u00ec\u00ed\t\b\2\2\u00ed\u0123\5.\30\21\u00ee\u00ef\f\17\2\2\u00ef"+
		"\u00f0\t\4\2\2\u00f0\u0123\5.\30\20\u00f1\u00f2\f\16\2\2\u00f2\u00f3\t"+
		"\t\2\2\u00f3\u0123\5.\30\17\u00f4\u00f5\f\r\2\2\u00f5\u00f6\t\n\2\2\u00f6"+
		"\u0123\5.\30\16\u00f7\u00f8\f\f\2\2\u00f8\u00f9\t\13\2\2\u00f9\u0123\5"+
		".\30\r\u00fa\u00fb\f\13\2\2\u00fb\u00fc\7\23\2\2\u00fc\u0123\5.\30\f\u00fd"+
		"\u00fe\f\n\2\2\u00fe\u00ff\7\25\2\2\u00ff\u0123\5.\30\13\u0100\u0101\f"+
		"\t\2\2\u0101\u0102\7\24\2\2\u0102\u0123\5.\30\n\u0103\u0104\f\b\2\2\u0104"+
		"\u0105\7\16\2\2\u0105\u0123\5.\30\t\u0106\u0107\f\7\2\2\u0107\u0108\7"+
		"\17\2\2\u0108\u0123\5.\30\b\u0109\u010a\f\6\2\2\u010a\u010b\7\37\2\2\u010b"+
		"\u010c\5.\30\2\u010c\u010d\7 \2\2\u010d\u010e\5.\30\7\u010e\u0123\3\2"+
		"\2\2\u010f\u0110\f\5\2\2\u0110\u0111\7\27\2\2\u0111\u0123\5.\30\5\u0112"+
		"\u0113\f\27\2\2\u0113\u0114\7\32\2\2\u0114\u0123\79\2\2\u0115\u0116\f"+
		"\26\2\2\u0116\u0118\7\35\2\2\u0117\u0119\5*\26\2\u0118\u0117\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0123\7\36\2\2\u011b\u011c\f"+
		"\25\2\2\u011c\u011d\7\33\2\2\u011d\u011e\5.\30\2\u011e\u011f\7\34\2\2"+
		"\u011f\u0123\3\2\2\2\u0120\u0121\f\24\2\2\u0121\u0123\t\3\2\2\u0122\u00eb"+
		"\3\2\2\2\u0122\u00ee\3\2\2\2\u0122\u00f1\3\2\2\2\u0122\u00f4\3\2\2\2\u0122"+
		"\u00f7\3\2\2\2\u0122\u00fa\3\2\2\2\u0122\u00fd\3\2\2\2\u0122\u0100\3\2"+
		"\2\2\u0122\u0103\3\2\2\2\u0122\u0106\3\2\2\2\u0122\u0109\3\2\2\2\u0122"+
		"\u010f\3\2\2\2\u0122\u0112\3\2\2\2\u0122\u0115\3\2\2\2\u0122\u011b\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125/\3\2\2\2\u0126\u0124\3\2\2\2\32\63\65>EKSegoz\u0081"+
		"\u0094\u0099\u00a3\u00b0\u00bd\u00c2\u00cb\u00d0\u00de\u00e9\u0118\u0122"+
		"\u0124";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}