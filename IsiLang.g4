grammar IsiLang;

@header{
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandComentario;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import br.com.professorisidro.isilanguage.ast.CommandEnquanto;
	import br.com.professorisidro.isilanguage.ast.CommandOpEsp;
	import br.com.professorisidro.isilanguage.ast.CommandRaiz;
	import br.com.professorisidro.isilanguage.ast.CommandPara;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
		
	private String _exprWhile;
	private ArrayList<AbstractCommand> listaWhile;
	
	private String _varFor;
	private String _inicialFor;
	private String _finalFor;
	private String _exprIncrementoFor;
	private ArrayList<AbstractCommand> listaFor;
	private boolean isOpEsp = false;
	private boolean isOpRaiz = false;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol "+id+" not declared");
		} 
		IsiVariable variable = (IsiVariable) symbolTable.get(id);
		variable.attribution++;
	}
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
	
	public void wasVarInitialized(IsiSymbol symbol){
		IsiVariable variable = (IsiVariable) symbol;
		if (!variable.wasInitialized()) {
			System.out.println("WARNING: Variable " + variable.getName() + " was not initialized!!");
		} 
	}
}

prog	: 'programa' decl bloco  'fimprog;'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	  for(IsiSymbol symbol : symbolTable.getAll()) {
           	  	 wasVarInitialized(symbol);
           	  }
           } 
		;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    } 
              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'numero' { _tipo = IsiVariable.NUMBER;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd      :  cmdleitura  
         |  cmdescrita 
         |  cmdattrib
         |  cmdselecao  
         |  cmdenquanto
         |  cmdpara
         |  cmdcomentario
        ;
		
cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'escreva' 
                 AP 
                 (
                 	ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
                     } 
                   |NUMBER {_writeID = _input.LT(-1).getText();} 
                   |TEXT {_writeID = _input.LT(-1).getText();} 
                 )
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   } 
               ATTR { _exprContent = ""; } 
               expr 
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;
			
cmdenquanto	: 'enquanto' AP
		                    ID    { _exprWhile = _input.LT(-1).getText(); }
		                    OPREL { _exprWhile += _input.LT(-1).getText(); }
		                    (ID | NUMBER | TEXT) { _exprWhile += _input.LT(-1).getText(); }
		                    FP 
		                    ACH 
		                    { curThread = new ArrayList<AbstractCommand>(); 
		                      stack.push(curThread);
		                    }
		                    (cmd)+ 

		                    FCH 
		                    {
		                       listaWhile = stack.pop();
		                       CommandEnquanto cmd = new CommandEnquanto(_exprWhile, listaWhile);
		                       stack.peek().add(cmd);	
		                    } 	
		    ; 
		    
cmdpara : 'para' 	AP
                 	ID    { _varFor = _input.LT(-1).getText(); }
		          	DE	          	
		          	(NUMBER) { _inicialFor = _input.LT(-1).getText(); }
		           	ATE
                    (NUMBER) { _finalFor = _input.LT(-1).getText(); }
                    SC { _exprContent = ""; } 
        			expr
                  	FP
                 	ACH 
	                { curThread = new ArrayList<AbstractCommand>(); 
	                  stack.push(curThread);
	                }
	                (cmd)+ 
	
	                FCH 
		                    
	                {
	                    listaFor =  stack.pop();
	                    CommandPara cmd = new CommandPara(_varFor, _inicialFor, _finalFor, _exprContent, listaFor);
	                    stack.peek().add(cmd);
	                }
            ;
            		    			
cmdselecao  :  'se' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER | TEXT) {_exprDecision += _input.LT(-1).getText(); }
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;
            
cmdcomentario : CMTINICIO {_exprContent = "";}
				(
					 ID {_exprContent += _input.LT(-1).getText();}
					|TEXT {_exprContent += _input.LT(-1).getText();}
					|NUMBER {_exprContent += _input.LT(-1).getText();}
				)*
				CMTFINAL {CommandComentario cmd = new CommandComentario(_exprContent);
                   		stack.peek().add(cmd);}
			;
			
expr        :  termo 

				( 
                 (OP  { _exprContent += _input.LT(-1).getText();}
                 termo
                 )*
                |
                 OPESP { _exprContent += " ";
                     _exprContent += _input.LT(-1).getText();
                     _exprContent += " ";
                     isOpEsp=true;
                 }
            	termo
      			|
                 OPRAIZ {_exprContent += " ";
                 	_exprContent += _input.LT(-1).getText();
                     isOpRaiz=true;
                 }
                )
                {
                    if(isOpEsp) {
                        CommandOpEsp cmd = new CommandOpEsp(_exprContent);
                        _exprContent = cmd.generateJavaCode();
                        isOpEsp=false;
                    }
                    else if(isOpRaiz) {
                    	System.out.println(_exprContent);
                        CommandRaiz cmd = new CommandRaiz(_exprContent);
                        _exprContent = cmd.generateJavaCode();
                        isOpRaiz=false;
                    }
                }
                | TEXT { _exprContent += _input.LT(-1).getText();}
                
                ;
			
termo		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
			;
			
DE	: 'de'
	;

ATE : 'ate'
	;
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
OPESP :    '%' | '^' 
      ;
	
OPRAIZ : '#'
       ;
       
ATTR : '='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
     
CMTINICIO : '['
	 ;
	 
CMTFINAL  : ']'
		  ;
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
TEXT	: '"' (~["\\] | '\\' .)* '"'
        ;		
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;