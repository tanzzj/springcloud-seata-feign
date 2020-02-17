create table service_at
(
    id   int auto_increment,
    name varchar(25) null,
    constraint id
        unique (id)
);

alter table service_at
    add primary key (id);

create table service_tcc
(
    id    int auto_increment,
    bName varchar(25) null,
    constraint id
        unique (id)
);

alter table service_tcc
    add primary key (id);

create table service_tm
(
    id    int auto_increment,
    aName varchar(25) not null,
    constraint id
        unique (id)
);

alter table service_tm
    add primary key (id);

create table undo_log
(
    id            bigint auto_increment comment 'increment id'
        primary key,
    branch_id     bigint       not null comment 'branch transaction id',
    xid           varchar(100) not null comment 'global transaction id',
    context       varchar(128) not null comment 'undo_log context,such as serialization',
    rollback_info longblob     not null comment 'rollback info',
    log_status    int          not null comment '0:normal status,1:defense status',
    log_created   datetime     not null comment 'create datetime',
    log_modified  datetime     not null comment 'modify datetime',
    constraint ux_undo_log
        unique (xid, branch_id)
)
    comment 'AT transaction mode undo table' charset = utf8;

