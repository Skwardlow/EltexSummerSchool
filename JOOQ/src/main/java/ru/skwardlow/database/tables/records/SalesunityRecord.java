/*
 * This file is generated by jOOQ.
 */
package ru.skwardlow.database.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import ru.skwardlow.database.tables.Salesunity;


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
public class SalesunityRecord extends UpdatableRecordImpl<SalesunityRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 154808069;

    /**
     * Setter for <code>SalesUnity.id_Man</code>.
     */
    public void setIdMan(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>SalesUnity.id_Man</code>.
     */
    public Integer getIdMan() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>SalesUnity.id_Sale</code>.
     */
    public void setIdSale(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>SalesUnity.id_Sale</code>.
     */
    public Integer getIdSale() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Salesunity.SALESUNITY.ID_MAN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Salesunity.SALESUNITY.ID_SALE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIdMan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getIdSale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIdMan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getIdSale();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SalesunityRecord value1(Integer value) {
        setIdMan(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SalesunityRecord value2(Integer value) {
        setIdSale(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SalesunityRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SalesunityRecord
     */
    public SalesunityRecord() {
        super(Salesunity.SALESUNITY);
    }

    /**
     * Create a detached, initialised SalesunityRecord
     */
    public SalesunityRecord(Integer idMan, Integer idSale) {
        super(Salesunity.SALESUNITY);

        set(0, idMan);
        set(1, idSale);
    }
}