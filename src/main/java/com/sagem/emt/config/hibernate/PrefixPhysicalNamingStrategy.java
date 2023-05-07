package com.sagem.emt.config.hibernate;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PrefixPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    private static final long  serialVersionUID	 = -7502637782572250518L;
    public static final String TABLE_NAME_PREFIX = "emt_";

    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment context) {
	Identifier newIdentifier = new Identifier(TABLE_NAME_PREFIX + logicalName.getText(), logicalName.isQuoted());
	return super.toPhysicalTableName(newIdentifier, context);
    }
}
