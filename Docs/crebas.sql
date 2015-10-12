
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

