 create table tax_config (
       id bigint not null auto_increment,
        created_by varchar(255),
        creation_date datetime,
        last_modified_by varchar(255),
        last_modified_date datetime,
        cess double precision,
        cgst double precision,
        sgst double precision,
        state varchar(255),
        primary key (id)
    );

create table tax_config_aud (
       id bigint not null,
        rev integer not null,
        revtype tinyint,
        created_by varchar(255),
        creation_date datetime,
        last_modified_by varchar(255),
        last_modified_date datetime,
        cess double precision,
        cgst double precision,
        sgst double precision,
        state varchar(255),
        primary key (id, rev)
    );

 alter table tax_config_aud
       add constraint FKqja50yvsyhj7sc5v2hmjwmq0x
       foreign key (rev)
       references revinfo (rev);