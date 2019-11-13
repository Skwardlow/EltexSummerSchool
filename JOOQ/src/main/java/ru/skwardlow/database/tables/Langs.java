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
import ru.skwardlow.database.tables.records.LangsRecord;


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
public class Langs extends TableImpl<LangsRecord> {

    private static final long serialVersionUID = 1340493377;

    /**
     * The reference instance of <code>Langs</code>
     */
    public static final Langs LANGS = new Langs();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LangsRecord> getRecordType() {
        return LangsRecord.class;
    }

    /**
     * The column <code>Langs.id</code>.
     */
    public final TableField<LangsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Langs.lang</code>.
     */
    public final TableField<LangsRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.VARCHAR(10).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>Langs</code> table reference
     */
    public Langs() {
        this(DSL.name("Langs"), null);
    }

    /**
     * Create an aliased <code>Langs</code> table reference
     */
    public Langs(String alias) {
        this(DSL.name(alias), LANGS);
    }

    /**
     * Create an aliased <code>Langs</code> table reference
     */
    public Langs(Name alias) {
        this(alias, LANGS);
    }

    private Langs(Name alias, Table<LangsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Langs(Name alias, Table<LangsRecord> aliased, Field<?>[] parameters) {
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
    public Identity<LangsRecord, Integer> getIdentity() {
        return Internal.createIdentity(ru.skwardlow.database.tables.Langs.LANGS, ru.skwardlow.database.tables.Langs.LANGS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LangsRecord> getPrimaryKey() {
        return Internal.createUniqueKey(ru.skwardlow.database.tables.Langs.LANGS, "KEY_Langs_PRIMARY", ru.skwardlow.database.tables.Langs.LANGS.ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LangsRecord>> getKeys() {
        return Arrays.<UniqueKey<LangsRecord>>asList(
              Internal.createUniqueKey(ru.skwardlow.database.tables.Langs.LANGS, "KEY_Langs_PRIMARY", ru.skwardlow.database.tables.Langs.LANGS.ID)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Langs as(String alias) {
        return new Langs(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Langs as(Name alias) {
        return new Langs(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Langs rename(String name) {
        return new Langs(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Langs rename(Name name) {
        return new Langs(name, null);
    }
}