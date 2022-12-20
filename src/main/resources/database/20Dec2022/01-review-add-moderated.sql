--liquibase formatted sql
--changeset marszm:9
alter table review add moderated boolean default false;
