--liquibase formatted sql
--changeset marszm:2
alter table product add image varchar(128) after currency;