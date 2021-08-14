package br.com.professorisidro.isilanguage.ast;

public class CommandComentario extends AbstractCommand {
	private String command = "";
	
	public CommandComentario(String command) {
		this.command = command;
	}
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return  "/*"+command+"*/";
	}
	@Override
	public String toString() {
		return "CommandComentario [value: "+ command +"]";
	}
	
}
