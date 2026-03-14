# Docker local dev environment

## Docker Images Content
- jupyter
- kafka
- kafka-ui
- keycloak
- mongodb
- nodejs
- ollama
- pgadmin
- postgres
- qdrant
- redis
- wiremock

## How to use

Запустить `docker-compose up -d` или через открытый файл `docker-compose.yml` в IDEA

## postgres

Реляционная база данных PostgreSQL.
- Порт: 15432 (внешний), 5432 (внутренний)
- POSTGRES_USER=local
- POSTGRES_PASSWORD=local
- POSTGRES_DB=local
- Том: ./postgres/data:/var/lib/postgresql
- init.sql: ./postgres/init.sql

Дополнительно создает пользователей и схемы из [скрипта инициализации](postgres/init.sql):
- demo (demo/demo)
- keycloak (keycloak/keycloak)

## mongodb

Документоориентированная база данных MongoDB.
- Порт: 27017
- MONGO_INITDB_ROOT_USERNAME=local
- MONGO_INITDB_ROOT_PASSWORD=local
- MONGO_INITDB_DATABASE=local
- Том: ./mongodb/data:/data/db

## redis

In-memory база данных Redis (key-value store).
- Порт: 16379 (внешний), 6379 (внутренний)
- Требует пароль: redis

## keycloak

Identity and Access Management (IAM) решение.
- http://localhost:18080
- https://localhost:18443
- username: admin
- password: admin
- Debug порт: 15005
- Зависит от: postgres
- База данных: keycloak/keycloak

## kafka

Распределённая платформа потоковой обработки сообщений.
- Порт: 19092 (внешний), 9092 (внутренний)
- KAFKA_NODE_ID: 1
- KAFKA_PROCESS_ROLES: broker,controller
- KAFKA_NUM_PARTITIONS: 3

## kafka-ui

Веб-интерфейс для мониторинга Kafka.
- http://localhost:18083
- Зависит от: kafka

## nodejs

Node.js контейнер для тестирования и разработки.
- Порт: 3000
- Рабочая директория: /app
- Том: ./nodejs:/app
- Выполняет npm init и npm install при запуске

## ollama

Платформа для запуска LLM моделей локально.
- Порт: 11434
- Том: ./ollama:/root/.ollama
- API: http://localhost:11434

## pgadmin

PostgreSQL Admin UI - веб-интерфейс для управления PostgreSQL.
- http://localhost:18082
- Email: user@local.email
- Password: local

## jupyter

Jupyter Notebook - интерактивная среда для работы с данными и Python.
- http://localhost:18888
- Рабочая директория: /home/jovyan/work
- Том для ноутбуков: ./jupyter/notebooks
- Том для датасетов: ./jupyter/datasets
- Аутентификация отключена (без пароля и токена)

## Wiremock

Wiremock - инструмент для создания API заглушек.
- http://localhost:18081
- [Документация](https://wiremock.org/docs/)
- Том: ./wiremock:/home/wiremock/mappings
- При создании image копируются заглушки из папки [`wiremock`](./wiremock/wiremock-mappings-template.json)
- Основные заглушки добавляются в отдельный файл `<service-name>.json`

## Qdrant

Векторная база данных для AI-приложений и семантического поиска.
- REST API: http://localhost:6333
- gRPC: localhost:6334
- Том: ./qdrant/data:/qdrant/storage
- [Документация](https://qdrant.tech/documentation/)

Qdrant используется для:
- Векторного поиска и семантического поиска
- Хранения эмбеддингов (embeddings)
- similarity search в AI/ML приложениях
- RAG (Retrieval-Augmented Generation) систем
