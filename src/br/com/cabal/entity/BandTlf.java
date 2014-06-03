package br.com.cabal.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the BAND_TLF database table.
 * 
 */
@Entity
@Table(name="BAND_TLF")
@NamedQuery(name="BandTlf.findAll", query="SELECT b FROM BandTlf b")
public class BandTlf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TRANS", scale=0)
	private long idTrans;

	private String adquirente;

	@Column(name="ADQUIRENTE_BANDEIRA")
	private String adquirenteBandeira;

	private String bin;

	@Column(name="BIN_ESTENDIDO")
	private String binEstendido;

	private String cep;

	@Column(name="CODIGO_DESTINO")
	private String codigoDestino;

	@Column(name="CODIGO_MOEDA_EMISSOR")
	private String codigoMoedaEmissor;

	@Column(name="CODIGO_MOEDA_ORIGEM")
	private String codigoMoedaOrigem;

	@Column(name="CODIGO_MOEDA_REFERENCIA")
	private String codigoMoedaReferencia;

	@Column(name="CODIGO_PROCESAMENTO")
	private String codigoProcesamento;

	@Column(name="CODIGO_RESP_ADQ")
	private String codigoRespAdq;

	@Column(name="CODIGO_RESP_EMISSOR")
	private String codigoRespEmissor;

	@Column(name="CODIGO_RESP_FINAL")
	private String codigoRespFinal;

	private String comercio;

	@Column(name="CONV_VLORIGEM_VLREFER")
	private BigDecimal convVlorigemVlrefer;

	@Column(name="CONV_VLREFER_VLEMISSOR")
	private BigDecimal convVlreferVlemissor;

	@Column(name="DATA_HORA_GMT")
	private String dataHoraGmt;

	@Column(name="DATA_HORA_LOCAL")
	private String dataHoraLocal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_HORA_LOG")
	private Date dataHoraLog;

	@Column(name="DATA_SISTEMA")
	private Timestamp dataSistema;

	@Column(name="DE55_ADQUIRENTE")
	private String de55Adquirente;

	@Column(name="DE55_EMISSOR")
	private String de55Emissor;

	@Column(name="DETALHE_TIPO_TRANS")
	private String detalheTipoTrans;

	private String ds;

	@Column(name="DURACAO_EMISSOR", scale=0)//precision
	private BigDecimal duracaoEmissor;

	@Column(name="DURACAO_TOTAL", scale=0)
	private BigDecimal duracaoTotal;

	@Column(name="FRAUD_SCORE")
	private String fraudScore;

	private String funcao;

	@Column(name="ID_BANDEIRA")
	private String idBandeira;

	private String mcc;

	@Column(name="MENSAGEM_RESPOSTA")
	private String mensagemResposta;

	@Column(name="MODO_ENTRADA")
	private String modoEntrada;

	private String mti;

	private String node;

	@Column(name="NOME_CIDADE")
	private String nomeCidade;

	@Column(name="NOME_COMERCIO")
	private String nomeComercio;

	@Column(name="NOME_REGIAO")
	private String nomeRegiao;

	@Column(name="NSU_ADQ")
	private String nsuAdq;

	@Column(name="NSU_EMISSOR")
	private String nsuEmissor;

	@Column(name="ON_OFF")
	private String onOff;

	private String pais;

	private String pan;

	@Column(name="QTD_PARCELAS")
	private BigDecimal qtdParcelas;

	private BigDecimal refid;

	@Column(name="RRN_ADQ")
	private String rrnAdq;

	private String ss;

	private String terminal;

	@Column(name="TIPO_TERMINAL")
	private String tipoTerminal;

	@Column(name="TIPO_TRANS")
	private String tipoTrans;

	@Column(name="VALOR_EMISSOR")
	private BigDecimal valorEmissor;

	@Column(name="VALOR_ORIGEM")
	private BigDecimal valorOrigem;

	@Column(name="VALOR_REFERENCIA")
	private BigDecimal valorReferencia;

	public BandTlf() {
	}

	public long getIdTrans() {
		return this.idTrans;
	}

	public void setIdTrans(long idTrans) {
		this.idTrans = idTrans;
	}

	public String getAdquirente() {
		return this.adquirente;
	}

	public void setAdquirente(String adquirente) {
		this.adquirente = adquirente;
	}

	public String getAdquirenteBandeira() {
		return this.adquirenteBandeira;
	}

	public void setAdquirenteBandeira(String adquirenteBandeira) {
		this.adquirenteBandeira = adquirenteBandeira;
	}

	public String getBin() {
		return this.bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public String getBinEstendido() {
		return this.binEstendido;
	}

	public void setBinEstendido(String binEstendido) {
		this.binEstendido = binEstendido;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCodigoDestino() {
		return this.codigoDestino;
	}

	public void setCodigoDestino(String codigoDestino) {
		this.codigoDestino = codigoDestino;
	}

	public String getCodigoMoedaEmissor() {
		return this.codigoMoedaEmissor;
	}

	public void setCodigoMoedaEmissor(String codigoMoedaEmissor) {
		this.codigoMoedaEmissor = codigoMoedaEmissor;
	}

	public String getCodigoMoedaOrigem() {
		return this.codigoMoedaOrigem;
	}

	public void setCodigoMoedaOrigem(String codigoMoedaOrigem) {
		this.codigoMoedaOrigem = codigoMoedaOrigem;
	}

	public String getCodigoMoedaReferencia() {
		return this.codigoMoedaReferencia;
	}

	public void setCodigoMoedaReferencia(String codigoMoedaReferencia) {
		this.codigoMoedaReferencia = codigoMoedaReferencia;
	}

	public String getCodigoProcesamento() {
		return this.codigoProcesamento;
	}

	public void setCodigoProcesamento(String codigoProcesamento) {
		this.codigoProcesamento = codigoProcesamento;
	}

	public String getCodigoRespAdq() {
		return this.codigoRespAdq;
	}

	public void setCodigoRespAdq(String codigoRespAdq) {
		this.codigoRespAdq = codigoRespAdq;
	}

	public String getCodigoRespEmissor() {
		return this.codigoRespEmissor;
	}

	public void setCodigoRespEmissor(String codigoRespEmissor) {
		this.codigoRespEmissor = codigoRespEmissor;
	}

	public String getCodigoRespFinal() {
		return this.codigoRespFinal;
	}

	public void setCodigoRespFinal(String codigoRespFinal) {
		this.codigoRespFinal = codigoRespFinal;
	}

	public String getComercio() {
		return this.comercio;
	}

	public void setComercio(String comercio) {
		this.comercio = comercio;
	}

	public BigDecimal getConvVlorigemVlrefer() {
		return this.convVlorigemVlrefer;
	}

	public void setConvVlorigemVlrefer(BigDecimal convVlorigemVlrefer) {
		this.convVlorigemVlrefer = convVlorigemVlrefer;
	}

	public BigDecimal getConvVlreferVlemissor() {
		return this.convVlreferVlemissor;
	}

	public void setConvVlreferVlemissor(BigDecimal convVlreferVlemissor) {
		this.convVlreferVlemissor = convVlreferVlemissor;
	}

	public String getDataHoraGmt() {
		return this.dataHoraGmt;
	}

	public void setDataHoraGmt(String dataHoraGmt) {
		this.dataHoraGmt = dataHoraGmt;
	}

	public String getDataHoraLocal() {
		return this.dataHoraLocal;
	}

	public void setDataHoraLocal(String dataHoraLocal) {
		this.dataHoraLocal = dataHoraLocal;
	}

	public Date getDataHoraLog() {
		return this.dataHoraLog;
	}

	public void setDataHoraLog(Date dataHoraLog) {
		this.dataHoraLog = dataHoraLog;
	}

	public Timestamp getDataSistema() {
		return this.dataSistema;
	}

	public void setDataSistema(Timestamp dataSistema) {
		this.dataSistema = dataSistema;
	}

	public String getDe55Adquirente() {
		return this.de55Adquirente;
	}

	public void setDe55Adquirente(String de55Adquirente) {
		this.de55Adquirente = de55Adquirente;
	}

	public String getDe55Emissor() {
		return this.de55Emissor;
	}

	public void setDe55Emissor(String de55Emissor) {
		this.de55Emissor = de55Emissor;
	}

	public String getDetalheTipoTrans() {
		return this.detalheTipoTrans;
	}

	public void setDetalheTipoTrans(String detalheTipoTrans) {
		this.detalheTipoTrans = detalheTipoTrans;
	}

	public String getDs() {
		return this.ds;
	}

	public void setDs(String ds) {
		this.ds = ds;
	}

	public BigDecimal getDuracaoEmissor() {
		return this.duracaoEmissor;
	}

	public void setDuracaoEmissor(BigDecimal duracaoEmissor) {
		this.duracaoEmissor = duracaoEmissor;
	}

	public BigDecimal getDuracaoTotal() {
		return this.duracaoTotal;
	}

	public void setDuracaoTotal(BigDecimal duracaoTotal) {
		this.duracaoTotal = duracaoTotal;
	}

	public String getFraudScore() {
		return this.fraudScore;
	}

	public void setFraudScore(String fraudScore) {
		this.fraudScore = fraudScore;
	}

	public String getFuncao() {
		return this.funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getIdBandeira() {
		return this.idBandeira;
	}

	public void setIdBandeira(String idBandeira) {
		this.idBandeira = idBandeira;
	}

	public String getMcc() {
		return this.mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMensagemResposta() {
		return this.mensagemResposta;
	}

	public void setMensagemResposta(String mensagemResposta) {
		this.mensagemResposta = mensagemResposta;
	}

	public String getModoEntrada() {
		return this.modoEntrada;
	}

	public void setModoEntrada(String modoEntrada) {
		this.modoEntrada = modoEntrada;
	}

	public String getMti() {
		return this.mti;
	}

	public void setMti(String mti) {
		this.mti = mti;
	}

	public String getNode() {
		return this.node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getNomeCidade() {
		return this.nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getNomeComercio() {
		return this.nomeComercio;
	}

	public void setNomeComercio(String nomeComercio) {
		this.nomeComercio = nomeComercio;
	}

	public String getNomeRegiao() {
		return this.nomeRegiao;
	}

	public void setNomeRegiao(String nomeRegiao) {
		this.nomeRegiao = nomeRegiao;
	}

	public String getNsuAdq() {
		return this.nsuAdq;
	}

	public void setNsuAdq(String nsuAdq) {
		this.nsuAdq = nsuAdq;
	}

	public String getNsuEmissor() {
		return this.nsuEmissor;
	}

	public void setNsuEmissor(String nsuEmissor) {
		this.nsuEmissor = nsuEmissor;
	}

	public String getOnOff() {
		return this.onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public BigDecimal getQtdParcelas() {
		return this.qtdParcelas;
	}

	public void setQtdParcelas(BigDecimal qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public BigDecimal getRefid() {
		return this.refid;
	}

	public void setRefid(BigDecimal refid) {
		this.refid = refid;
	}

	public String getRrnAdq() {
		return this.rrnAdq;
	}

	public void setRrnAdq(String rrnAdq) {
		this.rrnAdq = rrnAdq;
	}

	public String getSs() {
		return this.ss;
	}

	public void setSs(String ss) {
		this.ss = ss;
	}

	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getTipoTerminal() {
		return this.tipoTerminal;
	}

	public void setTipoTerminal(String tipoTerminal) {
		this.tipoTerminal = tipoTerminal;
	}

	public String getTipoTrans() {
		return this.tipoTrans;
	}

	public void setTipoTrans(String tipoTrans) {
		this.tipoTrans = tipoTrans;
	}

	public BigDecimal getValorEmissor() {
		return this.valorEmissor;
	}

	public void setValorEmissor(BigDecimal valorEmissor) {
		this.valorEmissor = valorEmissor;
	}

	public BigDecimal getValorOrigem() {
		return this.valorOrigem;
	}

	public void setValorOrigem(BigDecimal valorOrigem) {
		this.valorOrigem = valorOrigem;
	}

	public BigDecimal getValorReferencia() {
		return this.valorReferencia;
	}

	public void setValorReferencia(BigDecimal valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

}