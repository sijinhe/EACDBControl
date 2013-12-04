/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eac.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sijin
 */
@Embeddable
public class ServerHasContainerPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "server_idServer")
    private String serveridServer;
    @Basic(optional = false)
    @Column(name = "container_idContainer")
    private String containeridContainer;

    public ServerHasContainerPK() {
    }

    public ServerHasContainerPK(String serveridServer, String containeridContainer) {
        this.serveridServer = serveridServer;
        this.containeridContainer = containeridContainer;
    }

    public String getServeridServer() {
        return serveridServer;
    }

    public void setServeridServer(String serveridServer) {
        this.serveridServer = serveridServer;
    }

    public String getContaineridContainer() {
        return containeridContainer;
    }

    public void setContaineridContainer(String containeridContainer) {
        this.containeridContainer = containeridContainer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serveridServer != null ? serveridServer.hashCode() : 0);
        hash += (containeridContainer != null ? containeridContainer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServerHasContainerPK)) {
            return false;
        }
        ServerHasContainerPK other = (ServerHasContainerPK) object;
        if ((this.serveridServer == null && other.serveridServer != null) || (this.serveridServer != null && !this.serveridServer.equals(other.serveridServer))) {
            return false;
        }
        if ((this.containeridContainer == null && other.containeridContainer != null) || (this.containeridContainer != null && !this.containeridContainer.equals(other.containeridContainer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eac.db.entity.ServerHasContainerPK[serveridServer=" + serveridServer + ", containeridContainer=" + containeridContainer + "]";
    }

}
