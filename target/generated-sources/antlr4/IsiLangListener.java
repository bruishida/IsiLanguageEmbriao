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

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(@NotNull IsiLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(@NotNull IsiLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull IsiLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull IsiLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdpara}.
	 * @param ctx the parse tree
	 */
	void enterCmdpara(@NotNull IsiLangParser.CmdparaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdpara}.
	 * @param ctx the parse tree
	 */
	void exitCmdpara(@NotNull IsiLangParser.CmdparaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(@NotNull IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(@NotNull IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(@NotNull IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(@NotNull IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdenquanto(@NotNull IsiLangParser.CmdenquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdenquanto(@NotNull IsiLangParser.CmdenquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdcomentario}.
	 * @param ctx the parse tree
	 */
	void enterCmdcomentario(@NotNull IsiLangParser.CmdcomentarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdcomentario}.
	 * @param ctx the parse tree
	 */
	void exitCmdcomentario(@NotNull IsiLangParser.CmdcomentarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(@NotNull IsiLangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(@NotNull IsiLangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(@NotNull IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(@NotNull IsiLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(@NotNull IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(@NotNull IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(@NotNull IsiLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(@NotNull IsiLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(@NotNull IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(@NotNull IsiLangParser.CmdleituraContext ctx);
}