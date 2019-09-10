create table charge (
       id bigint not null auto_increment,
        created_by varchar(255),
        creation_date datetime,
        last_modified_by varchar(255),
        last_modified_date datetime,
        amount double precision,
        range_end double precision,
        range_start double precision,
        primary key (id)
    );
create table charge_aud (
       id bigint not null,
        rev integer not null,
        revtype tinyint,
        created_by varchar(255),
        creation_date datetime,
        last_modified_by varchar(255),
        last_modified_date datetime,
        amount double precision,
        range_end double precision,
        range_start double precision,
        primary key (id, rev)
    );
create table revinfo (
       rev integer not null auto_increment,
        revtstmp bigint,
        primary key (rev)
    ) ;
create table service_charge (
       id bigint not null auto_increment,
        created_by varchar(255),
        creation_date datetime,
        last_modified_by varchar(255),
        last_modified_date datetime,
        charge_type varchar(255),
        charge_key varchar(255),
        charge_mode varchar(255),
        name varchar(255),
        primary key (id)
    );
create table service_charge_aud (
       id bigint not null,
        rev integer not null,
        revtype tinyint,
        created_by varchar(255),
        creation_date datetime,
        last_modified_by varchar(255),
        last_modified_date datetime,
        charge_type varchar(255),
        charge_key varchar(255),
        charge_mode varchar(255),
        name varchar(255),
        primary key (id, rev)
    );

create table service_charge_charges (
       service_charge_id bigint not null,
        charges_id bigint not null
    );

create table service_charge_charges_aud (
       rev integer not null,
        service_charge_id bigint not null,
        charges_id bigint not null,
        revtype tinyint,
        primary key (rev, service_charge_id, charges_id)
    );

alter table service_charge_charges
       add constraint unique_service_charge_charges_chargeid unique (charges_id);

alter table charge_aud
       add constraint fk_charge_aud_rev
       foreign key (rev)
       references revinfo (rev);

alter table service_charge_aud
       add constraint fk_service_charge_aud_rev
       foreign key (rev)
       references revinfo (rev);

alter table service_charge_charges
       add constraint fk_service_charge_charges_chargeid
       foreign key (charges_id)
       references charge (id);

alter table service_charge_charges
       add constraint fk_service_charge_charges_servicechargeid
       foreign key (service_charge_id)
       references service_charge (id);

 alter table service_charge_charges_aud
       add constraint fk_service_charge_charges_aud_rev
       foreign key (rev)
       references revinfo (rev);
