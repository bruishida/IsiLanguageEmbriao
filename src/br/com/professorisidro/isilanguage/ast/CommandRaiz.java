package br.com.professorisidro.isilanguage.ast;

public class CommandRaiz extends AbstractCommand{
    
    private String termo;
    private String va;
    private String op;
        
    public CommandRaiz(String termo) { 
        this.termo = termo;
    }
    
    private void getVariables() {
        String[] variable = termo.split(" ");
        va = variable[0];
        op = variable[1];
    }
    
    @Override
    public String generateJavaCode() {
        getVariables();
        if (op.equalsIgnoreCase("#")) {
            // TODO Auto-generated method stub
            return "Math.sqrt("+ Integer.parseInt(va) +")";
        }
        // TODO Auto-generated method stub
        return "";
    }
    
    @Override
    public String toString() {
        return "CommandRaiz [op=" + op + ", va=" + va+ "]";
    }
}