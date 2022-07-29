public class RPNotation implements Expr.Visitor<String> {
    String rpn(Expr expr) {
	return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
	return expr.left.accept(this) + " " + expr.right.accept(this) + " " + expr.operator.lexeme;
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
	return expr.expression.accept(this);
    }

    @Override
    public String visitUnaryExpression(Expr.Unary expr) {
	return expr.expression.accept(this) + " " + expr.operator.lexeme == TokenType.MINUS ? expr.operator.lexeme : "~";
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
	if(expr.value == null) return "nil";
	return expr.value.toString();
    }
}

