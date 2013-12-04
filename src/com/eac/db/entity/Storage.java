/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eac.db.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "storage")
@NamedQueries({
    @NamedQuery(name = "Storage.findAll", query = "SELECT s FROM Storage s"),
    @NamedQuery(name = "Storage.findByIdStorage", query = "SELECT s FROM Storage s WHERE s.idStorage = :idStorage"),
    @NamedQuery(name = "Storage.findByPublicIp", query = "SELECT s FROM Storage s WHERE s.publicIp = :publicIp"),
    @NamedQuery(name = "Storage.findByPublicPort", query = "SELECT s FROM Storage s WHERE s.publicPort = :publicPort"),
    @NamedQuery(name = "Storage.findByPrivateIp", query = "SELECT s FROM Storage s WHERE s.privateIp = :privateIp"),
    @NamedQuery(name = "Storage.findByPrivatePort", query = "SELECT s FROM Storage s WHERE s.privatePort = :privatePort"),
    @NamedQuery(name = "Storage.findByStatus", query = "SELECT s FROM Storage s WHERE s.status = :status"),
    @NamedQuery(name = "Storage.findByType", query = "SELECT s FROM Storage s WHERE s.type = :type")})
public class Storage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idStorage")
    private String idStorage;
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
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "storage")
    private Collection<Container> containerCollection;

    public Storage() {
    }

    public Storage(String idStorage) {
        this.idStorage = idStorage;
    }

    public Storage(String idStorage, String type) {
        this.idStorage = idStorage;
        this.type = type;
    }

    public String getIdStorage() {
        return idStorage;
    }

    public void setIdStorage(String idStorage) {
        this.idStorage = idStorage;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStorage != null ? idStorage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storage)) {
            return false;
        }
        Storage other = (Storage) object;
        if ((this.idStorage == null && other.idStorage != null) || (this.idStorage != null && !this.idStorage.equals(other.idStorage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eac.db.entity.Storage[idStorage=" + idStorage + "]";
    }

}
