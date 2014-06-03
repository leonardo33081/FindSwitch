package br.com.cabal.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.FetchAttribute;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TRX_BAND_CABAL_SUPORTE database table.
 * 
 */
@Entity
@Table(schema="cabal", name="TRX_BAND_CABAL_SUPORTE")
@NamedQuery(name="TrxBandCabalSuporte.findAll", query="SELECT t FROM TrxBandCabalSuporte t")
public class TrxBandCabalSuporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TrxBandCabalSuportePK id;

	@Column(name="ANO_VALIDADE_CARTAO")
	private String anoValidadeCartao;

	private String bandeira;

	private String cartao;

	@Column(name="DATA_AUTORIZACAO")
	private String dataAutorizacao;

	@Column(name="DATA_CANCELAMENTO")
	private String dataCancelamento;

	@Column(name="DATA_CAPTURA")
	private String dataCaptura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_CONSULTA")
	private Date dataConsulta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_CONSULTA_TID")
	private Date dataConsultaTid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_INCLUSAO")
	private Date dataInclusao;

	@Column(name="DATA_RECUSA_CANCEL")
	private String dataRecusaCancel;

	@Column(name="DATA_SOLICITACAO_CANCEL")
	private String dataSolicitacaoCancel;

	@Column(name="IDENTIFICACAO_PEDIDO")
	private String identificacaoPedido;

	@Column(name="MES_VALIDADE_CARTAO")
	private String mesValidadeCartao;

	private BigDecimal moeda;

	@Column(name="NRO_AUTORIZACAO_EMISSOR", scale=0)
	private BigDecimal nroAutorizacaoEmissor;

	@Column(name="NUMERO_AFILIACAO")
	private String numeroAfiliacao;

	@Column(name="RESULTADO_AUTORIZACAO")
	private String resultadoAutorizacao;

	@Column(name="RESULTADO_CANCELAMENTO")
	private String resultadoCancelamento;

	@Column(name="RESULTADO_CAPTURA")
	private String resultadoCaptura;

	@Column(name="RESULTADO_CONSULTA")
	private String resultadoConsulta;

	@Column(name="RESULTADO_CONSULTA_TID")
	private String resultadoConsultaTid;

	@Column(name="RRN_TRANSACAO")
	private String rrnTransacao;

	@Column(name="TID_REAPRESENTACAO")
	private String tidReapresentacao;

	@Column(name="TID_RESPOSTA_ORIGINAL")
	private String tidRespostaOriginal;

	@Column(name="TIPO_PRODUTO")
	private String tipoProduto;

	private BigDecimal valor;

	public TrxBandCabalSuporte() {
	}

	public TrxBandCabalSuportePK getId() {
		return this.id;
	}

	public void setId(TrxBandCabalSuportePK id) {
		this.id = id;
	}

	public String getAnoValidadeCartao() {
		return this.anoValidadeCartao;
	}

	public void setAnoValidadeCartao(String anoValidadeCartao) {
		this.anoValidadeCartao = anoValidadeCartao;
	}

	public String getBandeira() {
		return this.bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getCartao() {
		return this.cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getDataAutorizacao() {
		return this.dataAutorizacao;
	}

	public void setDataAutorizacao(String dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public String getDataCancelamento() {
		return this.dataCancelamento;
	}

	public void setDataCancelamento(String dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public String getDataCaptura() {
		return this.dataCaptura;
	}

	public void setDataCaptura(String dataCaptura) {
		this.dataCaptura = dataCaptura;
	}

	public Date getDataConsulta() {
		return this.dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Date getDataConsultaTid() {
		return this.dataConsultaTid;
	}

	public void setDataConsultaTid(Date dataConsultaTid) {
		this.dataConsultaTid = dataConsultaTid;
	}

	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getDataRecusaCancel() {
		return this.dataRecusaCancel;
	}

	public void setDataRecusaCancel(String dataRecusaCancel) {
		this.dataRecusaCancel = dataRecusaCancel;
	}

	public String getDataSolicitacaoCancel() {
		return this.dataSolicitacaoCancel;
	}

	public void setDataSolicitacaoCancel(String dataSolicitacaoCancel) {
		this.dataSolicitacaoCancel = dataSolicitacaoCancel;
	}

	public String getIdentificacaoPedido() {
		return this.identificacaoPedido;
	}

	public void setIdentificacaoPedido(String identificacaoPedido) {
		this.identificacaoPedido = identificacaoPedido;
	}

	public String getMesValidadeCartao() {
		return this.mesValidadeCartao;
	}

	public void setMesValidadeCartao(String mesValidadeCartao) {
		this.mesValidadeCartao = mesValidadeCartao;
	}

	public BigDecimal getMoeda() {
		return this.moeda;
	}

	public void setMoeda(BigDecimal moeda) {
		this.moeda = moeda;
	}

	public BigDecimal getNroAutorizacaoEmissor() {
		return this.nroAutorizacaoEmissor;
	}

	public void setNroAutorizacaoEmissor(BigDecimal nroAutorizacaoEmissor) {
		this.nroAutorizacaoEmissor = nroAutorizacaoEmissor;
	}

	public String getNumeroAfiliacao() {
		return this.numeroAfiliacao;
	}

	public void setNumeroAfiliacao(String numeroAfiliacao) {
		this.numeroAfiliacao = numeroAfiliacao;
	}

	public String getResultadoAutorizacao() {
		return this.resultadoAutorizacao;
	}

	public void setResultadoAutorizacao(String resultadoAutorizacao) {
		this.resultadoAutorizacao = resultadoAutorizacao;
	}

	public String getResultadoCancelamento() {
		return this.resultadoCancelamento;
	}

	public void setResultadoCancelamento(String resultadoCancelamento) {
		this.resultadoCancelamento = resultadoCancelamento;
	}

	public String getResultadoCaptura() {
		return this.resultadoCaptura;
	}

	public void setResultadoCaptura(String resultadoCaptura) {
		this.resultadoCaptura = resultadoCaptura;
	}

	public String getResultadoConsulta() {
		return this.resultadoConsulta;
	}

	public void setResultadoConsulta(String resultadoConsulta) {
		this.resultadoConsulta = resultadoConsulta;
	}

	public String getResultadoConsultaTid() {
		return this.resultadoConsultaTid;
	}

	public void setResultadoConsultaTid(String resultadoConsultaTid) {
		this.resultadoConsultaTid = resultadoConsultaTid;
	}

	public String getRrnTransacao() {
		return this.rrnTransacao;
	}

	public void setRrnTransacao(String rrnTransacao) {
		this.rrnTransacao = rrnTransacao;
	}

	public String getTidReapresentacao() {
		return this.tidReapresentacao;
	}

	public void setTidReapresentacao(String tidReapresentacao) {
		this.tidReapresentacao = tidReapresentacao;
	}

	public String getTidRespostaOriginal() {
		return this.tidRespostaOriginal;
	}

	public void setTidRespostaOriginal(String tidRespostaOriginal) {
		this.tidRespostaOriginal = tidRespostaOriginal;
	}

	public String getTipoProduto() {
		return this.tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
}