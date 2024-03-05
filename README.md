# Хранилище новостей

### Введение

Новостное Хранилище представляет предназначенно для хранения и управления новостями. Приложение предоставляет возможность выполнять операции CRUD (создание, чтение, обновление, удаление) над новостями.
### Технологии

- Java
- Spring Framework 
- MySQL
- Docker Compose

### API

Приложение предоставляет следующие API-интерфейсы для работы с новостями:

#### POST

* `POST http://localhost:8181/` - Загрузка списка новостей в хранилище

#### GET

* `GET http://localhost:8181/` - Получение списка всех новостей  
* `GET http://localhost:8181/last`  - Получение последней по времени новости  
* `GET http://localhost:8181/{guid}`  - Получение новости по указанному GUID  

#### PATCH

* `PATCH http://localhost:8181/{guid}/title`  - Обновление заголовка новости по указанному GUID  
* `PATCH http://localhost:8181/{guid}/description`  - Обновление описания новости по указанному GUID  

#### DELETE

* `DELETE http://localhost:8181/{guid}`  - Удаление новости по указанному GUID  
* `DELETE http://localhost:8181/all`  - Удаление всех сохраненных новостей


## Запуск

1. Клонирование репозитория  
   `git clone https://github.com/sharphurt/news-storage`


2. Запуск приложения с помощью Docker Compose  
   `docker-compose up --build`

    <hr>
    
    ### Важно
   
    Файл `compose.yaml` содержит конфигурацию запуска RSS-парсера ([https://github.com/sharphurt/cron-rss-reader](https://github.com/sharphurt/cron-rss-reader)) в совокупности с контейнером хранилища и базы данных. Отдельно ничего запускать не нужно!
    
    <hr>