package com.springboot.java_eco.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSensorRuntime is a Querydsl query type for SensorRuntime
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSensorRuntime extends EntityPathBase<SensorRuntime> {

    private static final long serialVersionUID = 2034593343L;

    public static final QSensorRuntime sensorRuntime = new QSensorRuntime("sensorRuntime");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> created = _super.created;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deleted = _super.deleted;

    public final StringPath type = createString("type");

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updated = _super.updated;

    public QSensorRuntime(String variable) {
        super(SensorRuntime.class, forVariable(variable));
    }

    public QSensorRuntime(Path<? extends SensorRuntime> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSensorRuntime(PathMetadata metadata) {
        super(SensorRuntime.class, metadata);
    }

}

