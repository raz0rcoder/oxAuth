/*
 * oxAuth is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2014, Gluu
 */

package org.xdi.oxauth.model.common;

import org.apache.commons.lang.StringUtils;
import org.xdi.oxauth.model.configuration.AppConfiguration;
import org.xdi.oxauth.model.registration.Client;

import javax.enterprise.inject.Instance;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Javier Rojas Blum
 * @version July 31, 2019
 */
public class CIBACacheGrant implements Serializable {

    private String authorizationRequestId;
    private User user;
    private Client client;
    private Set<String> scopes;
    private String grantId;

    private String sessionDn;
    private int expiresIn = 1;

    public CIBACacheGrant() {
    }

    public CIBACacheGrant(CIBAGrant grant, AppConfiguration appConfiguration) {
        if (grant.getCIBAAuthenticationRequestId() != null) {
            authorizationRequestId = grant.getCIBAAuthenticationRequestId().getCode();
        }
        initExpiresIn(grant, appConfiguration);

        user = grant.getUser();
        client = grant.getClient();
        scopes = grant.getScopes();
        grantId = grant.getGrantId();
        sessionDn = grant.getSessionDn();
    }

    private void initExpiresIn(CIBAGrant grant, AppConfiguration appConfiguration) {
        if (grant.getCIBAAuthenticationRequestId() != null) {
            expiresIn = grant.getCIBAAuthenticationRequestId().getExpiresIn();
        } else {
            expiresIn = appConfiguration.getBackchannelAuthenticationResponseExpiresIn();
        }
    }

    public CIBAGrant asCIBAGrant(Instance<AbstractAuthorizationGrant> grantInstance) {
        CIBAGrant grant = grantInstance.select(CIBAGrant.class).get();
        grant.init(user, client, expiresIn);

        grant.setCIBAAuthenticationRequestId(new CIBAAuthenticationRequestId(expiresIn));
        grant.setScopes(scopes);
        grant.setGrantId(grantId);
        grant.setSessionDn(sessionDn);

        return grant;
    }

    public String cacheKey() {
        return cacheKey(authorizationRequestId, grantId);
    }

    public static String cacheKey(String authorizationRequestId, String grantId) {
        if (StringUtils.isBlank(authorizationRequestId)) {
            return grantId;
        }
        return authorizationRequestId;
    }

    public int getExpiresIn() {
        return expiresIn;
    }
}