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

##### Precedence for parsing expressions
expression  -> comma ;
comma	    -> conditional ( "," conditional )\* ;
conditional -> equality ( "?" equality ":" conditional )? ;
equality    -> comparison ( ( "!=" | "==" ) comparison )\* ;
comparison  -> term ( ( ">" | ">=" | "<" | "<=" ) term )\* ;
term	    -> factor ( ( "-" | "+" ) factor )\* ;
factor	    -> unary ( ( "/" | "\*" ) unary )\* ;
unary	    -> ("!" | "-") unary | primary ;
primary	    -> NUMBER | STRING | "true" | "false" | "nil"
	     | "(" expression ")" ;
	     // Error productions... (without conditional)
	     | ( "," ) comma
	     | ( "!=" | "==" ) equality
	     | ( ">" | ">=" | "<" | "<=" ) comparison
	     | ( "+" ) term
	     | ( "/" | "*" ) factor ;
