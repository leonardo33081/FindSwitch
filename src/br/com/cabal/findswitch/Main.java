package br.com.cabal.findswitch;

import java.util.ArrayList;
import java.util.List;

import br.com.cabal.entity.core.Filtro;
import br.com.cabal.enums.EnumCamposPesquisa;
import br.com.cabal.enums.EnumTabela;
import br.com.cabal.findswitch.graficos.GraficoDSBandeira;
import br.com.cabal.findswitch.graficos.GraficoTeste;

import com.vaadin.addon.charts.Chart;
import com.vaadin.annotations.Title;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Property;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
@Title("Find Switch")
public class Main extends UI {
	protected HorizontalLayout horizontal;
	protected VerticalLayout vertical;
	
	protected Label lbPrincipal;
	protected Image lbInfoTabela;
	
	protected Panel painelDadosPesquisaWS;
	protected Panel painelDadosPesquisaBandeira;
	
	protected TextField txtNroPedido;
	protected TextField txtNroAutorizacaoEmissor;
	protected TextField txtNroNSUAdquirente;
	protected TextField txtNroTID;
	
	protected Table tabela;
	protected Button btPesquisar;
	protected MenuBar menu;
	protected DateField dataInicial;
	protected DateField dataFinal;
	private HorizontalLayout horizontalLayoutNroPedido;
	private EnumTabela eTabelaSelecionada;
	
	@Override
	protected void init(VaadinRequest request) {
		this.setContent(montarLayoutVertical());
		this.vertical.addComponent(montarLayoutHorizontal());
	}

	private Component montarLayoutHorizontal() {
		this.horizontal = new HorizontalLayout();
		return this.horizontal;
	}

	private Component montarLayoutVertical() {
		this.vertical = new VerticalLayout();
		this.vertical.setMargin(true);
		
		this.menu = getMenu();
		this.lbPrincipal = getLabel();
		this.dataInicial = getCalendarioInicial();
		this.dataFinal = getCalendarioFinal();
		
		this.vertical.addComponent(lbPrincipal);
		this.vertical.addComponent(menu);

		return this.vertical;
	}

