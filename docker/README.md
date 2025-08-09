# Docker local dev environment

## Docker Images Content
- kafka
- keycloak
- postgres
- redis
- wiremock

## How to use

Запустить `docker-compose up -d` или через открытый файл `docker-compose.yml` в IDEA

## keycloak
Для доступа к консоли необходимо использовать порты 18080 и 18443
- http://localhost:18080
- https://localhost:18443

username: admin
password: admin

## postgres
POSTGRES_USER=local
POSTGRES_PASSWORD=local
POSTGRES_DB=local

Дополнительно создает пользователей и схемы из [скрипта инициализации](./db/init.sql):
- demo (demo/demo)
- keycloak (keycloak/keycloak)

## Wiremock

Wiremock - инструмент для создания API заглушек. 

[Документация](https://wiremock.org/docs/)
При создании image копируются заглушки из папки [`wiremock`](./wiremock/wiremock-mappings-template.json).

Основные заглушки добавляются в отдельный файл `<service-name>.json`. Контейнер использует порт 8081, т.е. wiremock доступен по адресу http://localhost:8081. 
