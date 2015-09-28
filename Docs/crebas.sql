/*==============================================================*/
/* Nom de SGBD :  Sybase SQL Anywhere 11                        */
/* Date de création :  28/09/2015 18:02:40                      */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_ALERTES_ECRIT_PERSONNE') then
    alter table ALERTES
       delete foreign key FK_ALERTES_ECRIT_PERSONNE
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ECRIT_FK'
     and t.table_name='ALERTES'
) then
   drop index ALERTES.ECRIT_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='ALERTES_PK'
     and t.table_name='ALERTES'
) then
   drop index ALERTES.ALERTES_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='ALERTES'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table ALERTES
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='PERSONNES_PK'
     and t.table_name='PERSONNES'
) then
   drop index PERSONNES.PERSONNES_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='PERSONNES'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table PERSONNES
end if;

/*==============================================================*/
/* Table : ALERTES                                              */
/*==============================================================*/
create table ALERTES 
(
   IDALERTE             integer                        not null,
   IDPERSONNE           integer                        not null,
   DESTINATAIREALERTE   varchar(30)                    null,
   DELAISALERTES        timestamp                      null,
   MESSAGEALERTE        long varchar                   null,
   PJALERTE             varchar(200)                   null,
   constraint PK_ALERTES primary key (IDALERTE)
);

/*==============================================================*/
/* Index : ALERTES_PK                                           */
/*==============================================================*/
create unique index ALERTES_PK on ALERTES (
IDALERTE ASC
);

/*==============================================================*/
/* Index : ECRIT_FK                                             */
/*==============================================================*/
create index ECRIT_FK on ALERTES (
IDPERSONNE ASC
);

/*==============================================================*/
/* Table : PERSONNES                                            */
/*==============================================================*/
create table PERSONNES 
(
   IDPERSONNE           integer                        not null,
   LOGINPERSONNE        varchar(30)                    null,
   MDPPERSONNE          varchar(30)                    null,
   ISADMIN              smallint                       null,
   constraint PK_PERSONNES primary key (IDPERSONNE)
);

/*==============================================================*/
/* Index : PERSONNES_PK                                         */
/*==============================================================*/
create unique index PERSONNES_PK on PERSONNES (
IDPERSONNE ASC
);

alter table ALERTES
   add constraint FK_ALERTES_ECRIT_PERSONNE foreign key (IDPERSONNE)
      references PERSONNES (IDPERSONNE)
      on update restrict
      on delete restrict;

