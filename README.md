# Swagger-Petstore-API-autotests

Репозиторий, в котором представлены автоматизированные тесты api сервиса [Swagger Petstore](https://petstore.swagger.io/).

---

## Содержание

1. [Тест-кейсы](#cases)
2. [Инструкция по запуску](#manual)
3. [Системные требования](#requirements)

---

<a name="cases"></a>
## Тест-кейсы
Представлены по этой ссылке, [Google doc](https://docs.google.com/spreadsheets/d/1D3DH0SOcdcCWUuWYkchnm1xGSOdyPFcTwj5vy3dgFeU/edit?usp=sharing)

---

<a name="manual"></a>
## Инструкция по запуску

1. Клонировать репозиторий;
2. В дирректории проекта вызывать команду "./mvnw.cmd clean install";

Также, для проекта настроены отчёты Allure. Посмотреть их можно при помощи команды "mvn allure:serve"

--- 

<a name="requirements"></a>
## Системные требования

1. Java 11
2. Maven