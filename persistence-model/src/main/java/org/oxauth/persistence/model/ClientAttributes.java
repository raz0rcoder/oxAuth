package org.oxauth.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Yuriy Zabrovarnyy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientAttributes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 213428216912083393L;

	@JsonProperty("tlsClientAuthSubjectDn")
	private String tlsClientAuthSubjectDn;

    @JsonProperty("runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims")
    private Boolean runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims = false;

    @JsonProperty("keepClientAuthorizationAfterExpiration")
    private Boolean keepClientAuthorizationAfterExpiration = false;

	public String getTlsClientAuthSubjectDn() {
		return tlsClientAuthSubjectDn;
	}

	public void setTlsClientAuthSubjectDn(String tlsClientAuthSubjectDn) {
		this.tlsClientAuthSubjectDn = tlsClientAuthSubjectDn;
	}

    public Boolean getRunIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims() {
	    if (runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims == null) {
            runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims = false;
        }
        return runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims;
    }

    public void setRunIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims(Boolean runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims) {
        this.runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims = runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims;
    }

    public Boolean getKeepClientAuthorizationAfterExpiration() {
	    if (keepClientAuthorizationAfterExpiration == null) {
            keepClientAuthorizationAfterExpiration = false;
        }
        return keepClientAuthorizationAfterExpiration;
    }

    public void setKeepClientAuthorizationAfterExpiration(Boolean keepClientAuthorizationAfterExpiration) {
        this.keepClientAuthorizationAfterExpiration = keepClientAuthorizationAfterExpiration;
    }

    @Override
    public String toString() {
        return "ClientAttributes{" +
                "tlsClientAuthSubjectDn='" + tlsClientAuthSubjectDn + '\'' +
                ", runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims=" + runIntrospectionScriptBeforeAccessTokenAsJwtCreationAndIncludeClaims +
                ", keepClientAuthorizationAfterExpiration=" + keepClientAuthorizationAfterExpiration +
                '}';
    }
}