	private Label getLabel(){
		this.lbPrincipal = new Label("<h1>Find-Switch</h1>",Label.CONTENT_XHTML);
		this.lbPrincipal.setStyleName("titleLabel");
		return lbPrincipal;
	}
	private Button getBotaoWS() {
		Button bt = new Button("Filtrar");
		bt.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pesquisarTransacoesWS();
			}
		});
		return bt;
	}
	private Button getBotaoBandeira() {
		Button bt = new Button("Filtrar");
		bt.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				pesquisarTransacoesBandeira();
			}
		});
		return bt;
	}
	
	private void pesquisarTransacoesBandeira() {
		this.vertical.removeComponent(tabela);
		//GraficoDSBandeira g = new GraficoDSBandeira();
		//this.vertical.addComponent(g.getGrafico());
		
		//Filtro.filtrarPorPeriodo(EnumCamposPesquisa.DATA_HORA_LOG.getNome(), dataInicial.getValue(), dataFinal.getValue())
		tabela = new LoadTable(null,this).getTabelaPesquisadaBandeira(tabela, getFiltros(EnumTabela.BANDEIRA));
		this.vertical.addComponent(tabela);	
	}

	private List<Filter> getFiltros(EnumTabela enumTabela){
		List<Filter> lFiltros = new ArrayList<Filter>();
		
		if(!isNull(this.txtNroAutorizacaoEmissor) && this.txtNroAutorizacaoEmissor.getValue().trim().length() > 0){
			lFiltros.add(Filtro.filtrarPorCodigo((EnumTabela.BANDEIRA == enumTabela ? EnumCamposPesquisa.NRO_AUTORIZACAO_BANDEIRA.getNome() : EnumCamposPesquisa.NRO_AUTORIZACAO_WS.getNome()), this.txtNroAutorizacaoEmissor.getValue()));
		}
		if(!isNull(this.txtNroNSUAdquirente) && this.txtNroNSUAdquirente.getValue().trim().length() > 0){
			lFiltros.add(Filtro.filtrarPorCodigo(EnumCamposPesquisa.NRO_NSU_ADQUIRENTE.getNome(), this.txtNroNSUAdquirente.getValue()));
		}
		if(!isNull(this.txtNroPedido) && this.txtNroPedido.getValue().trim().length() > 0){
			lFiltros.add(Filtro.filtrarPorCodigo(EnumCamposPesquisa.IDENT_PEDIDO.getNome(), this.txtNroPedido.getValue()));
		}
		if(!isNull(this.txtNroTID) && this.txtNroTID.getValue().trim().length() > 0){
			lFiltros.add(Filtro.filtrarPorCodigo(EnumCamposPesquisa.TID.getNome(), this.txtNroTID.getValue()));
		}
		if(!isNull(this.dataInicial) && !isNull(this.dataFinal) && (!isNull(this.dataInicial.getValue()) && !isNull(this.dataFinal.getValue()))){
			for (Filter filter : Filtro.filtrarPorPeriodo(eTabelaSelecionada == EnumTabela.BANDEIRA ? "dataHoraLog" : "dataInclusao", this.dataInicial.getValue(), this.dataFinal.getValue())) {
				lFiltros.add(filter);
			}
		}
		return lFiltros;
	}
	
	public void pesquisarTransacoesWS() {
		this.vertical.removeComponent(tabela);
		tabela = new LoadTable(null,this).getTabelaPesquisadaWS(tabela, getFiltros(EnumTabela.WS));
		System.out.println("Nro Pedido:" + this.txtNroPedido.getValue());
		this.vertical.addComponent(tabela);
		
	}

	private MenuBar getMenu() {
		menu = new MenuBar();
	
		MenuItem menuOpcoes = menu.addItem("Menu Info Switch", new ThemeResource("icon_switch.png" ), null);
		
		MenuBar.Command comandoBNDES = new MenuBar.Command() {
			public void menuSelected(MenuItem itemSelecionado) {
				System.out.println("Selecionado " + itemSelecionado.getText() + " do menu.");
				eTabelaSelecionada = EnumTabela.BNDES;
				reset();
				showTabelaBNDES();
				
			}
		};
		
		MenuBar.Command comandoPagSeguro = new MenuBar.Command() {
			public void menuSelected(MenuItem itemSelecionado) {
				System.out.println("Selecionado " + itemSelecionado.getText() + " do menu.");
				eTabelaSelecionada = EnumTabela.PAG_SEGURO;
				reset();
				showTabelaPagSeguro();
			}
		};
		MenuBar.Command comandoBandeira = new MenuBar.Command() {
			public void menuSelected(MenuItem itemSelecionado) {
				System.out.println("Selecionado " + itemSelecionado.getText() + " do menu.");
				eTabelaSelecionada = EnumTabela.BANDEIRA;
				reset();
				showTabelaBandeira();
			}
		};
		
		MenuItem menuWebServices = menuOpcoes.addItem("Web Services", null, null);
		MenuItem menuBNDES = menuWebServices.addItem("BNDES", new ThemeResource("icon_bndes_switch.jpg" ), comandoBNDES);
		MenuItem menuPagSeguro = menuWebServices.addItem("Pag-Seguro", new ThemeResource("icon-pagseguro.png" ), comandoPagSeguro);
		MenuItem menuBandeira = menuOpcoes.addItem("Bandeira", new ThemeResource("jpos_t.gif" ), comandoBandeira);
		
		return menu;
	}

	protected void reset() {
		if(!isNull(vertical)){
			if(!isNull(lbInfoTabela)){
				System.out.println("Label " + lbInfoTabela.getCaption() + " removido");
				vertical.removeComponent(lbInfoTabela);
			}
			if(!isNull(painelDadosPesquisaWS)){
				System.out.println("Campo " + painelDadosPesquisaWS.getCaption() + " removido");
				this.vertical.removeComponent(painelDadosPesquisaWS);
			}
			if(!isNull(painelDadosPesquisaBandeira)){
				System.out.println("Campo " + painelDadosPesquisaBandeira.getCaption() + " removido");
				this.vertical.removeComponent(painelDadosPesquisaBandeira);
			}
		}
	}

	protected void showTabelaBandeira() {
		removeTabela();
		lbInfoTabela = new Image("Bandeira Cabal",new ThemeResource("icon_cabal_switch.gif" ));
		
		this.vertical.addComponent(lbInfoTabela);
		this.vertical.addComponent(montarPainelPesquisaBandeira());
		
		this.tabela = new LoadTable(EnumTabela.BANDEIRA,this).getValues();
		adicionaTabela();		
	}

	
	protected void showTabelaPagSeguro() {
		removeTabela();		
		lbInfoTabela = new Image("Pag-Seguro",new ThemeResource("icon-pagseguro.png"));
		this.vertical.addComponent(lbInfoTabela);
				
		getComponentesComunsTelaWS();
		
		this.tabela = new LoadTable(EnumTabela.PAG_SEGURO,this).getValues();
		adicionaTabela();
		
	}

	protected void showTabelaBNDES() {
		if(!isNull(tabela))
			this.vertical.removeComponent(tabela);
		
		lbInfoTabela = new Image("BNDES",new ThemeResource("icon_bndes_switch.jpg" ));
		this.vertical.addComponent(lbInfoTabela);

		getComponentesComunsTelaWS();
		
		this.tabela = new LoadTable(EnumTabela.BNDES,this).getValues();
		this.vertical.addComponent(tabela);
	}
	
	private void adicionaTabela(){
		this.vertical.addComponent(tabela);
		
	}
	private void removeTabela(){
		if(!isNull(tabela))
			this.vertical.removeComponent(tabela);
	}
	
	private Panel montarPainelPesquisaBandeira(){
		 this.painelDadosPesquisaBandeira = new Panel("Filtrar");
		 this.painelDadosPesquisaBandeira.setSizeUndefined(); 
		 this.vertical.addComponent(painelDadosPesquisaBandeira);
		 
		 FormLayout content = new FormLayout();
		 
		 this.txtNroAutorizacaoEmissor = new TextField("Nº Autorização");
		 this.txtNroNSUAdquirente = new TextField("Nº NSU");
		 
		 content.addComponent(this.txtNroNSUAdquirente);
		 content.addComponent(this.txtNroAutorizacaoEmissor);
		 
		 this.dataInicial = getCalendarioInicial();
		 this.dataFinal = getCalendarioFinal();
		 
		 content.addComponent(this.dataInicial);
		 content.addComponent(this.dataFinal);
		 
		 Button botaoPesquisar = getBotaoBandeira();
		 content.addComponent(botaoPesquisar);
		 
		 content.setSizeUndefined();
		 content.setMargin(true);
		 this.painelDadosPesquisaBandeira.setContent(content);
		 
		 return this.painelDadosPesquisaBandeira;
	}
	
	private Panel montarPainelPesquisaWS(){
		 this.painelDadosPesquisaWS = new Panel("Filtrar");
		 this.painelDadosPesquisaWS.setSizeUndefined(); 
		 this.vertical.addComponent(painelDadosPesquisaWS);
		 
		 FormLayout content = new FormLayout();
		 
		 this.txtNroPedido = new TextField("Nº Pedido");
		 this.txtNroAutorizacaoEmissor = new TextField("Nº Autorização");
		 //this.txtNroNSUAdquirente = new TextField("Nº NSU");
		 this.txtNroTID = new TextField("Nº TID");
		 
		 content.addComponent(this.txtNroPedido);
		 //content.addComponent(this.txtNroNSUAdquirente);
		 content.addComponent(this.txtNroTID);
		 content.addComponent(this.txtNroAutorizacaoEmissor);
		 
		 this.dataInicial = getCalendarioInicial();
		 this.dataFinal = getCalendarioFinal();
		 content.addComponent(this.dataInicial);
		 content.addComponent(this.dataFinal);

		 this.btPesquisar = getBotaoWS();
		 
		 content.addComponent(this.btPesquisar);
		 
		 content.setSizeUndefined();
		 content.setMargin(true);
		 this.painelDadosPesquisaWS.setContent(content);
		 
		 return this.painelDadosPesquisaWS;
	}
	
	private void getComponentesComunsTelaWS() {
		this.vertical.addComponent(montarPainelPesquisaWS());
	}
	private DateField getCalendarioInicial(){
		this.dataInicial = new DateField("De");
		this.dataInicial.setResolution(DateField.RESOLUTION_DAY);
		this.dataInicial.setImmediate(true);
	
		return dataInicial;
	} 
	
	private DateField getCalendarioFinal(){
		this.dataFinal = new DateField("Até");
		this.dataFinal.setResolution(DateField.RESOLUTION_DAY);
		this.dataFinal.setImmediate(true);
	
		return dataFinal;
	} 
	
	private boolean isNull(Object o){
		return o == null;
	}
}
