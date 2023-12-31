# REST API для вычисления частоты встречи символов

Этот проект представляет собой REST API, разработанное на Spring Boot, 
для вычисления частоты встречи символов в заданной строке. Результат отсортирован по убыванию количества вхождений символа.

## Стек приложения

- Java 21
- Spring Boot 3.1.5
- Swagger 3 (OpenAPI 3)

## Запуск проекта

1. class T1restApplication
2. в Postman сформировать POST запрос



### Endpoint: `/api/frequency/`

#### `POST /countFrequency`

Расчет частоты встречи символов в заданной строке.

**Пример входящего запроса:**
```Text
  aaaaabcccc
```

**Пример устешного ответа:**

```
{
  "a": 5,
  "c": 4,
  "b": 1
}
```
## Документация API

Документация API доступна по адресу - http://localhost:8080/swagger-ui.html