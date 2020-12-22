Test task for CS Ltd;

Выбираются все работники из базы данных. Сортируются. Создается файл в проекте /data/ (путь указан в value.properties) c
разрешением ".xlsx", куда записываются все работники в колонки, ФИО/ Название компании/ Зарплата (формат 1,000.00)/
Название департамента;

Ниже таблицы поля c данными:
Количество сотрудников в компании. Общая сумма по зарплатам.

1. DB - MySql
2. Java version up 11.
3. Maven
4. SpringBoot

How to install:

- Clone project
- Run createDb.sql from /resources/sqlScripts
- Run populate.sql from /resources/sqlScripts