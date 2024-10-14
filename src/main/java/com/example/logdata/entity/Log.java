package com.example.logdata.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "log-index")
@Data
public class Log {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String type;
    @Field(type = FieldType.Date)
    private Date log_timestamp; // 日志时间，日志数据本身携带时间
    @Field(type = FieldType.Date)
    private Date create_timestamp; // 日志入库时间，日志数据被首次写入es集群的时间
    @Field(type = FieldType.Text)
    private String from; // 来源ip
    @Field(type = FieldType.Text)
    private String to; // 目的地ip
    @Field(type = FieldType.Text)
    private String producer; // 日志生产者ip
    @Field(type = FieldType.Integer)
    private Integer length; // 日志消息的长度
    @Field(type = FieldType.Text)
    private String protocol;
    @Field(type = FieldType.Integer)
    private Integer level; // 消息层级
    @Field(type = FieldType.Text)
    private String FID; // 父日志ID
    @Field(type = FieldType.Text)
    private String error;
    @Field(type = FieldType.Text)
    private String message;
    @Field(type = FieldType.Text)
    private String extension; // 扩展信息，json格式字符串
}
