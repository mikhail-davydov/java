# n8n Docker Stack - Production Ready

Полный стек n8n для автоматизации с PostgreSQL, Redis и Ollama.
Версия 2.1 - упрощенная архитектура (web + webhook объединены).

## Компоненты

| Сервис | Описание | Порты |
|--------|----------|-------|
| n8n | Web UI, API и webhook (в одном сервисе) | 5678 |
| n8n-worker | Обработка очередей выполнения | - |
| ollama | Локальные LLM модели | 11434 |
| postgres | База данных | - |
| redis | Кеш и очереди | - |

## Структура

```
docker/n8n-stack/
├── docker-compose.yml    # Orchestration (v2.1 - simplified)
├── .env.example          # Environment template
├── README.md             # This file
├── scripts/              # Helper scripts
│   └── ollama-manager.sh # Model management script
└── data/                 # Persistent data (auto-created)
    ├── n8n/              # n8n data
    ├── redis/            # Redis persistence
    ├── postgres/         # PostgreSQL data
    └── ollama/           # Ollama models
```

## Быстрый старт

### 1. Требования

- Docker Engine 20.10+
- Docker Compose v2.0+
- (Опционально) NVIDIA GPU для Ollama

### 2. Настройка

```bash
cd docker/n8n-stack

# Copy environment template
cp .env.example .env

# Edit with your values
nano .env
```

### 3. Запуск

```bash
# Start all services
docker-compose up -d

# Check status
docker-compose ps

# View logs
docker-compose logs -f
```

### 4. Доступ

| Сервис | URL | По умолчанию |
|--------|-----|--------------|
| n8n Web UI | http://localhost:5678 | admin / (пароль из .env) |
| Ollama API | http://localhost:11434 | - |

## Масштабирование

### Увеличение количества workers

```bash
# Запуск с 3 workers
docker-compose up -d --scale n8n-worker=3

# Проверка
docker-compose ps
```

### Мониторинг очереди Redis

```bash
# Подключение к Redis
docker exec -it n8n-redis redis-cli -a YOUR_PASSWORD

# Просмотр очередей
KEYS *n8n*

# Мониторинг
MONITOR
```

## Production рекомендации

### 1. Безопасность

- Все сервисы работают без привилегий (non-root)
- Явные версии образов (alpine)
- Пароли в .env файле (не в репозитории)
- PostgreSQL и Redis порты не открыты наружу
- Ограничены ресурсы контейнеров

### 2. Резервное копирование

```bash
# Создание backup
tar -czvf n8n-backup-$(date +%Y%m%d).tar.gz data/

# Восстановление
tar -xzf n8n-backup-YYYYMMDD.tar.gz
```

### 3. Обновление

```bash
# Обновление образов
docker-compose pull

# Перезапуск
docker-compose up -d
```

### 4. Производительность

- Workers могут быть масштабированы горизонтально
- PostgreSQL настроен с connection pooling
- Redis использует AOF persistence
- Ollama имеет увеличенный context window

### 5. Мониторинг

```bash
# Статус всех сервисов
docker-compose ps

# Логи конкретного сервиса
docker-compose logs -f n8n-worker
docker-compose logs -f n8n

# Проверка health checks
curl http://localhost:5678/healthz
```

## Использование Ollama

### Установка модели

```bash
# Подключение к Ollama
docker exec -it n8n-ollama ollama pull llama2
docker exec -it n8n-ollama ollama pull mistral

# Просмотр установленных моделей
docker exec -it n8n-ollama ollama ls
```

### Использование в n8n

Используйте HTTP Request node:

```
URL: http://ollama:11434/api/generate
Method: POST
Body:
{
  "model": "llama2",
  "prompt": "Your prompt here",
  "stream": false
}
```

## Troubleshooting

### Worker не обрабатывает задачи

```bash
# Проверка статуса worker
docker logs n8n-worker

# Проверка подключения к Redis
docker exec n8n-worker redis-cli -a YOUR_PASSWORD ping
```

### Ollama не загружает модель

```bash
# Проверка доступных моделей
docker exec n8n-ollama ollama ls

# Ручная загрузка
docker exec -it n8n-ollama ollama run llama2
```

### Проблемы с PostgreSQL

```bash
# Проверка подключения
docker exec n8n-postgres pg_isready -U n8n

# Логи
docker logs n8n-postgres
```

## Конфигурация .env

### Основные переменные

```env
# PostgreSQL
POSTGRES_USER=n8n
POSTGRES_PASSWORD=secure_password
POSTGRES_DB=n8n

# Redis
REDIS_PASSWORD=secure_redis_password

# n8n
N8N_HOST=localhost
N8N_PROTOCOL=http
N8N_EDITOR_BASE_URL=http://localhost:5678
N8N_WEBHOOK_URL=http://localhost:5678
N8N_BASIC_AUTH_USER=admin
N8N_BASIC_AUTH_PASSWORD=admin_password

# Ollama
OLLAMA_PORT=11434
```

## Лицензия

MIT