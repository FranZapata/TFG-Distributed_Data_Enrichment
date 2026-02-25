# TFG – Distributed Architecture for Data Enrichment

Arquitectura distribuida basada en microservicios para scraping, procesamiento con LLM y enriquecimiento estructurado de datos mediante eventos (Kafka) de anuncios de productos de segunda mano.

## Stack tecnológico

- Java 21
- Spring Boot 3
- Apache Kafka
- PostgreSQL
- Redis (opcional)
- Docker & Docker Compose
- Playwright (scraping dinámico)
- Ollama (LLM local)

## Arquitectura

Scraper → Kafka → Processor (LLM) → Kafka → Persistence → PostgreSQL → Search API