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
	 *
	 * @param ctx the parse tree
	 */
	void enterProgram(LavaParser.ProgramContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#program}.
	 *
	 * @param ctx the parse tree
	 */
	void exitProgram(LavaParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#body}.
	 *
	 * @param ctx the parse tree
	 */
	void enterBody(LavaParser.BodyContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#body}.
	 *
	 * @param ctx the parse tree
	 */
	void exitBody(LavaParser.BodyContext ctx);

	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void enterAssignStat(LavaParser.AssignStatContext ctx);

	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void exitAssignStat(LavaParser.AssignStatContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void enterIfStat(LavaParser.IfStatContext ctx);

	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void exitIfStat(LavaParser.IfStatContext ctx);

	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void enterWhileStat(LavaParser.WhileStatContext ctx);

	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void exitWhileStat(LavaParser.WhileStatContext ctx);

	/**
	 * Enter a parse tree produced by the {@code functionStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void enterFunctionStat(LavaParser.FunctionStatContext ctx);

	/**
	 * Exit a parse tree produced by the {@code functionStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void exitFunctionStat(LavaParser.FunctionStatContext ctx);

	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void enterReturnStat(LavaParser.ReturnStatContext ctx);

	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void exitReturnStat(LavaParser.ReturnStatContext ctx);

	/**
	 * Enter a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(LavaParser.EmptyStatContext ctx);

	/**
	 * Exit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(LavaParser.EmptyStatContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#block}.
	 *
	 * @param ctx the parse tree
	 */
	void enterBlock(LavaParser.BlockContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#block}.
	 *
	 * @param ctx the parse tree
	 */
	void exitBlock(LavaParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#blockStatement}.
	 *
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(LavaParser.BlockStatementContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#blockStatement}.
	 *
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(LavaParser.BlockStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#localVariableDeclarationStatement}.
	 *
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#localVariableDeclarationStatement}.
	 *
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx);

	/**
	 * Enter a parse tree produced by the {@code primitiveDeclaration}
	 * labeled alternative in {@link LavaParser#localVariableDeclaration}.
	 *
	 * @param ctx the parse tree
	 */
	void enterPrimitiveDeclaration(LavaParser.PrimitiveDeclarationContext ctx);

	/**
	 * Exit a parse tree produced by the {@code primitiveDeclaration}
	 * labeled alternative in {@link LavaParser#localVariableDeclaration}.
	 *
	 * @param ctx the parse tree
	 */
	void exitPrimitiveDeclaration(LavaParser.PrimitiveDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#main}.
	 *
	 * @param ctx the parse tree
	 */
	void enterMain(LavaParser.MainContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#main}.
	 *
	 * @param ctx the parse tree
	 */
	void exitMain(LavaParser.MainContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#functionDeclaration}.
	 *
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#functionDeclaration}.
	 *
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#functionCall}.
	 *
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(LavaParser.FunctionCallContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#functionCall}.
	 *
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(LavaParser.FunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#parametersDeclaration}.
	 *
	 * @param ctx the parse tree
	 */
	void enterParametersDeclaration(LavaParser.ParametersDeclarationContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#parametersDeclaration}.
	 *
	 * @param ctx the parse tree
	 */
	void exitParametersDeclaration(LavaParser.ParametersDeclarationContext ctx);

	/**
	 * Enter a parse tree produced by the {@code variableTarget}
	 * labeled alternative in {@link LavaParser#target}.
	 *
	 * @param ctx the parse tree
	 */
	void enterVariableTarget(LavaParser.VariableTargetContext ctx);

	/**
	 * Exit a parse tree produced by the {@code variableTarget}
	 * labeled alternative in {@link LavaParser#target}.
	 *
	 * @param ctx the parse tree
	 */
	void exitVariableTarget(LavaParser.VariableTargetContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#parameters}.
	 *
	 * @param ctx the parse tree
	 */
	void enterParameters(LavaParser.ParametersContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#parameters}.
	 *
	 * @param ctx the parse tree
	 */
	void exitParameters(LavaParser.ParametersContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#compOp}.
	 *
	 * @param ctx the parse tree
	 */
	void enterCompOp(LavaParser.CompOpContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#compOp}.
	 *
	 * @param ctx the parse tree
	 */
	void exitCompOp(LavaParser.CompOpContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#boolOp}.
	 *
	 * @param ctx the parse tree
	 */
	void enterBoolOp(LavaParser.BoolOpContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#boolOp}.
	 *
	 * @param ctx the parse tree
	 */
	void exitBoolOp(LavaParser.BoolOpContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#multOp}.
	 *
	 * @param ctx the parse tree
	 */
	void enterMultOp(LavaParser.MultOpContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#multOp}.
	 *
	 * @param ctx the parse tree
	 */
	void exitMultOp(LavaParser.MultOpContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#plusOp}.
	 *
	 * @param ctx the parse tree
	 */
	void enterPlusOp(LavaParser.PlusOpContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#plusOp}.
	 *
	 * @param ctx the parse tree
	 */
	void exitPlusOp(LavaParser.PlusOpContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#negaOp}.
	 *
	 * @param ctx the parse tree
	 */
	void enterNegaOp(LavaParser.NegaOpContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#negaOp}.
	 *
	 * @param ctx the parse tree
	 */
	void exitNegaOp(LavaParser.NegaOpContext ctx);

	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterParExpr(LavaParser.ParExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitParExpr(LavaParser.ParExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterCharExpr(LavaParser.CharExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitCharExpr(LavaParser.CharExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterNotExpr(LavaParser.NotExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitNotExpr(LavaParser.NotExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(LavaParser.TrueExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(LavaParser.TrueExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterCompExpr(LavaParser.CompExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitCompExpr(LavaParser.CompExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(LavaParser.FalseExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(LavaParser.FalseExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(LavaParser.BoolExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(LavaParser.BoolExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterMultExpr(LavaParser.MultExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitMultExpr(LavaParser.MultExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterNumExpr(LavaParser.NumExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitNumExpr(LavaParser.NumExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(LavaParser.PlusExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(LavaParser.PlusExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterFunctionExpr(LavaParser.FunctionExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitFunctionExpr(LavaParser.FunctionExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void enterIdExpr(LavaParser.IdExprContext ctx);

	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 */
	void exitIdExpr(LavaParser.IdExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#type}.
	 *
	 * @param ctx the parse tree
	 */
	void enterType(LavaParser.TypeContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#type}.
	 *
	 * @param ctx the parse tree
	 */
	void exitType(LavaParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link LavaParser#shared}.
	 *
	 * @param ctx the parse tree
	 */
	void enterShared(LavaParser.SharedContext ctx);

	/**
	 * Exit a parse tree produced by {@link LavaParser#shared}.
	 *
	 * @param ctx the parse tree
	 */
	void exitShared(LavaParser.SharedContext ctx);

	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 */
	void enterIntType(LavaParser.IntTypeContext ctx);

	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 */
	void exitIntType(LavaParser.IntTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 */
	void enterBoolType(LavaParser.BoolTypeContext ctx);

	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 */
	void exitBoolType(LavaParser.BoolTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 */
	void enterCharType(LavaParser.CharTypeContext ctx);

	/**
	 * Exit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 */
	void exitCharType(LavaParser.CharTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 */
	void enterVoidType(LavaParser.VoidTypeContext ctx);

	/**
	 * Exit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 */
	void exitVoidType(LavaParser.VoidTypeContext ctx);
}