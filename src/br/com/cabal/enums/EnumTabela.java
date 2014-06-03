package br.com.cabal.enums;

public enum EnumTabela {
	
	BNDES("BNDES"),
	PAG_SEGURO("PAG-SEGURO"),
	BANDEIRA("CABAL"),
	WS("WebServices");
	
	private String nome;
	EnumTabela(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
}

    