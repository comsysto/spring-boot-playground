CREATE TABLE QUOTE (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY,
	quote varchar(255) not null
);

insert into QUOTE (quote) values ('Working with Spring Boot is like pair-programming with the Spring developers.');
insert into QUOTE (quote) values ('With Boot you deploy everywhere you can find a JVM basically.');
insert into QUOTE (quote) values ('Spring has come quite a ways in addressing developer enjoyment and '
      + 'ease of use since the last time I built an application using it.');
insert into QUOTE (quote) values ('Previous to Spring Boot, I remember XML hell, confusing set up, and '
      + 'many hours of frustration.');