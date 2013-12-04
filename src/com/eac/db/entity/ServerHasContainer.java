/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eac.db.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sijin
 */
@Entity
@Table(name = "server_has_container")
@NamedQueries({
    @NamedQuery(name = "ServerHasContainer.findAll", query = "SELECT s FROM ServerHasContainer s"),
    @NamedQuery(name = "ServerHasContainer.findByServeridServer", query = "SELECT s FROM ServerHasContainer s WHERE s.serverHasContainerPK.serveridServer = :serveridServer"),
    @NamedQuery(name = "ServerHasContainer.findByContaineridContainer", query = "SELECT s FROM ServerHasContainer s WHERE s.serverHasContainerPK.containeridContainer = :containeridContainer")})
public class ServerHasContainer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServerHasContainerPK serverHasContainerPK;
    @OneToMany(mappedBy = "serverHasContainer")
    private Collection<History> historyCollection;
    @JoinColumn(name = "server_idServer", referencedColumnName = "idServer", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Server server;
    @JoinColumn(name = "container_idContainer", referencedColumnName = "idContainer", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Container container;

    public ServerHasContainer() {
    }

    public ServerHasContainer(ServerHasContainerPK serverHasContainerPK) {
        this.serverHasContainerPK = serverHasContainerPK;
    }

    public ServerHasContainer(String serveridServer, String containeridContainer) {
        this.serverHasContainerPK = new ServerHasContainerPK(serveridServer, containeridContainer);
    }

    public ServerHasContainerPK getServerHasContainerPK() {
        return serverHasContainerPK;
    }

    public void setServerHasContainerPK(ServerHasContainerPK serverHasContainerPK) {
        this.serverHasContainerPK = serverHasContainerPK;
    }

    public Collection<History> getHistoryCollection() {
        return historyCollection;
    }

    public void setHistoryCollection(Collection<History> historyCollection) {
        this.historyCollection = historyCollection;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serverHasContainerPK != null ? serverHasContainerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServerHasContainer)) {
            return false;
        }
        ServerHasContainer other = (ServerHasContainer) object;
        if ((this.serverHasContainerPK == null && other.serverHasContainerPK != null) || (this.serverHasContainerPK != null && !this.serverHasContainerPK.equals(other.serverHasContainerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eac.db.entity.ServerHasContainer[serverHasContainerPK=" + serverHasContainerPK + "]";
    }

}
