package br.com.cabal.enums;

public enum EnumCamposPesquisa {
	
	IDENT_PEDIDO("identificacaoPedido"),
	DATA_INCLUSAO("dataInclusao"),
	DATA_HORA_LOG("dataHoraLog"),
	NRO_AUTORIZACAO_WS("nroAutorizacaoEmissor"),
	NRO_AUTORIZACAO_BANDEIRA("nsuEmissor"),
	NRO_NSU_ADQUIRENTE("nsuAdq"),
	TID("tidRespostaOriginal");
	
	
	
	private String nome;
	EnumCamposPesquisa(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
}

    