// Generated from D:/UTwente/Module 8/Lava Programming Language/src/main/java/grammar\Lava.g4 by ANTLR 4.5.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LavaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LavaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(LavaParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#blockStatements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatements(LavaParser.BlockStatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(LavaParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(LavaParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(LavaParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(LavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(LavaParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#functiondecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondecl(LavaParser.FunctiondeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(LavaParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#parametersdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersdecl(LavaParser.ParametersdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#target}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTarget(LavaParser.TargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#variableInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInit(LavaParser.VariableInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#arrayInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInit(LavaParser.ArrayInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(LavaParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(LavaParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#boolOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolOp(LavaParser.BoolOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#multOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOp(LavaParser.MultOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#plusOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOp(LavaParser.PlusOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(LavaParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpr(LavaParser.TrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputExpr(LavaParser.InputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code staticstringExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticstringExpr(LavaParser.StaticstringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldExpr(LavaParser.FieldExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(LavaParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(LavaParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(LavaParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(LavaParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(LavaParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(LavaParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpr(LavaParser.FalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(LavaParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link LavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(LavaParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(LavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(LavaParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(LavaParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleType(LavaParser.DoubleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(LavaParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code longType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLongType(LavaParser.LongTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(LavaParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link LavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(LavaParser.VoidTypeContext ctx);
}