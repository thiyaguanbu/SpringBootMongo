package com.perfm.services.model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;

public class AbstractDocument {
	
	@Id
	private BigInteger documentId;

	public BigInteger getDocumentId() {
		return documentId;
	}

	public void setDocumentId(BigInteger documentId) {
		this.documentId = documentId;
	}
	
	

}
