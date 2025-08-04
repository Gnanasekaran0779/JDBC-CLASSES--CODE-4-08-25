# 🚀 JDBC Table Creator (`App.java`)

A simple Java utility to connect to MySQL and create a `data` table with an auto‑increment ID, `name`, and `value` columns—if it doesn't already exist. Useful when you're bootstrapping a database schema or testing connectivity.

## 🧰 Prerequisites

- **Java 8+ JDK** installed (Java 11 or 17 recommended).
- **MySQL Server** up & running on `localhost:3306`.
- **MySQL Connector/J** (e.g. `mysql-connector-java‑8.0.34.jar`) available locally or via Maven.
- A MySQL user with privileges to **create schemas and tables**.

## 🔧 Setup the Database

Before running the Java app, ensure the database exists:

```sql
mysql> CREATE DATABASE IF NOT EXISTS sample;
Query OK, 1 row affected (0.05 sec)