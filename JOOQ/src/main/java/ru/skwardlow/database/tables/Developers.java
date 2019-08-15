/*
 * This file is generated by jOOQ.
 */
package ru.skwardlow.database.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;

import ru.skwardlow.database.DefaultSchema;
import ru.skwardlow.database.tables.records.DevelopersRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Developers extends TableImpl<DevelopersRecord> {

    private static final long serialVersionUID = -780115930;

    /**
     * The reference instance of <code>Developers</code>
     */
    public static final Developers DEVELOPERS = new Developers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DevelopersRecord> getRecordType() {
        return DevelopersRecord.class;
    }

    /**
     * The column <code>Developers.id</code>.
     */
    public final TableField<DevelopersRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Developers.fio</code>.
     */
    public final TableField<DevelopersRecord, String> FIO = createField("fio", org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>Developers.phone</code>.
     */
    public final TableField<DevelopersRecord, String> PHONE = createField("phone", org.jooq.impl.SQLDataType.VARCHAR(15).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>Developers.mailbox</code>.
     */
    public final TableField<DevelopersRecord, String> MAILBOX = createField("mailbox", org.jooq.impl.SQLDataType.VARCHAR(20).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>Developers</code> table reference
     */
    public Developers() {
        this(DSL.name("Developers"), null);
    }

    /**
     * Create an aliased <code>Developers</code> table reference
     */
    public Developers(String alias) {
        this(DSL.name(alias), DEVELOPERS);
    }

    /**
     * Create an aliased <code>Developers</code> table reference
     */
    public Developers(Name alias) {
        this(alias, DEVELOPERS);
    }

    private Developers(Name alias, Table<DevelopersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Developers(Name alias, Table<DevelopersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<DevelopersRecord, Integer> getIdentity() {
        return Internal.createIdentity(ru.skwardlow.database.tables.Developers.DEVELOPERS, ru.skwardlow.database.tables.Developers.DEVELOPERS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DevelopersRecord> getPrimaryKey() {
        return Internal.createUniqueKey(ru.skwardlow.database.tables.Developers.DEVELOPERS, "KEY_Developers_PRIMARY", ru.skwardlow.database.tables.Developers.DEVELOPERS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DevelopersRecord>> getKeys() {
        return Arrays.<UniqueKey<DevelopersRecord>>asList(
              Internal.createUniqueKey(ru.skwardlow.database.tables.Developers.DEVELOPERS, "KEY_Developers_PRIMARY", ru.skwardlow.database.tables.Developers.DEVELOPERS.ID)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Developers as(String alias) {
        return new Developers(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Developers as(Name alias) {
        return new Developers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Developers rename(String name) {
        return new Developers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Developers rename(Name name) {
        return new Developers(name, null);
    }
}
