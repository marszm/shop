--liquibase formatted sql
--changeset marszm:4
alter table product add full_description text default null after
description;
