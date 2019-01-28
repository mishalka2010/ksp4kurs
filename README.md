# ksp4kurs
Проблема
	Разработать онлайн зоомагазин.

Задача
	Разработать приложение, используя язык программирования Java, Apache Maven, Spring Framework.

Реализовать:
	•	Возможность пополнения баланса;
	•	Возможность выбора товаров в корзину;
	•	Возможность оплаты содержимого корзины;
	•	Хранение данных о товарах и пользователях в базе данных;
	•	Хранилище конфигураций;
	•	Авторизация пользователей;

Требования:
	•	Масштабируемость
	•	Микросервисная REST архитектура;
	•	Независимость сервисов

Решение

	С соблюдением требований, было написано приложение, реализованы все необходимые функции.

Анализ результатов

	Url: /identify
	Method: POST
	Request: 2019-01-28 23:28:10.404
	Response body: {"userID": 1, "role": "user", "signature": "350fc3ee5f6ff9bb49b863f24fc9a023e658f3edf8e9488ac2c4beab368ba488"}
	
	Url: /balance
	Method: POST
	Request: 2019-01-28 23:28:24.602
	Response body: Updating balance

	Url: /pet
	Method: GET
	Request: 2019-01-28 23:29:15.713
	Response body: {{"id":1, "name":"Husky", "price": 15000},{"id":2, "name":"Lajka", "price": 10000}}
	
	Url: /cart/pet/1
	Method: PUT
	Request: 2019-01-28 23:30:45.105
	Response body: Putting pet to cart
	
	Url: /cart
	Method: GET
	Request: 2019-01-28 23:31:05.508
	Response body: {"cartid":1, "userid":1, "itemid":1”}
	
	Url: /cart
	Method: POST
	Request: 2019-01-28 23:31:13.409
	Response body: Cart successfully paid

