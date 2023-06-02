package com.utronics.astradb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;


@Data
public class Employee {

    @Id
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.INT)
    private int id;
    @Column("name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;
    @Column("dept")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String dept;
    @Column("salary")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long salary;
}
