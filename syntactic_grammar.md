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
expression  -> assignment ;
assignment  -> IDENTIFIER "=" assignment
	     | logic_or ;
logic-or    -> logic-and ( "or" logic-and )\* ;
logic-and   -> equality ( "and" equality )\* ;
equality    -> comparison ( ( "!=" | "==" ) comparison )\* ;
comparison  -> term ( ( ">" | ">=" | "<" | "<=" ) term )\* ;
term	    -> factor ( ( "-" | "+" ) factor )\* ;
factor	    -> unary ( ( "/" | "\*" ) unary )\* ;
unary	    -> ("!" | "-") unary | primary ;
primary	    -> NUMBER | STRING | "true" | "false" | "nil" | IDENTIFIER
	     | "(" expression ")" ;

##### Statments
program	    -> declaration\* EOF ;
declaration -> varDecl
               | statement ;
varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;
statement   -> exprStmt
	       | forStmt
	       | ifStmt
	       | whileStmt
               | printStmt
	       | block ;
block	    -> "{" declaration\* "}"
ifStmt	    -> "if" "(" expression ")" statment
		( "else" statement )? ;
whileStmt   -> "while" "(" expression ")" statement ;
forStmt	    -> "for" "(" ( varDecl | exprStmt | ";" )
		expression? ";"
		expression? ")" statement ;
