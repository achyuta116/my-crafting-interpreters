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
assignment  -> ( call "." )? IDENTIFIER "=" assignment
	     | logic_or ;
logic-or    -> logic-and ( "or" logic-and )\* ;
logic-and   -> equality ( "and" equality )\* ;
equality    -> comparison ( ( "!=" | "==" ) comparison )\* ;
comparison  -> term ( ( ">" | ">=" | "<" | "<=" ) term )\* ;
term	    -> factor ( ( "-" | "+" ) factor )\* ;
factor	    -> unary ( ( "/" | "\*" ) unary )\* ;
unary	    -> ("!" | "-") unary | call ;
call			-> primary ( "(" arguments? ")" | "." IDENTIFIER)\* ;
arguments	-> expression ( "," expression )\* ;
primary	    -> NUMBER | STRING | "true" | "false" | "nil" | IDENTIFIER
	     | "(" expression ")" | "super" "." IDENTIFIER;

##### Statments
program	    -> declaration\* EOF ;
declaration -> funDecl
						   | varDecl
							 | classDecl
               | statement ;
classDecl		-> "class" IDENTIFIER ( "<" IDENTIFIER )? "{" function\* "}" ;
funDecl			-> "fun" function ;
function 		-> IDENTIFIER "(" parameters? ")" block ;
parameters	-> IDENTIFIER ( "," IDENTIFIER )\* ;
varDecl     -> "var" IDENTIFIER ( "=" expression )? ";" ;
statement   -> exprStmt
	       | forStmt
	       | ifStmt
	       | whileStmt
				 | returnStmt
         | printStmt
	       | block ;
exprStmt		-> expression ";" ;
block	    -> "{" declaration\* "}"
returnStmt-> "return" expression? ";" ;
ifStmt	    -> "if" "(" expression ")" statment
		( "else" statement )? ;
whileStmt   -> "while" "(" expression ")" statement ;
forStmt	    -> "for" "(" ( varDecl | exprStmt | ";" )
		expression? ";"
		expression? ")" statement ;
