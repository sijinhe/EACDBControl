/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eac.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sijin
 */
@Entity
@Table(name = "history")
@NamedQueries({
    @NamedQuery(name = "History.findAll", query = "SELECT h FROM History h"),
    @NamedQuery(name = "History.findByIdhistory", query = "SELECT h FROM History h WHERE h.idhistory = :idhistory"),
    @NamedQuery(name = "History.findByTimestamp", query = "SELECT h FROM History h WHERE h.timestamp = :timestamp"),
    @NamedQuery(name = "History.findByHits", query = "SELECT h FROM History h WHERE h.hits = :hits"),
    @NamedQuery(name = "History.findByDurationsSquareSum", query = "SELECT h FROM History h WHERE h.durationsSquareSum = :durationsSquareSum"),
    @NamedQuery(name = "History.findByCpuTimeSum", query = "SELECT h FROM History h WHERE h.cpuTimeSum = :cpuTimeSum"),
    @NamedQuery(name = "History.findByDurationsSum", query = "SELECT h FROM History h WHERE h.durationsSum = :durationsSum"),
    @NamedQuery(name = "History.findByResponseSizesSum", query = "SELECT h FROM History h WHERE h.responseSizesSum = :responseSizesSum"),
    @NamedQuery(name = "History.findBySystemErrors", query = "SELECT h FROM History h WHERE h.systemErrors = :systemErrors"),
    @NamedQuery(name = "History.findByUsedmemory", query = "SELECT h FROM History h WHERE h.usedmemory = :usedmemory"),
    @NamedQuery(name = "History.findByMaxmemory", query = "SELECT h FROM History h WHERE h.maxmemory = :maxmemory"),
    @NamedQuery(name = "History.findByIdServer", query = "SELECT h FROM History h WHERE h.idServer = :idServer"),
    @NamedQuery(name = "History.findByIdContainer", query = "SELECT h FROM History h WHERE h.idContainer = :idContainer")})
public class History implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idhistory")
    private String idhistory;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "hits")
    private Integer hits;
    @Column(name = "durationsSquareSum")
    private Integer durationsSquareSum;
    @Column(name = "cpuTimeSum")
    private Integer cpuTimeSum;
    @Column(name = "durationsSum")
    private Integer durationsSum;
    @Column(name = "responseSizesSum")
    private Integer responseSizesSum;
    @Column(name = "systemErrors")
    private Integer systemErrors;
    @Column(name = "usedmemory")
    private Integer usedmemory;
    @Column(name = "maxmemory")
    private Integer maxmemory;
    @Column(name = "idServer")
    private String idServer;
    @Column(name = "idContainer")
    private String idContainer;
    @JoinColumns({
        @JoinColumn(name = "server_has_container_container_idContainer", referencedColumnName = "container_idContainer"),
        @JoinColumn(name = "server_has_container_server_idServer", referencedColumnName = "server_idServer")})
    @ManyToOne
    private ServerHasContainer serverHasContainer;

    public History() {
    }

    public History(String idhistory) {
        this.idhistory = idhistory;
    }

    public String getIdhistory() {
        return idhistory;
    }

    public void setIdhistory(String idhistory) {
        this.idhistory = idhistory;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getDurationsSquareSum() {
        return durationsSquareSum;
    }

    public void setDurationsSquareSum(Integer durationsSquareSum) {
        this.durationsSquareSum = durationsSquareSum;
    }

    public Integer getCpuTimeSum() {
        return cpuTimeSum;
    }

    public void setCpuTimeSum(Integer cpuTimeSum) {
        this.cpuTimeSum = cpuTimeSum;
    }

    public Integer getDurationsSum() {
        return durationsSum;
    }

    public void setDurationsSum(Integer durationsSum) {
        this.durationsSum = durationsSum;
    }

    public Integer getResponseSizesSum() {
        return responseSizesSum;
    }

    public void setResponseSizesSum(Integer responseSizesSum) {
        this.responseSizesSum = responseSizesSum;
    }

    public Integer getSystemErrors() {
        return systemErrors;
    }

    public void setSystemErrors(Integer systemErrors) {
        this.systemErrors = systemErrors;
    }

    public Integer getUsedmemory() {
        return usedmemory;
    }

    public void setUsedmemory(Integer usedmemory) {
        this.usedmemory = usedmemory;
    }

    public Integer getMaxmemory() {
        return maxmemory;
    }

    public void setMaxmemory(Integer maxmemory) {
        this.maxmemory = maxmemory;
    }

    public String getIdServer() {
        return idServer;
    }

    public void setIdServer(String idServer) {
        this.idServer = idServer;
    }

    public String getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(String idContainer) {
        this.idContainer = idContainer;
    }

    public ServerHasContainer getServerHasContainer() {
        return serverHasContainer;
    }

    public void setServerHasContainer(ServerHasContainer serverHasContainer) {
        this.serverHasContainer = serverHasContainer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistory != null ? idhistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.idhistory == null && other.idhistory != null) || (this.idhistory != null && !this.idhistory.equals(other.idhistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eac.db.entity.History[idhistory=" + idhistory + "]";
    }

}
