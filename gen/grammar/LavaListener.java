// Generated from /Users/Rogier/Library/Mobile Documents/com~apple~CloudDocs/Universiteit Twente/Programming Paradigms/Compiler Construction/Lava_Programming_Language/src/main/java/grammar/Lava.g4 by ANTLR 4.5.3
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LavaParser}.
 */
public interface LavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(LavaParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(LavaParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(LavaParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(LavaParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(LavaParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(LavaParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(LavaParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(LavaParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStat(LavaParser.FunctionStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStat(LavaParser.FunctionStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(LavaParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(LavaParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(LavaParser.EmptyStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(LavaParser.EmptyStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(LavaParser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(LavaParser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(LavaParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(LavaParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(LavaParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(LavaParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primDecl}
	 * labeled alternative in {@link LavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPrimDecl(LavaParser.PrimDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primDecl}
	 * labeled alternative in {@link LavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPrimDecl(LavaParser.PrimDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayDecl}
	 * labeled alternative in {@link LavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(LavaParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayDecl}
	 * labeled alternative in {@link LavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(LavaParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(LavaParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(LavaParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#functiondecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondecl(LavaParser.FunctiondeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#functiondecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondecl(LavaParser.FunctiondeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(LavaParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(LavaParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#parametersdecl}.
	 * @param ctx the parse tree
	 */
	void enterParametersdecl(LavaParser.ParametersdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#parametersdecl}.
	 * @param ctx the parse tree
	 */
	void exitParametersdecl(LavaParser.ParametersdeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableTarget}
	 * labeled alternative in {@link LavaParser#target}.
	 * @param ctx the parse tree
	 */
	void enterVariableTarget(LavaParser.VariableTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableTarget}
	 * labeled alternative in {@link LavaParser#target}.
	 * @param ctx the parse tree
	 */
	void exitVariableTarget(LavaParser.VariableTargetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayIndexTarget}
	 * labeled alternative in {@link LavaParser#target}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndexTarget(LavaParser.ArrayIndexTargetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayIndexTarget}
	 * labeled alternative in {@link LavaParser#target}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndexTarget(LavaParser.ArrayIndexTargetContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#arrayInit}.
	 * @param ctx the parse tree
	 */
	void enterArrayInit(LavaParser.ArrayInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#arrayInit}.
	 * @param ctx the parse tree
	 */
	void exitArrayInit(LavaParser.ArrayInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(LavaParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(LavaParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(LavaParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(LavaParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(LavaParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(LavaParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(LavaParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(LavaParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void enterPlusOp(LavaParser.PlusOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void exitPlusOp(LavaParser.PlusOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#negaOp}.
	 * @param ctx the parse tree
	 */
	void enterNegaOp(LavaParser.NegaOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#negaOp}.
	 * @param ctx the parse tree
	 */
	void exitNegaOp(LavaParser.NegaOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCharExpr(LavaParser.CharExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCharExpr(LavaParser.CharExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(LavaParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(LavaParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(LavaParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(LavaParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayInitExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitExpr(LavaParser.ArrayInitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayInitExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitExpr(LavaParser.ArrayInitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInputExpr(LavaParser.InputExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInputExpr(LavaParser.InputExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFieldExpr(LavaParser.FieldExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFieldExpr(LavaParser.FieldExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(LavaParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(LavaParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(LavaParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(LavaParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(LavaParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(LavaParser.PlusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(LavaParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(LavaParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(LavaParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(LavaParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(LavaParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(LavaParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(LavaParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(LavaParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(LavaParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(LavaParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(LavaParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(LavaParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(LavaParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(LavaParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LavaParser#shared}.
	 * @param ctx the parse tree
	 */
	void enterShared(LavaParser.SharedContext ctx);
	/**
	 * Exit a parse tree produced by {@link LavaParser#shared}.
	 * @param ctx the parse tree
	 */
	void exitShared(LavaParser.SharedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(LavaParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(LavaParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(LavaParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(LavaParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterCharType(LavaParser.CharTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitCharType(LavaParser.CharTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(LavaParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(LavaParser.VoidTypeContext ctx);
}