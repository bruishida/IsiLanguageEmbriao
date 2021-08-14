package br.com.professorisidro.isilanguage.datastructures;

import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;

public class IsiVariable extends IsiSymbol {
	
	public static final int NUMBER=0;
	public static final int TEXT  =1;
	public int attribution = 0;
	
	private int type;
	private String value = null;

	
	public IsiVariable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		try {
			if(getType() == NUMBER) {
				double str1 = Double.parseDouble(value); 
			}
			this.value = value;
		} catch (Exception ex) {
			throw new IsiSemanticException("The attribute "+value+" is not a number");
		}
		
	}

	@Override
	public String toString() {
		return "IsiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}
	
	public String generateJavaCode() {
       String str;
       if (type == NUMBER) {
    	   str = "double ";
       }
       else {
    	   str = "String ";
       }
       return str + " "+super.name+";";
	}
	
	public boolean wasInitialized() {
		if(attribution>0) {
			return true;
		}
		return false;
	}

}
