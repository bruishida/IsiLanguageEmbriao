// Generated from IsiLang.g4 by ANTLR 4.4

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandComentario;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import br.com.professorisidro.isilanguage.ast.CommandEnquanto;
	import br.com.professorisidro.isilanguage.ast.CommandOpEsp;
	import br.com.professorisidro.isilanguage.ast.CommandRaiz;
	import br.com.professorisidro.isilanguage.ast.CommandPara;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, DE=11, ATE=12, AP=13, FP=14, SC=15, OP=16, OPESP=17, OPRAIZ=18, 
		ATTR=19, VIR=20, ACH=21, FCH=22, CMTINICIO=23, CMTFINAL=24, OPREL=25, 
		ID=26, NUMBER=27, TEXT=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "DE", "ATE", "AP", "FP", "SC", "OP", "OPESP", "OPRAIZ", "ATTR", 
		"VIR", "ACH", "FCH", "CMTINICIO", "CMTFINAL", "OPREL", "ID", "NUMBER", 
		"TEXT", "WS"
	};


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
			
		private String _exprWhile;
		private ArrayList<AbstractCommand> listaWhile;
		
		private String _varFor;
		private String _inicialFor;
		private String _finalFor;
		private String _exprIncrementoFor;
		private ArrayList<AbstractCommand> listaFor;
		private boolean isOpEsp = false;
		private boolean isOpRaiz = false;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol "+id+" not declared");
			} 
			IsiVariable variable = (IsiVariable) symbolTable.get(id);
			variable.attribution++;
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}
		
		public void wasVarInitialized(IsiSymbol symbol){
			IsiVariable variable = (IsiVariable) symbol;
			if (!variable.wasInitialized()) {
				System.out.println("WARNING: Variable " + variable.getName() + " was not initialized!!");
			} 
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00cd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00a9\n\32\3\33\3\33\7\33\u00ad"+
		"\n\33\f\33\16\33\u00b0\13\33\3\34\6\34\u00b3\n\34\r\34\16\34\u00b4\3\34"+
		"\3\34\6\34\u00b9\n\34\r\34\16\34\u00ba\5\34\u00bd\n\34\3\35\3\35\3\35"+
		"\3\35\7\35\u00c3\n\35\f\35\16\35\u00c6\13\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37\3\2\n\5\2,-//\61\61\4\2\'\'``\4\2>>@@\3\2c|\5\2\62;C\\"+
		"c|\3\2\62;\4\2$$^^\5\2\13\f\17\17\"\"\u00d6\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5@\3\2\2"+
		"\2\7H\3\2\2\2\tQ\3\2\2\2\13Z\3\2\2\2\r`\3\2\2\2\17e\3\2\2\2\21l\3\2\2"+
		"\2\23u\3\2\2\2\25z\3\2\2\2\27\u0080\3\2\2\2\31\u0083\3\2\2\2\33\u0087"+
		"\3\2\2\2\35\u0089\3\2\2\2\37\u008b\3\2\2\2!\u008d\3\2\2\2#\u008f\3\2\2"+
		"\2%\u0091\3\2\2\2\'\u0093\3\2\2\2)\u0095\3\2\2\2+\u0097\3\2\2\2-\u0099"+
		"\3\2\2\2/\u009b\3\2\2\2\61\u009d\3\2\2\2\63\u00a8\3\2\2\2\65\u00aa\3\2"+
		"\2\2\67\u00b2\3\2\2\29\u00be\3\2\2\2;\u00c9\3\2\2\2=>\7u\2\2>?\7g\2\2"+
		"?\4\3\2\2\2@A\7g\2\2AB\7u\2\2BC\7e\2\2CD\7t\2\2DE\7g\2\2EF\7x\2\2FG\7"+
		"c\2\2G\6\3\2\2\2HI\7h\2\2IJ\7k\2\2JK\7o\2\2KL\7r\2\2LM\7t\2\2MN\7q\2\2"+
		"NO\7i\2\2OP\7=\2\2P\b\3\2\2\2QR\7g\2\2RS\7p\2\2ST\7s\2\2TU\7w\2\2UV\7"+
		"c\2\2VW\7p\2\2WX\7v\2\2XY\7q\2\2Y\n\3\2\2\2Z[\7u\2\2[\\\7g\2\2\\]\7p\2"+
		"\2]^\7c\2\2^_\7q\2\2_\f\3\2\2\2`a\7r\2\2ab\7c\2\2bc\7t\2\2cd\7c\2\2d\16"+
		"\3\2\2\2ef\7p\2\2fg\7w\2\2gh\7o\2\2hi\7g\2\2ij\7t\2\2jk\7q\2\2k\20\3\2"+
		"\2\2lm\7r\2\2mn\7t\2\2no\7q\2\2op\7i\2\2pq\7t\2\2qr\7c\2\2rs\7o\2\2st"+
		"\7c\2\2t\22\3\2\2\2uv\7n\2\2vw\7g\2\2wx\7k\2\2xy\7c\2\2y\24\3\2\2\2z{"+
		"\7v\2\2{|\7g\2\2|}\7z\2\2}~\7v\2\2~\177\7q\2\2\177\26\3\2\2\2\u0080\u0081"+
		"\7f\2\2\u0081\u0082\7g\2\2\u0082\30\3\2\2\2\u0083\u0084\7c\2\2\u0084\u0085"+
		"\7v\2\2\u0085\u0086\7g\2\2\u0086\32\3\2\2\2\u0087\u0088\7*\2\2\u0088\34"+
		"\3\2\2\2\u0089\u008a\7+\2\2\u008a\36\3\2\2\2\u008b\u008c\7=\2\2\u008c"+
		" \3\2\2\2\u008d\u008e\t\2\2\2\u008e\"\3\2\2\2\u008f\u0090\t\3\2\2\u0090"+
		"$\3\2\2\2\u0091\u0092\7%\2\2\u0092&\3\2\2\2\u0093\u0094\7?\2\2\u0094("+
		"\3\2\2\2\u0095\u0096\7.\2\2\u0096*\3\2\2\2\u0097\u0098\7}\2\2\u0098,\3"+
		"\2\2\2\u0099\u009a\7\177\2\2\u009a.\3\2\2\2\u009b\u009c\7]\2\2\u009c\60"+
		"\3\2\2\2\u009d\u009e\7_\2\2\u009e\62\3\2\2\2\u009f\u00a9\t\4\2\2\u00a0"+
		"\u00a1\7@\2\2\u00a1\u00a9\7?\2\2\u00a2\u00a3\7>\2\2\u00a3\u00a9\7?\2\2"+
		"\u00a4\u00a5\7?\2\2\u00a5\u00a9\7?\2\2\u00a6\u00a7\7#\2\2\u00a7\u00a9"+
		"\7?\2\2\u00a8\u009f\3\2\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a2\3\2\2\2\u00a8"+
		"\u00a4\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\64\3\2\2\2\u00aa\u00ae\t\5\2"+
		"\2\u00ab\u00ad\t\6\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\66\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b3\t\7\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00bc\3\2\2\2\u00b6\u00b8\7\60\2\2\u00b7"+
		"\u00b9\t\7\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd8\3\2\2\2\u00be\u00c4\7$\2\2\u00bf\u00c3\n\b\2\2\u00c0"+
		"\u00c1\7^\2\2\u00c1\u00c3\13\2\2\2\u00c2\u00bf\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7$\2\2\u00c8:\3\2\2\2\u00c9"+
		"\u00ca\t\t\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\b\36\2\2\u00cc<\3\2\2\2"+
		"\13\2\u00a8\u00ac\u00ae\u00b4\u00ba\u00bc\u00c2\u00c4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}