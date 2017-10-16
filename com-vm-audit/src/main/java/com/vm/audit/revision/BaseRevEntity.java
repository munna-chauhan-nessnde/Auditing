package com.vm.audit.revision;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@RevisionEntity(BaseRevisionListener.class)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REVINFO_USER", catalog = "dbo")
@EqualsAndHashCode(callSuper=false)
public @Data class BaseRevEntity /*extends DefaultRevisionEntity*/implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@RevisionNumber
	@Column(name="AUDIT_ID")
	private Integer id;
	
	@Column(name="AUDIT_ACTION")
	private Action auditAction;
	
	@Column(name="AUDIT_USER_NAME")
	private String userName;
	
	@Version
    @RevisionTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="AUDIT_TIMESTAMP")
    private Date timestamp;
}
