package br.com.cabal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TRX_BAND_CABAL_SUPORTE database table.
 * 
 */
@Embeddable
public class TrxBandCabalSuportePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_TRX_BAND_CABAL")
	private String idTrxBandCabal;

	private String origem;

	public TrxBandCabalSuportePK() {
	}
	public String getIdTrxBandCabal() {
		return this.idTrxBandCabal;
	}
	public void setIdTrxBandCabal(String idTrxBandCabal) {
		this.idTrxBandCabal = idTrxBandCabal; 
	}
	public String getOrigem() {
		return this.origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TrxBandCabalSuportePK)) {
			return false;
		}
		TrxBandCabalSuportePK castOther = (TrxBandCabalSuportePK)other;
		return 
			this.idTrxBandCabal.equals(castOther.idTrxBandCabal)
			&& this.origem.equals(castOther.origem);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idTrxBandCabal.hashCode();
		hash = hash * prime + this.origem.hashCode();
		
		return hash;
	}
}