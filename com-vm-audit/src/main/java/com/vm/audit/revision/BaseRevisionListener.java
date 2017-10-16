package com.vm.audit.revision;

import org.hibernate.envers.RevisionListener;
/*import org.jboss.seam.security.Identity;
import org.jboss.seam.Component;*/

public class BaseRevisionListener implements RevisionListener {
	
	public final static String USERNAME = "Victor";

	@Override
	public void newRevision(Object revisionEntity) {
		BaseRevEntity baseRevEntity = (BaseRevEntity) revisionEntity;
		baseRevEntity.setUserName(USERNAME);
		baseRevEntity.setAuditAction(Action.INSERTED);
	}
}
