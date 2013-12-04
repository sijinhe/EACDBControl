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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sijin
 */
@Entity
@Table(name = "cluster")
@NamedQueries({
    @NamedQuery(name = "Cluster.findAll", query = "SELECT c FROM Cluster c"),
    @NamedQuery(name = "Cluster.findByIdCluster", query = "SELECT c FROM Cluster c WHERE c.idCluster = :idCluster"),
    @NamedQuery(name = "Cluster.findByPublicIp", query = "SELECT c FROM Cluster c WHERE c.publicIp = :publicIp"),
    @NamedQuery(name = "Cluster.findByPublicPort", query = "SELECT c FROM Cluster c WHERE c.publicPort = :publicPort"),
    @NamedQuery(name = "Cluster.findByPrivateIp", query = "SELECT c FROM Cluster c WHERE c.privateIp = :privateIp"),
    @NamedQuery(name = "Cluster.findByPrivatePort", query = "SELECT c FROM Cluster c WHERE c.privatePort = :privatePort"),
    @NamedQuery(name = "Cluster.findByStatus", query = "SELECT c FROM Cluster c WHERE c.status = :status"),
    @NamedQuery(name = "Cluster.findByHomePath", query = "SELECT c FROM Cluster c WHERE c.homePath = :homePath"),
    @NamedQuery(name = "Cluster.findByType", query = "SELECT c FROM Cluster c WHERE c.type = :type")})
public class Cluster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCluster")
    private String idCluster;
    @Column(name = "publicIp")
    private String publicIp;
    @Column(name = "publicPort")
    private String publicPort;
    @Column(name = "privateIp")
    private String privateIp;
    @Column(name = "privatePort")
    private String privatePort;
    @Column(name = "status")
    private String status;
    @Column(name = "homePath")
    private String homePath;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "cluster")
    private Collection<Container> containerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cluster")
    private Collection<Server> serverCollection;

    public Cluster() {
    }

    public Cluster(String idCluster) {
        this.idCluster = idCluster;
    }

    public Cluster(String idCluster, String type) {
        this.idCluster = idCluster;
        this.type = type;
    }

    public String getIdCluster() {
        return idCluster;
    }

    public void setIdCluster(String idCluster) {
        this.idCluster = idCluster;
    }

    public String getPublicIp() {
        return publicIp;
    }

    public void setPublicIp(String publicIp) {
        this.publicIp = publicIp;
    }

    public String getPublicPort() {
        return publicPort;
    }

    public void setPublicPort(String publicPort) {
        this.publicPort = publicPort;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        this.privateIp = privateIp;
    }

    public String getPrivatePort() {
        return privatePort;
    }

    public void setPrivatePort(String privatePort) {
        this.privatePort = privatePort;
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

    public Collection<Container> getContainerCollection() {
        return containerCollection;
    }

    public void setContainerCollection(Collection<Container> containerCollection) {
        this.containerCollection = containerCollection;
    }

    public Collection<Server> getServerCollection() {
        return serverCollection;
    }

    public void setServerCollection(Collection<Server> serverCollection) {
        this.serverCollection = serverCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCluster != null ? idCluster.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cluster)) {
            return false;
        }
        Cluster other = (Cluster) object;
        if ((this.idCluster == null && other.idCluster != null) || (this.idCluster != null && !this.idCluster.equals(other.idCluster))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eac.db.entity.Cluster[idCluster=" + idCluster + "]";
    }

}
