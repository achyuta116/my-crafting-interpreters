all: generate_ast
	@ $(MAKE) -f util/java.make DIR=java PACKAGE=lox
generate_ast: 
	@ $(MAKE) -f util/java.make DIR=java PACKAGE=tool
	@ java -cp build/java com.craftinginterpreters.tool.GenerateAst \
			java/com/craftinginterpreters/lox
