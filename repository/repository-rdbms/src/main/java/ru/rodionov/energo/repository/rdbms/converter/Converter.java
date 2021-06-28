package ru.rodionov.energo.repository.rdbms.converter;

public interface Converter<API, DB> {
    API fromDB(DB db);
    DB toDB(API entity, boolean updating);
}
