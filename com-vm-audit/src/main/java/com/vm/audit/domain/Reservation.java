package com.vm.audit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "RESERVATION")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Audited
@AuditTable(value = "RESERVATION_AUDIT"/*, catalog ="", schema="C##VMDEV"*/)
//control/specify the name of the global REVINFO table using the @RevisionEntity annotation.
//@RevisionEntity
public @Data class Reservation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long addId;
	private String resName;
	private String resDiscription;
	//@ManyToOne
	//@JoinColumn(name= "ADD_NAME")
	//private Address address;
}
/*The "revision type" field can currently have three values: 0, 1, 2, which means, respectively, ADD, MOD and DEL.
A row with a revision of type DEL will only contain the id of the entity and no data (all fields NULL), 
as it only serves as a marker saying "this entity was deleted at that revision".*/

///http://docs.jboss.org/envers/docs/#configuration
//http://docs.jboss.org/envers/docs/#revisionlog