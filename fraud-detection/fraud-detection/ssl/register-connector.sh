curl -X PUT http://localhost:8083/connectors/transaction-connector/config \
  -H "Content-Type: application/json" \
  -d '{
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "database.hostname": "postgres",
    "database.port": "5432",
    "database.user": "debezium",
    "database.password": "dbz",
    "database.dbname": "transactions_db",
    "database.server.name": "fraud-server",
    "topic.prefix": "fraud-server",
    "plugin.name": "pgoutput",
    "table.include.list": "public.transaction",
    "tombstones.on.delete": "false"
  }'