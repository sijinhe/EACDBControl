/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eac.db.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "server")
@NamedQueries({
    @NamedQuery(name = "Server.findAll", query = "SELECT s FROM Server s"),
    @NamedQuery(name = "Server.findByIdServer", query = "SELECT s FROM Server s WHERE s.idServer = :idServer"),
    @NamedQuery(name = "Server.findByIp", query = "SELECT s FROM Server s WHERE s.ip = :ip"),
    @NamedQuery(name = "Server.findByPort", query = "SELECT s FROM Server s WHERE s.port = :port"),
    @NamedQuery(name = "Server.findByStatus", query = "SELECT s FROM Server s WHERE s.status = :status"),
    @NamedQuery(name = "Server.findByHomePath", query = "SELECT s FROM Server s WHERE s.homePath = :homePath"),
    @NamedQuery(name = "Server.findByType", query = "SELECT s FROM Server s WHERE s.type = :type")})
public class Server implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idServer")
    private String idServer;
    @Column(name = "ip")
    private String ip;
    @Column(name = "port")
    private String port;
    @Column(name = "status")
    private String status;
    @Column(name = "homePath")
    private String homePath;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "server")
    private Collection<ServerHasContainer> serverHasContainerCollection;
    @JoinColumn(name = "cluster_idCluster", referencedColumnName = "idCluster")
    @ManyToOne(optional = false)
    private Cluster cluster;

    public Server() {
    }

    public Server(String idServer) {
        this.idServer = idServer;
    }

    public Server(String idServer, String type) {
        this.idServer = idServer;
        this.type = type;
    }

    public String getIdServer() {
        return idServer;
    }

    public void setIdServer(String idServer) {
        this.idServer = idServer;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHomePath() {
        return homePath;
    }

    public void setHomePath(String homePath) {
        this.homePath = homePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<ServerHasContainer> getServerHasContainerCollection() {
        return serverHasContainerCollection;
    }

    public void setServerHasContainerCollection(Collection<ServerHasContainer> serverHasContainerCollection) {
        this.serverHasContainerCollection = serverHasContainerCollection;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServer != null ? idServer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Server)) {
            return false;
        }
        Server other = (Server) object;
        if ((this.idServer == null && other.idServer != null) || (this.idServer != null && !this.idServer.equals(other.idServer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eac.db.entity.Server[idServer=" + idServer + "]";
    }

}
