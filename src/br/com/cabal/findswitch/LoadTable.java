package br.com.cabal.findswitch;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cabal.entity.BandTlf;
import br.com.cabal.entity.TrxBandCabalSuporte;
import br.com.cabal.entity.core.EManager;
import br.com.cabal.entity.core.Filtro;
import br.com.cabal.enums.EnumCamposPesquisa;
import br.com.cabal.enums.EnumTabela;
import br.com.cabal.findswitch.graficos.GraficoDSBandeira;

import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;
import com.vaadin.addon.jpacontainer.JPAContainerItem;
import com.vaadin.data.Container.Filter;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class LoadTable {

	private EnumTabela eTabela;
	private JPAContainer<TrxBandCabalSuporte> containerWS;
	private JPAContainer<BandTlf> containerBandeira;
	private UI telaPrincipal;
	private EntityManager em = EManager.createEntityManager();
	
	public LoadTable(EnumTabela tabela, UI u) {
		this.eTabela = tabela;
		this.telaPrincipal = u;
	}

	private Table getValoresPadraoTabela(Table table){
		
		table.setSizeFull();
		table.setPageLength(28);
		table.setSelectable(true);
		table.setColumnReorderingAllowed(true);
		table.setColumnCollapsingAllowed(false);
		return table;
	}

	private void setVisibilizadeCamposWS(Table tabela){
		tabela.setVisibleColumns(new String[]{"identificacaoPedido","dataInclusao","cartao","nroAutorizacaoEmissor","resultadoAutorizacao","tidRespostaOriginal","numeroAfiliacao"});
	}
	
	private void setVisibilizadeCamposBandeira(Table tabela){
		tabela.setVisibleColumns(new String[]{"idTrans","mti","nsuAdq","dataHoraGmt","nsuEmissor","dataHoraLog","pan","valorOrigem","ss","ds"});
	}
	private JPAContainer<BandTlf> montarJPAContainerPadraoBanderia(){
		containerBandeira = JPAContainerFactory.make(BandTlf.class, em);
		containerBandeira.sort(new String[]{"dataHoraLog"}, new boolean[]{false});//ordenando a tabela
		return containerBandeira;
	}
	public Table getTabelaPesquisadaBandeira(Table tabela, List<Filter> filtros) {
		getValoresPadraoTabela(tabela);
		montarJPAContainerPadraoBanderia();
		
		for (Filter filter : filtros) {
			containerBandeira.addContainerFilter(filter);
		}
		tabela.setContainerDataSource(containerBandeira);
		setVisibilizadeCamposBandeira(tabela);
		return tabela;
	}
	public Table getTabelaPesquisadaWS(Table t, List<Filter> filtro){
		getValoresPadraoTabela(t);
		montarJPAContainerPadraoWS();
		
		for (Filter filter : filtro) {
			containerWS.addContainerFilter(filter);
		}
		t.setContainerDataSource(containerWS);
		setVisibilizadeCamposWS(t);
		return t;
	}
	@SuppressWarnings("deprecation")
	public Table getValues() {
		Table table = new Table();
		getValoresPadraoTabela(table);
		gerarTabelaPrincipal(table, em);
		table.addListener(new  ItemClickListener(){
			@Override
			public void itemClick(final ItemClickEvent event) {
				System.out.println("Clique");
				TrxBandCabalSuporte trxWS;
				BandTlf trxBandeira;
				JPAContainerItem j= (JPAContainerItem) event.getItem();
				
				if(j.getEntity().getClass().isInstance(new TrxBandCabalSuporte())){
					JPAContainerItem<TrxBandCabalSuporte> containerItemSelecionado = (JPAContainerItem<TrxBandCabalSuporte>)event.getItem();
					trxWS = containerItemSelecionado.getEntity();
					gerarPainelInformacaoWS(trxWS);		
				}
				if(j.getEntity().getClass().isInstance(new BandTlf())){
					JPAContainerItem<BandTlf> containerItemSelecionado = (JPAContainerItem<BandTlf>)event.getItem();
					trxBandeira = containerItemSelecionado.getEntity();
					gerarPainelInformacaoBandeira(trxBandeira);
				}
			
				
			}
			
		});

		
		return table;
	}
	
	protected void gerarPainelInformacaoBandeira(BandTlf trxBandeira) {
		System.out.println(">>" + trxBandeira.toString());
		ItemWindowBandeira item = new ItemWindowBandeira("Detalhamento", trxBandeira);
		telaPrincipal.addWindow(item);
	}

	protected void gerarPainelInformacaoWS(TrxBandCabalSuporte trxWS) {
		System.out.println(">>" + trxWS.toString());
		ItemWindowWS item = new ItemWindowWS("Detalhamento", trxWS);
		telaPrincipal.addWindow(item);
	}

	private JPAContainer<TrxBandCabalSuporte> montarJPAContainerPadraoWS(){
		containerWS = JPAContainerFactory.make(TrxBandCabalSuporte.class, em);
		containerWS.sort(new String[]{"dataInclusao"}, new boolean[]{false});//ordenando a tabela
		return containerWS; 
	}
	private void gerarTabelaPrincipal(Table table, EntityManager em) {
		switch (eTabela) {
		case  PAG_SEGURO:
				montarJPAContainerPadraoWS();
				containerWS.addContainerFilter(Filtro.filtrarDadosWS(eTabela.PAG_SEGURO.getNome()));
				//containerWS.addContainerFilter(Filtro.filtrarDadosWSPeriodoMaiorQue(EnumCamposPesquisa.DATA_INCLUSAO.getNome(), getData90DiasAnteriores()));
				table.setContainerDataSource(containerWS);	
				setVisibilizadeCamposWS(table);
			break;
		case BNDES:
			montarJPAContainerPadraoWS();
			containerWS.addContainerFilter(Filtro.filtrarDadosWS(eTabela.BNDES.getNome()));
			containerWS.addContainerFilter(Filtro.filtrarDadosWSPeriodoMaiorQue(EnumCamposPesquisa.DATA_INCLUSAO.getNome(), getData90DiasAnteriores()));
			table.setContainerDataSource(containerWS);
			setVisibilizadeCamposWS(table);
			break;
		case BANDEIRA:
				containerBandeira = JPAContainerFactory.make(BandTlf.class, em);
				table.setContainerDataSource(containerBandeira);
				setVisibilizadeCamposBandeira(table);
			break;
			default:
				break;
		}
	}

	private Date getData90DiasAnteriores() {
		long hoje = System.currentTimeMillis();
		long noventaDias = 7776000000l;
		System.out.println("Hoje  = " + hoje + "\n" + "90dias = " + noventaDias);
		Date d = new Date(hoje-noventaDias);
		System.out.println(d);
		return d;
	}

}