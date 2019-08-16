package ru.unic.hr.service.parser;

public interface IParser<T> {
    T parse(String content);
}
