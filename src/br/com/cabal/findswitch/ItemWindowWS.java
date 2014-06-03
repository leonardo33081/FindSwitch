package br.com.cabal.findswitch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import br.com.cabal.entity.TrxBandCabalSuporte;

public class ItemWindowWS extends ItemWindow {

	private static final long serialVersionUID = -6034287656073217948L;
	private TrxBandCabalSuporte trx;

	public ItemWindowWS(String caption, TrxBandCabalSuporte t) {
		super(caption);
		loadWSItem(t);
	}

	private void loadWSItem(TrxBandCabalSuporte trx) {
		setTrx(trx);

		GridLayout gridLayout = new GridLayout(2, 3);
		Panel panelRequest = createRequestDataPanel();
		VerticalLayout leftColumn = new VerticalLayout();
		leftColumn.setSpacing(true);
		leftColumn.setHeight("100%");

		Panel panelResponse = createResponseDataPanel();

		leftColumn.addComponent(panelResponse);
		
		gridLayout.addComponent(panelRequest, 0, 0);
		gridLayout.addComponent(leftColumn, 1, 0);

		Panel panelDetalhamento = createDetalhamentoPanel();

		gridLayout.addComponent(panelDetalhamento, 0, 2, 1, 2);
		
		gridLayout.setSizeFull();
		gridLayout.setSpacing(true);

		this.setContent(gridLayout);
	}

	private Panel createRequestDataPanel() {
		
		Panel panel = new Panel("Request da Transação");
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		addField(layout, "id", 					trataInformacaoString(this.trx.getId().getIdTrxBandCabal() ));
		addField(layout, "Origem", 				trataInformacaoString(this.trx.getId().getOrigem() ));
		addField(layout, "bandeira",			trataInformacaoString(this.trx.getBandeira()));
		addField(layout, "cartao", 				trataInformacaoString(this.trx.getCartao()));
		addField(layout, "identificacaoPedido", trataInformacaoString(this.trx.getIdentificacaoPedido()));
		addField(layout, "tipoProduto", 		trataInformacaoString(this.trx.getTipoProduto()));
		addField(layout, "numeroAfiliacao", 	trataInformacaoString(this.trx.getNumeroAfiliacao()));
		addField(layout, "valor", 				trataInformacaoString(this.trx.getValor().toString()));
		addField(layout, "moeda", 				trataInformacaoString(this.trx.getMoeda().toString()));
		addField(layout, "mesAnoValidadeCartao",trataInformacaoString(this.trx.getMesValidadeCartao() +"/"+ this.trx.getAnoValidadeCartao()));
		
		panel.setContent(layout);
		return panel;
	}

	private Panel createDetalhamentoPanel() {
		Panel panel = new Panel("Detalhamento da Transação");
		// ((Layout)panel.getContent()).setMargin(false, true, false, true);
		FormLayout layout = new FormLayout();
		layout.setMargin(true);
		addField(layout, "dataAutorizacao", 		trataInformacaoString(this.trx.getDataAutorizacao()));
		addField(layout, "dataInclusao", 			getDataString(this.trx.getDataInclusao()));
		addField(layout, "resultadoAutorizacao",	trataInformacaoString(this.trx.getResultadoAutorizacao()));
		addField(layout, "dataCaptura", 			trataInformacaoString(this.trx.getDataCaptura()));
		addField(layout, "resultadoCaptura", 		trataInformacaoString(this.trx.getResultadoCaptura()));
		addField(layout, "dataSolicitacaoCancel",	trataInformacaoString(this.trx.getDataSolicitacaoCancel()));
		addField(layout, "dataCancelamento", 		trataInformacaoString(this.trx.getDataCancelamento()));
		addField(layout, "resultadoCancelamento",	trataInformacaoString(this.trx.getResultadoCancelamento()));
		addField(layout, "dataRecusaCancel", 		trataInformacaoString(this.trx.getDataRecusaCancel()));
		addField(layout, "dataConsulta",			getDataString(this.trx.getDataConsulta()));
		addField(layout, "resultadoConsulta", 		trataInformacaoString(this.trx.getResultadoConsulta()));
		addField(layout, "dataConsultaTid",			getDataString(this.trx.getDataConsultaTid()));
		addField(layout, "resultadoConsultaTid",	trataInformacaoString(this.trx.getResultadoConsultaTid()));

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
		addField(layout, "nroAutorizacaoEmissor", 	trataInformacaoString(this.trx.getNroAutorizacaoEmissor() == null ? "" : this.trx.getNroAutorizacaoEmissor().toString()));
		addField(layout, "tidRespostaOriginal",		trataInformacaoString(this.trx.getTidRespostaOriginal()));
		addField(layout, "rrnTransacao", 			trataInformacaoString(this.trx.getRrnTransacao()));
		addField(layout, "tidReapresentacao", 		trataInformacaoString(this.trx.getTidReapresentacao()));

		panel.setContent(layout);
		return panel;

	}

	public TrxBandCabalSuporte getTrx() {
		return trx;
	}

	public void setTrx(TrxBandCabalSuporte trx) {
		this.trx = trx;
	}

}
