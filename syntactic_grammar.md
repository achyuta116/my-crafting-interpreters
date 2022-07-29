#### Grammar representation for Lox
##### Expression
expression  -> literal
	    | unary
	    | binary
	    | grouping ;

##### Literals, Binary Expressions, Unary Expressions and Parentheses
literal	    -> NUMBER | STRING | "true" | "false" | "nil" ;
grouping    -> "(" expression ")" ;
unary	    -> ( "-" | "!" ) expression ;
binary	    -> expression operator expression ;
operator    -> "==" | "!=" | "<" | "<=" | ">" | ">="
	    | "+"  | "-"  | "*" | "/" ;

