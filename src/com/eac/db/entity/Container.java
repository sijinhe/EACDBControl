/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eac.db.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sijin
 */
@Entity
@Table(name = "container")
@NamedQueries({
    @NamedQuery(name = "Container.findAll", query = "SELECT c FROM Container c"),
    @NamedQuery(name = "Container.findByIdContainer", query = "SELECT c FROM Container c WHERE c.idContainer = :idContainer"),
    @NamedQuery(name = "Container.findByContainerName", query = "SELECT c FROM Container c WHERE c.containerName = :containerName"),
    @NamedQuery(name = "Container.findByLogin", query = "SELECT c FROM Container c WHERE c.login = :login"),
    @NamedQuery(name = "Container.findByAppName", query = "SELECT c FROM Container c WHERE c.appName = :appName"),
    @NamedQuery(name = "Container.findByAppStatus", query = "SELECT c FROM Container c WHERE c.appStatus = :appStatus"),
    @NamedQuery(name = "Container.findByUpload", query = "SELECT c FROM Container c WHERE c.upload = :upload"),
    @NamedQuery(name = "Container.findByHitRate", query = "SELECT c FROM Container c WHERE c.hitRate = :hitRate"),
    @NamedQuery(name = "Container.findByDbName", query = "SELECT c FROM Container c WHERE c.dbName = :dbName"),
    @NamedQuery(name = "Container.findByDbStatus", query = "SELECT c FROM Container c WHERE c.dbStatus = :dbStatus"),
    @NamedQuery(name = "Container.findByMaxConnection", query = "SELECT c FROM Container c WHERE c.maxConnection = :maxConnection"),
    @NamedQuery(name = "Container.findByInstanceNo", query = "SELECT c FROM Container c WHERE c.instanceNo = :instanceNo"),
    @NamedQuery(name = "Container.findByDbPassword", query = "SELECT c FROM Container c WHERE c.dbPassword = :dbPassword"),
    @NamedQuery(name = "Container.findByCreationDate", query = "SELECT c FROM Container c WHERE c.creationDate = :creationDate"),
    @NamedQuery(name = "Container.findByDiskSize", query = "SELECT c FROM Container c WHERE c.diskSize = :diskSize")})
public class Container implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idContainer")
    private String idContainer;
    @Column(name = "containerName")
    private String containerName;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Column(name = "appName")
    private String appName;
    @Basic(optional = false)
    @Column(name = "appStatus")
    private String appStatus;
    @Column(name = "upload")
    private String upload;
    @Column(name = "hitRate")
    private Integer hitRate;
    @Column(name = "dbName")
    private String dbName;
    @Basic(optional = false)
    @Column(name = "dbStatus")
    private String dbStatus;
    @Column(name = "maxConnection")
    private Integer maxConnection;
    @Column(name = "instanceNo")
    private Integer instanceNo;
    @Column(name = "dbPassword")
    private String dbPassword;
    @Column(name = "creationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "diskSize")
    private Integer diskSize;
    @JoinColumn(name = "cluster_idCluster", referencedColumnName = "idCluster")
    @ManyToOne
    private Cluster cluster;
    @JoinColumn(name = "storage_idStorage", referencedColumnName = "idStorage")
    @ManyToOne
    private Storage storage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "container")
    private Collection<ServerHasContainer> serverHasContainerCollection;

    public Container() {
    }

    public Container(String idContainer) {
        this.idContainer = idContainer;
    }

    public Container(String idContainer, String login, String appStatus, String dbStatus) {
        this.idContainer = idContainer;
        this.login = login;
        this.appStatus = appStatus;
        this.dbStatus = dbStatus;
    }

    public String getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(String idContainer) {
        this.idContainer = idContainer;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public Integer getHitRate() {
        return hitRate;
    }

    public void setHitRate(Integer hitRate) {
        this.hitRate = hitRate;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(String dbStatus) {
        this.dbStatus = dbStatus;
    }

    public Integer getMaxConnection() {
        return maxConnection;
    }

    public void setMaxConnection(Integer maxConnection) {
        this.maxConnection = maxConnection;
    }

    public Integer getInstanceNo() {
        return instanceNo;
    }

    public void setInstanceNo(Integer instanceNo) {
        this.instanceNo = instanceNo;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Collection<ServerHasContainer> getServerHasContainerCollection() {
        return serverHasContainerCollection;
    }

    public void setServerHasContainerCollection(Collection<ServerHasContainer> serverHasContainerCollection) {
        this.serverHasContainerCollection = serverHasContainerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContainer != null ? idContainer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Container)) {
            return false;
        }
        Container other = (Container) object;
        if ((this.idContainer == null && other.idContainer != null) || (this.idContainer != null && !this.idContainer.equals(other.idContainer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eac.db.entity.Container[idContainer=" + idContainer + "]";
    }

}
