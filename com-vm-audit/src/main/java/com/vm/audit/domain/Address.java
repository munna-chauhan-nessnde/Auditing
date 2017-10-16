package com.vm.audit.domain;

import javax.persistence.Column;
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
@Table(name = "ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Audited
@AuditTable(value = "ADDRESS_AUDIT")
public @Data class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "ADD_ID")
	private Long addId;
	@Column(name= "ADD_NAME")
	private String addName;
}
