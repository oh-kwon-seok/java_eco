package com.springboot.java_eco.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStockRecord is a Querydsl query type for StockRecord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStockRecord extends EntityPathBase<StockRecord> {

    private static final long serialVersionUID = 1911698120L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStockRecord stockRecord = new QStockRecord("stockRecord");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QCompany company;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final QFactory factory;

    public final QFactorySub factorySub;

    public final QItem item;

    public final StringPath lot = createString("lot");

    public final NumberPath<Double> qty = createNumber("qty", Double.class);

    public final StringPath reason = createString("reason");

    public final StringPath status = createString("status");

    public final QStockInout stockInout;

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    public final StringPath unit = createString("unit");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public QStockRecord(String variable) {
        this(StockRecord.class, forVariable(variable), INITS);
    }

    public QStockRecord(Path<? extends StockRecord> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStockRecord(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStockRecord(PathMetadata metadata, PathInits inits) {
        this(StockRecord.class, metadata, inits);
    }

    public QStockRecord(Class<? extends StockRecord> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
        this.factory = inits.isInitialized("factory") ? new QFactory(forProperty("factory"), inits.get("factory")) : null;
        this.factorySub = inits.isInitialized("factorySub") ? new QFactorySub(forProperty("factorySub"), inits.get("factorySub")) : null;
        this.item = inits.isInitialized("item") ? new QItem(forProperty("item"), inits.get("item")) : null;
        this.stockInout = inits.isInitialized("stockInout") ? new QStockInout(forProperty("stockInout"), inits.get("stockInout")) : null;
    }

}

