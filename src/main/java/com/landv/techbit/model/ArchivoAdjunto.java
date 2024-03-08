package com.landv.techbit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Robin
 */
@Entity
@Table(name = "archivo_adjunto")
@NamedQueries({
    @NamedQuery(name = "ArchivoAdjunto.findAll", query = "SELECT a FROM ArchivoAdjunto a")})
public class ArchivoAdjunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "files_id")
    private Long filesId;

    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 255)
    @Column(name = "ftp_url")
    private String ftpUrl;

    public ArchivoAdjunto() {
    }

    public ArchivoAdjunto(Long filesId, String nombre, String ftpUrl) {
        this.filesId = filesId;
        this.nombre = nombre;
        this.ftpUrl = ftpUrl;
    }

    public ArchivoAdjunto(Long filesId) {
        this.filesId = filesId;
    }

    public Long getFilesId() {
        return filesId;
    }

    public void setFilesId(Long filesId) {
        this.filesId = filesId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFtpUrl() {
        return ftpUrl;
    }

    public void setFtpUrl(String ftpUrl) {
        this.ftpUrl = ftpUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filesId != null ? filesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivoAdjunto)) {
            return false;
        }
        ArchivoAdjunto other = (ArchivoAdjunto) object;
        if ((this.filesId == null && other.filesId != null) || (this.filesId != null && !this.filesId.equals(other.filesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArchivoAdjunto{" + "filesId=" + filesId + ", nombre=" + nombre + ", ftpUrl=" + ftpUrl + '}';
    }

}
