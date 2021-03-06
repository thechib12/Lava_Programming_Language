// Generated from /Users/Rogier/Library/Mobile Documents/com~apple~CloudDocs/Universiteit Twente/Programming Paradigms/Compiler Construction/Lava_Programming_Language/src/main/java/grammar/Lava.g4 by ANTLR 4.5.3
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return type.
 */
public interface LavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LavaParser#program}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LavaParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#body}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(LavaParser.BodyContext ctx);

	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(LavaParser.AssignStatContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(LavaParser.IfStatContext ctx);

	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(LavaParser.WhileStatContext ctx);

	/**
	 * Visit a parse tree produced by the {@code functionStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStat(LavaParser.FunctionStatContext ctx);

	/**
	 * Visit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(LavaParser.ReturnStatContext ctx);

	/**
	 * Visit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link LavaParser#statement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStat(LavaParser.EmptyStatContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#block}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LavaParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#blockStatement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(LavaParser.BlockStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#localVariableDeclarationStatement}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx);

	/**
	 * Visit a parse tree produced by the {@code primitiveDeclaration}
	 * labeled alternative in {@link LavaParser#localVariableDeclaration}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveDeclaration(LavaParser.PrimitiveDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#main}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(LavaParser.MainContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#functionDeclaration}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(LavaParser.FunctionDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#functionCall}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(LavaParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#parametersDeclaration}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersDeclaration(LavaParser.ParametersDeclarationContext ctx);

	/**
	 * Visit a parse tree produced by the {@code variableTarget}
	 * labeled alternative in {@link LavaParser#target}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableTarget(LavaParser.VariableTargetContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#parameters}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(LavaParser.ParametersContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#compOp}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(LavaParser.CompOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#boolOp}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(LavaParser.BoolOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#multOp}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOp(LavaParser.MultOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#plusOp}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOp(LavaParser.PlusOpContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#negaOp}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegaOp(LavaParser.NegaOpContext ctx);

	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(LavaParser.ParExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharExpr(LavaParser.CharExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(LavaParser.NotExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpr(LavaParser.TrueExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(LavaParser.CompExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpr(LavaParser.FalseExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(LavaParser.BoolExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(LavaParser.MultExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(LavaParser.NumExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(LavaParser.PlusExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code functionExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpr(LavaParser.FunctionExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(LavaParser.IdExprContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#type}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LavaParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link LavaParser#shared}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShared(LavaParser.SharedContext ctx);

	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(LavaParser.IntTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(LavaParser.BoolTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(LavaParser.CharTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 *
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(LavaParser.VoidTypeContext ctx);
}