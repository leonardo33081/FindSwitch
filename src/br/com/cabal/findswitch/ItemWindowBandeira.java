package br.com.cabal.findswitch;

import br.com.cabal.entity.BandTlf;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class ItemWindowBandeira extends ItemWindow {

	private static final long serialVersionUID = 5624024022109157412L;

	private BandTlf tlf;
	public ItemWindowBandeira(String caption, BandTlf tlf) {
		super(caption);
		loadBandeiraItem(tlf);
	}

	private void loadBandeiraItem(BandTlf tlf) {
		/*

	        Panel amntPanel = createAmountDataPanel();
	        leftColumn.addComponent(amntPanel);
	        leftColumn.setComponentAlignment(amntPanel, Alignment.BOTTOM_CENTER);

	        gridLayout.addComponent(requestData, 0, 0);
	        gridLayout.addComponent(leftColumn, 1, 0);

	        Panel additional = createAdditionalPanel();

	        gridLayout.addComponent(additional, 0, 2, 1, 2);
	        gridLayout.setSizeFull();
	        gridLayout.setSpacing(true);
	        addComponent(gridLayout);

	        if (!prevIds.isEmpty())
	            addComponent(createBackButton());
		
		*/
		setTlf(tlf);

		GridLayout gridLayout = new GridLayout(2, 3);
		Panel panelRequest = createRequestDataPanel();
		VerticalLayout leftColumn = new VerticalLayout();
		leftColumn.setSpacing(true);
		leftColumn.setHeight("100%");

		Panel panelResponse = createResponseDataPanel();

		leftColumn.addComponent(panelResponse);
		
		//
		
		Panel panelDetalhamento = createDetalhamentoPanel();
	    leftColumn.addComponent(panelDetalhamento);
	    //leftColumn.setComponentAlignment(panelDetalhamento, Alignment.BOTTOM_CENTER);
		//
		gridLayout.addComponent(panelRequest, 0, 0);
		gridLayout.addComponent(leftColumn, 1, 0);

		Panel panelTrace = createTracePanel();

		gridLayout.addComponent(panelTrace, 0, 2, 1, 2);
		
		gridLayout.setSizeFull();
		gridLayout.setSpacing(true);

		this.setContent(gridLayout);
	}

	private Panel createTracePanel() {
		Panel panel = new Panel("Detalhamento da Transação");                                             

		FormLayout layout = new FormLayout();                                                           
		layout.setMargin(true);                                                                         
		addField(layout, "ss", 				trataInformacaoString(this.tlf.getSs()));        
		addField(layout, "ds", 				trataInformacaoString(this.tlf.getDs()));               
		addField(layout, "node",			trataInformacaoString(this.tlf.getNode())); 
		addField(layout, "duracaoEmissor", 	trataInformacaoObject(this.tlf.getDuracaoEmissor()).toString());              
		addField(layout, "duracaoTotal", 	trataInformacaoObject(this.tlf.getDuracaoTotal()).toString());       
		addField(layout, "onOff",			trataInformacaoString(this.tlf.getOnOff()));
		panel.setContent(layout);
		return panel;
	}

	private Panel createRequestDataPanel() {
		
		Panel panel = new Panel("Requisição da Transação");
		
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		addField(layout, "idTrans"               ,new Long(this.tlf.getIdTrans()).toString());
		addField(layout, "idBandeira"            ,trataInformacaoString(this.tlf.getIdBandeira()));
		addField(layout, "adquirente"            ,trataInformacaoString(this.tlf.getAdquirente()));
		addField(layout, "cep"                   ,trataInformacaoString(this.tlf.getCep()));
		addField(layout, "codigoMoedaEmissor"    ,trataInformacaoString(this.tlf.getCodigoMoedaEmissor()));
		addField(layout, "codigoMoedaOrigem"     ,trataInformacaoString(this.tlf.getCodigoMoedaOrigem()));
		addField(layout, "codigoMoedaReferencia" ,trataInformacaoString(this.tlf.getCodigoMoedaReferencia()));
		addField(layout, "codigoProcesamento"    ,trataInformacaoString(this.tlf.getCodigoProcesamento()));
		addField(layout, "comercio"              ,trataInformacaoString(this.tlf.getComercio()));
		addField(layout, "convVlorigemVlrefer"   ,trataInformacaoObject(this.tlf.getConvVlorigemVlrefer()).toString());
		addField(layout, "convVlreferVlemissor"  ,trataInformacaoObject(this.tlf.getConvVlreferVlemissor()).toString());
		addField(layout, "dataHoraGmt"           ,trataInformacaoString(this.tlf.getDataHoraGmt()));
		addField(layout, "dataHoraLocal"         ,trataInformacaoString(this.tlf.getDataHoraLocal()));
		addField(layout, "dataHoraLog"           ,getDataString(this.tlf.getDataHoraLog()));
		addField(layout, "dataSistema"           ,getDataString(this.tlf.getDataSistema()));
		addField(layout, "de55Adquirente"        ,trataInformacaoString(this.tlf.getDe55Adquirente()));
		addField(layout, "mcc"                   ,trataInformacaoString(this.tlf.getMcc()));
		addField(layout, "modoEntrada"           ,trataInformacaoString(this.tlf.getModoEntrada()));
		addField(layout, "mti"                   ,trataInformacaoString(this.tlf.getMti()));
		addField(layout, "nsuAdq"                ,trataInformacaoString(this.tlf.getNsuAdq()));
		addField(layout, "pan"                   ,trataInformacaoString(this.tlf.getPan()));
		addField(layout, "rrnAdq"                ,trataInformacaoString(this.tlf.getRrnAdq()));
		addField(layout, "terminal"              ,trataInformacaoString(this.tlf.getTerminal()));
		addField(layout, "tipoTerminal"          ,trataInformacaoString(this.tlf.getTipoTerminal()));
		addField(layout, "valorEmissor"          ,trataInformacaoObject(this.tlf.getValorEmissor()).toString());
		addField(layout, "valorOrigem"           ,trataInformacaoObject(this.tlf.getValorOrigem()).toString());
		addField(layout, "valorReferencia"       ,trataInformacaoObject(this.tlf.getValorReferencia()).toString());

		
		panel.setContent(layout);
		
		return panel;
	}

	private Panel createDetalhamentoPanel() {
		Panel panel = new Panel("Trace da Transação");
		
		FormLayout layout = new FormLayout();                                                           
		layout.setMargin(true);                                                                         
		addField(layout, "tipoTrans", 			trataInformacaoString(this.tlf.getTipoTrans()));        
		addField(layout, "funcao", 				trataInformacaoString(this.tlf.getFuncao()));               
		addField(layout, "detalheTipoTrans", 	trataInformacaoString(this.tlf.getDetalheTipoTrans()));       
		addField(layout, "qtdParcelas",			trataInformacaoObject(this.tlf.getQtdParcelas()).toString());
		addField(layout, "bin",					trataInformacaoString(this.tlf.getBin())); 
		addField(layout, "binEstendido", 		trataInformacaoString(this.tlf.getBinEstendido()));              
		addField(layout, "adquirenteBandeira",	trataInformacaoString(this.tlf.getAdquirenteBandeira()));
		addField(layout, "nomeComercio",		trataInformacaoString(this.tlf.getNomeComercio()));
		addField(layout, "nomeCidade",			trataInformacaoString(this.tlf.getNomeCidade()));
		addField(layout, "nomeRegiao",			trataInformacaoString(this.tlf.getNomeRegiao()));
		addField(layout, "pais",				trataInformacaoString(this.tlf.getPais()));
		addField(layout, "refid",				trataInformacaoObject(this.tlf.getRefid()).toString());
		addField(layout, "fraudScore",			trataInformacaoString(this.tlf.getFraudScore()));
		
		panel.setContent(layout);
		return panel;
	}

	private void addField(Layout layout, String property, String value) {
		if (value != null) {
			TextField tf = new TextField(property, value);
			tf.setReadOnly(true);
			tf.setStyleName("bold");
			tf.setWidth("100%");
			tf.setNullRepresentation("");
			layout.addComponent(tf);
			if ("id".equals(property))
				tf.focus(); // Need to focus on element to enable ESC Close
							// Shortcut.
		}
	}

	private Panel createResponseDataPanel() {
		Panel panel = new Panel("Resposta da Transação");
		FormLayout layout = new FormLayout();
		layout.setMargin(true);

		addField(layout, "nsuEmissor", 			trataInformacaoString(this.tlf.getNsuEmissor()));        
		addField(layout, "codigoRespEmissor", 	trataInformacaoString(this.tlf.getCodigoRespEmissor()));               
		addField(layout, "mensagemResposta",	trataInformacaoString(this.tlf.getMensagemResposta())); 
		addField(layout, "codigoRespAdq", 		trataInformacaoString(this.tlf.getCodigoRespAdq()));              
		addField(layout, "codigoRespFinal", 	trataInformacaoString(this.tlf.getCodigoRespFinal()));       
		addField(layout, "de55Emissor",			trataInformacaoString(this.tlf.getDe55Emissor()));
		
		panel.setContent(layout);
		return panel;

	}

	public BandTlf gettlf() {
		return tlf;
	}

	public void setTlf(BandTlf tlf) {
		this.tlf = tlf;
	}
	
	
}
