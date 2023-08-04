// Generated from /home/chayso/code/Mx-Compiler/antlr4/MxLexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Add", "Sub", "Mul", "Div", "Mod", "Ge", "Le", "Geq", "Leq", "Neq", "Eq", 
			"LAnd", "LOr", "LNot", "RShift", "LShift", "And", "Or", "Xor", "Not", 
			"Assign", "SelfAdd", "SelfSub", "Component", "LBracket", "RBracket", 
			"LParen", "RParen", "Question", "Colon", "Semi", "Comma", "LBrace", "RBrace", 
			"Void", "Bool", "Int", "String", "New", "Class", "Null", "True", "False", 
			"This", "If", "Else", "For", "While", "Break", "Continue", "Return", 
			"Blank", "CommentLine", "CommentPara", "Identifier", "IntConst", "Quote", 
			"StringConst"
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


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2<\u0163\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3"+
		"$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3"+
		"(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3"+
		"-\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\6\65\u0123"+
		"\n\65\r\65\16\65\u0124\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u012d\n\66\f"+
		"\66\16\66\u0130\13\66\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u0138\n\67\f"+
		"\67\16\67\u013b\13\67\3\67\3\67\3\67\3\67\3\67\38\38\78\u0144\n8\f8\16"+
		"8\u0147\138\39\39\79\u014b\n9\f9\169\u014e\139\39\59\u0151\n9\3:\3:\3"+
		";\3;\3;\3;\3;\3;\3;\3;\7;\u015d\n;\f;\16;\u0160\13;\3;\3;\4\u0139\u015e"+
		"\2<\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<\3\2\t\5\2\13\f\17\17\"\"\4\2\f\f\17\17\4\2C\\c|\6\2\62;C\\"+
		"aac|\3\2\63;\3\2\62;\3\2\"\u0080\2\u016c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3"+
		"\2\2\2\2u\3\2\2\2\3w\3\2\2\2\5y\3\2\2\2\7{\3\2\2\2\t}\3\2\2\2\13\177\3"+
		"\2\2\2\r\u0081\3\2\2\2\17\u0083\3\2\2\2\21\u0085\3\2\2\2\23\u0088\3\2"+
		"\2\2\25\u008b\3\2\2\2\27\u008e\3\2\2\2\31\u0091\3\2\2\2\33\u0094\3\2\2"+
		"\2\35\u0097\3\2\2\2\37\u0099\3\2\2\2!\u009c\3\2\2\2#\u009f\3\2\2\2%\u00a1"+
		"\3\2\2\2\'\u00a3\3\2\2\2)\u00a5\3\2\2\2+\u00a7\3\2\2\2-\u00a9\3\2\2\2"+
		"/\u00ac\3\2\2\2\61\u00af\3\2\2\2\63\u00b1\3\2\2\2\65\u00b3\3\2\2\2\67"+
		"\u00b5\3\2\2\29\u00b7\3\2\2\2;\u00b9\3\2\2\2=\u00bb\3\2\2\2?\u00bd\3\2"+
		"\2\2A\u00bf\3\2\2\2C\u00c1\3\2\2\2E\u00c3\3\2\2\2G\u00c5\3\2\2\2I\u00ca"+
		"\3\2\2\2K\u00cf\3\2\2\2M\u00d3\3\2\2\2O\u00da\3\2\2\2Q\u00de\3\2\2\2S"+
		"\u00e4\3\2\2\2U\u00e9\3\2\2\2W\u00ee\3\2\2\2Y\u00f4\3\2\2\2[\u00f9\3\2"+
		"\2\2]\u00fc\3\2\2\2_\u0101\3\2\2\2a\u0105\3\2\2\2c\u010b\3\2\2\2e\u0111"+
		"\3\2\2\2g\u011a\3\2\2\2i\u0122\3\2\2\2k\u0128\3\2\2\2m\u0133\3\2\2\2o"+
		"\u0141\3\2\2\2q\u0150\3\2\2\2s\u0152\3\2\2\2u\u0154\3\2\2\2wx\7-\2\2x"+
		"\4\3\2\2\2yz\7/\2\2z\6\3\2\2\2{|\7,\2\2|\b\3\2\2\2}~\7\61\2\2~\n\3\2\2"+
		"\2\177\u0080\7\'\2\2\u0080\f\3\2\2\2\u0081\u0082\7@\2\2\u0082\16\3\2\2"+
		"\2\u0083\u0084\7>\2\2\u0084\20\3\2\2\2\u0085\u0086\7@\2\2\u0086\u0087"+
		"\7?\2\2\u0087\22\3\2\2\2\u0088\u0089\7>\2\2\u0089\u008a\7?\2\2\u008a\24"+
		"\3\2\2\2\u008b\u008c\7#\2\2\u008c\u008d\7?\2\2\u008d\26\3\2\2\2\u008e"+
		"\u008f\7?\2\2\u008f\u0090\7?\2\2\u0090\30\3\2\2\2\u0091\u0092\7(\2\2\u0092"+
		"\u0093\7(\2\2\u0093\32\3\2\2\2\u0094\u0095\7~\2\2\u0095\u0096\7~\2\2\u0096"+
		"\34\3\2\2\2\u0097\u0098\7#\2\2\u0098\36\3\2\2\2\u0099\u009a\7@\2\2\u009a"+
		"\u009b\7@\2\2\u009b \3\2\2\2\u009c\u009d\7>\2\2\u009d\u009e\7>\2\2\u009e"+
		"\"\3\2\2\2\u009f\u00a0\7(\2\2\u00a0$\3\2\2\2\u00a1\u00a2\7~\2\2\u00a2"+
		"&\3\2\2\2\u00a3\u00a4\7`\2\2\u00a4(\3\2\2\2\u00a5\u00a6\7\u0080\2\2\u00a6"+
		"*\3\2\2\2\u00a7\u00a8\7?\2\2\u00a8,\3\2\2\2\u00a9\u00aa\7-\2\2\u00aa\u00ab"+
		"\7-\2\2\u00ab.\3\2\2\2\u00ac\u00ad\7/\2\2\u00ad\u00ae\7/\2\2\u00ae\60"+
		"\3\2\2\2\u00af\u00b0\7\60\2\2\u00b0\62\3\2\2\2\u00b1\u00b2\7]\2\2\u00b2"+
		"\64\3\2\2\2\u00b3\u00b4\7_\2\2\u00b4\66\3\2\2\2\u00b5\u00b6\7*\2\2\u00b6"+
		"8\3\2\2\2\u00b7\u00b8\7+\2\2\u00b8:\3\2\2\2\u00b9\u00ba\7A\2\2\u00ba<"+
		"\3\2\2\2\u00bb\u00bc\7<\2\2\u00bc>\3\2\2\2\u00bd\u00be\7=\2\2\u00be@\3"+
		"\2\2\2\u00bf\u00c0\7.\2\2\u00c0B\3\2\2\2\u00c1\u00c2\7}\2\2\u00c2D\3\2"+
		"\2\2\u00c3\u00c4\7\177\2\2\u00c4F\3\2\2\2\u00c5\u00c6\7x\2\2\u00c6\u00c7"+
		"\7q\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7f\2\2\u00c9H\3\2\2\2\u00ca\u00cb"+
		"\7d\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7n\2\2\u00ce"+
		"J\3\2\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7v\2\2\u00d2"+
		"L\3\2\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7t\2\2\u00d6"+
		"\u00d7\7k\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7i\2\2\u00d9N\3\2\2\2\u00da"+
		"\u00db\7p\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7y\2\2\u00ddP\3\2\2\2\u00de"+
		"\u00df\7e\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7u\2\2"+
		"\u00e2\u00e3\7u\2\2\u00e3R\3\2\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7w\2"+
		"\2\u00e6\u00e7\7n\2\2\u00e7\u00e8\7n\2\2\u00e8T\3\2\2\2\u00e9\u00ea\7"+
		"v\2\2\u00ea\u00eb\7t\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7g\2\2\u00edV"+
		"\3\2\2\2\u00ee\u00ef\7h\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1\7n\2\2\u00f1"+
		"\u00f2\7u\2\2\u00f2\u00f3\7g\2\2\u00f3X\3\2\2\2\u00f4\u00f5\7v\2\2\u00f5"+
		"\u00f6\7j\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7u\2\2\u00f8Z\3\2\2\2\u00f9"+
		"\u00fa\7k\2\2\u00fa\u00fb\7h\2\2\u00fb\\\3\2\2\2\u00fc\u00fd\7g\2\2\u00fd"+
		"\u00fe\7n\2\2\u00fe\u00ff\7u\2\2\u00ff\u0100\7g\2\2\u0100^\3\2\2\2\u0101"+
		"\u0102\7h\2\2\u0102\u0103\7q\2\2\u0103\u0104\7t\2\2\u0104`\3\2\2\2\u0105"+
		"\u0106\7y\2\2\u0106\u0107\7j\2\2\u0107\u0108\7k\2\2\u0108\u0109\7n\2\2"+
		"\u0109\u010a\7g\2\2\u010ab\3\2\2\2\u010b\u010c\7d\2\2\u010c\u010d\7t\2"+
		"\2\u010d\u010e\7g\2\2\u010e\u010f\7c\2\2\u010f\u0110\7m\2\2\u0110d\3\2"+
		"\2\2\u0111\u0112\7e\2\2\u0112\u0113\7q\2\2\u0113\u0114\7p\2\2\u0114\u0115"+
		"\7v\2\2\u0115\u0116\7k\2\2\u0116\u0117\7p\2\2\u0117\u0118\7w\2\2\u0118"+
		"\u0119\7g\2\2\u0119f\3\2\2\2\u011a\u011b\7t\2\2\u011b\u011c\7g\2\2\u011c"+
		"\u011d\7v\2\2\u011d\u011e\7w\2\2\u011e\u011f\7t\2\2\u011f\u0120\7p\2\2"+
		"\u0120h\3\2\2\2\u0121\u0123\t\2\2\2\u0122\u0121\3\2\2\2\u0123\u0124\3"+
		"\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"\u0127\b\65\2\2\u0127j\3\2\2\2\u0128\u0129\7\61\2\2\u0129\u012a\7\61\2"+
		"\2\u012a\u012e\3\2\2\2\u012b\u012d\n\3\2\2\u012c\u012b\3\2\2\2\u012d\u0130"+
		"\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0131\u0132\b\66\2\2\u0132l\3\2\2\2\u0133\u0134\7\61\2"+
		"\2\u0134\u0135\7,\2\2\u0135\u0139\3\2\2\2\u0136\u0138\13\2\2\2\u0137\u0136"+
		"\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7,\2\2\u013d\u013e\7\61"+
		"\2\2\u013e\u013f\3\2\2\2\u013f\u0140\b\67\2\2\u0140n\3\2\2\2\u0141\u0145"+
		"\t\4\2\2\u0142\u0144\t\5\2\2\u0143\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146p\3\2\2\2\u0147\u0145\3\2\2\2"+
		"\u0148\u014c\t\6\2\2\u0149\u014b\t\7\2\2\u014a\u0149\3\2\2\2\u014b\u014e"+
		"\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0151\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014f\u0151\7\62\2\2\u0150\u0148\3\2\2\2\u0150\u014f\3"+
		"\2\2\2\u0151r\3\2\2\2\u0152\u0153\7$\2\2\u0153t\3\2\2\2\u0154\u015e\5"+
		"s:\2\u0155\u015d\t\b\2\2\u0156\u0157\7^\2\2\u0157\u015d\7p\2\2\u0158\u0159"+
		"\7^\2\2\u0159\u015d\7^\2\2\u015a\u015b\7^\2\2\u015b\u015d\7$\2\2\u015c"+
		"\u0155\3\2\2\2\u015c\u0156\3\2\2\2\u015c\u0158\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015d\u0160\3\2\2\2\u015e\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f"+
		"\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\5s:\2\u0162v\3\2\2\2\13"+
		"\2\u0124\u012e\u0139\u0145\u014c\u0150\u015c\u015e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}