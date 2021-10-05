package com.appgate.calc.infra.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.type.StringType;

import java.sql.Types;

/**
 * The Class SQLiteDialect.
 * 
 * @author <a href="mailto:jorgeromen27@gmail.com">Jorge Romero</a>.
 * @version 1.0.0
 * @since 1.0.0
 */
public class SQLiteDialect extends Dialect {

    /**
     * Instantiates a new SQ lite dialect.
     */
    public SQLiteDialect() {
        registerColumnType(Types.BIT, "integer");
        registerColumnType(Types.TINYINT, "tinyint");
        registerColumnType(Types.SMALLINT, "smallint");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "bigint");
        registerColumnType(Types.FLOAT, "float");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "numeric");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "char");
        registerColumnType(Types.VARCHAR, "varchar");
        registerColumnType(Types.LONGVARCHAR, "longvarchar");
        registerColumnType(Types.DATE, "date");
        registerColumnType(Types.TIME, "time");
        registerColumnType(Types.TIMESTAMP, "timestamp");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "clob");
        registerColumnType(Types.BOOLEAN, "integer");

        registerFunction("concat", new VarArgsSQLFunction(StringType.INSTANCE, "", "||", ""));
        registerFunction("mod", new SQLFunctionTemplate(StringType.INSTANCE, "?1 % ?2"));
        registerFunction("substr", new StandardSQLFunction("substr", StringType.INSTANCE));
        registerFunction("substring", new StandardSQLFunction("substr", StringType.INSTANCE));
    }

    /**
     * Supports identity columns.
     *
     * @return true, if successful
     */
    public boolean supportsIdentityColumns() {
        return true;
    }

    /**
     * Checks for data type in identity column.
     *
     * @return true, if successful
     */
    public boolean hasDataTypeInIdentityColumn() {
        return false;
    }

    /**
     * Gets the identity column string.
     *
     * @return the identity column string
     */
    public String getIdentityColumnString() {
        return "integer";
    }

    /**
     * Gets the identity select string.
     *
     * @return the identity select string
     */
    public String getIdentitySelectString() {
        return "select last_insert_rowid()";
    }

    /**
     * Supports limit.
     *
     * @return true, if successful
     */
    public boolean supportsLimit() {
        return true;
    }

    /**
     * Gets the limit string.
     *
     * @param query the query
     * @param hasOffset the has offset
     * @return the limit string
     */
    protected String getLimitString(String query, boolean hasOffset) {
        return new StringBuffer(query.length() + 20).append(query).append(hasOffset ? " limit ? offset ?" : " limit ?")
                .toString();
    }

    /**
     * Supports temporary tables.
     *
     * @return true, if successful
     */
    public boolean supportsTemporaryTables() {
        return true;
    }

    /**
     * Gets the creates the temporary table string.
     *
     * @return the creates the temporary table string
     */
    public String getCreateTemporaryTableString() {
        return "create temporary table if not exists";
    }

    /**
     * Drop temporary table after use.
     *
     * @return true, if successful
     */
    public boolean dropTemporaryTableAfterUse() {
        return false;
    }

    /**
     * Supports current timestamp selection.
     *
     * @return true, if successful
     */
    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    /**
     * Checks if is current timestamp select string callable.
     *
     * @return true, if is current timestamp select string callable
     */
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    /**
     * Gets the current timestamp select string.
     *
     * @return the current timestamp select string
     */
    public String getCurrentTimestampSelectString() {
        return "select current_timestamp";
    }

    /**
     * Supports union all.
     *
     * @return true, if successful
     */
    public boolean supportsUnionAll() {
        return true;
    }

    /**
     * Checks for alter table.
     *
     * @return true, if successful
     */
    public boolean hasAlterTable() {
        return false;
    }

    /**
     * Drop constraints.
     *
     * @return true, if successful
     */
    public boolean dropConstraints() {
        return false;
    }

    /**
     * Gets the adds the column string.
     *
     * @return the adds the column string
     */
    public String getAddColumnString() {
        return "add column";
    }

    /**
     * Gets the for update string.
     *
     * @return the for update string
     */
    public String getForUpdateString() {
        return "";
    }

    /**
     * Supports outer join for update.
     *
     * @return true, if successful
     */
    public boolean supportsOuterJoinForUpdate() {
        return false;
    }

    /**
     * Gets the drop foreign key string.
     *
     * @return the drop foreign key string
     */
    public String getDropForeignKeyString() {
        throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
    }

    /**
     * Gets the adds the foreign key constraint string.
     *
     * @param constraintName the constraint name
     * @param foreignKey the foreign key
     * @param referencedTable the referenced table
     * @param primaryKey the primary key
     * @param referencesPrimaryKey the references primary key
     * @return the adds the foreign key constraint string
     */
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable,
                                                   String[] primaryKey, boolean referencesPrimaryKey) {
        throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
    }

    /**
     * Gets the adds the primary key constraint string.
     *
     * @param constraintName the constraint name
     * @return the adds the primary key constraint string
     */
    public String getAddPrimaryKeyConstraintString(String constraintName) {
        throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
    }

    /**
     * Supports if exists before table name.
     *
     * @return true, if successful
     */
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

    /**
     * Supports cascade delete.
     *
     * @return true, if successful
     */
    public boolean supportsCascadeDelete() {
        return false;
    }
}