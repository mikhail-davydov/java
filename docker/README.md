# Docker local dev environment

## Docker Images Content
- kafka
- kafka-ui
- keycloak
- mongodb
- nodejs
- pgadmin
- postgres
- redis
- wiremock

## How to use

Запустить `docker-compose up -d` или через открытый файл `docker-compose.yml` в IDEA

## nodejs

Node.js контейнер для тестирования и разработки.
- Порт: 3000
- Рабочая директория: /app
- Выполняет npm init и npm install при запуске

## pgadmin

PostgreSQL Admin UI - веб-интерфейс для управления PostgreSQL.
- http://localhost:18082
- Email: user@local.email
- Password: local

## postgres
- Порт: 15432 ( внешний ), 5432 (внутри контейнера )
POSTGRES_USER=local
POSTGRES_PASSWORD=local
POSTGRES_DB=local

Дополнительно создает пользователей и схемы из [скрипта инициализации](postgres/init.sql):
- demo (demo/demo)
- keycloak (keycloak/keycloak)

## keycloak
Для доступа к консоли необходимо использовать порты 18080 и 18443
- http://localhost:18080
- https://localhost:18443

username: admin
password: admin

Debug порт: 15005

## redis
- Порт: 16379 (внешний), 6379 (внутренний)
- Требует пароль: redis

## mongodb
- Порт: 27017
- MONGO_INITDB_ROOT_USERNAME=local
- MONGO_INITDB_ROOT_PASSWORD=local
- MONGO_INITDB_DATABASE=local

## kafka
- Порт: 19092 (внешний), 9092 (внутренний)

## kafka-ui

UI для мониторинга Kafka.
- http://localhost:18083

## Wiremock

Wiremock - инструмент для создания API заглушек. 

[Документация](https://wiremock.org/docs/)
При создании image копируются заглушки из папки [`wiremock`](./wiremock/wiremock-mappings-template.json).

Основные заглушки добавляются в отдельный файл `<service-name>.json`. Контейнер использует порт 18081, т.е. wiremock доступен по адресу http://localhost:18081. 
