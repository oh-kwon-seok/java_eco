package com.springboot.java_jangan.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStandard is a Querydsl query type for Standard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStandard extends EntityPathBase<Standard> {

    private static final long serialVersionUID = 1269363258L;

    public static final QStandard standard = new QStandard("standard");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final StringPath name = createString("name");

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    //inherited
    public final NumberPath<Integer> used = _super.used;

    public QStandard(String variable) {
        super(Standard.class, forVariable(variable));
    }

    public QStandard(Path<? extends Standard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStandard(PathMetadata metadata) {
        super(Standard.class, metadata);
    }

}

