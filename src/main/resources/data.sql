delete from manufacturers;
delete from products;


INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (1, 'ООО "Рога и Копыта"', 'Россия', 'Иван Иванов', '+7 (123) 456-78-90');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (2, 'ЗАО "Созвездие"', 'Казахстан', 'Ольга Петрова', '+7 (987) 654-32-10');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (3, 'ТОО "Астана Групп"', 'Казахстан', 'Ерлан Сериков', '+7 (456) 789-01-23');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (4, 'ИП "СтройПромТорг"', 'Беларусь', 'Алексей Михайлов', '+7 (789) 012-34-56');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (5, 'ФГУП "РосТех"', 'Россия', 'Мария Сидорова', '+7 (012) 345-67-89');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (6, 'АО "АлтайМебель"', 'Россия', 'Анна Казакова', '+7 (345) 678-90-12');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (7, 'ОАО "ГеоПром"', 'Россия', 'Павел Литвиненко', '+7 (901) 234-56-78');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (8, 'ТД "Сибирский выбор"', 'Россия', 'Игорь Соколов', '+7 (234) 567-89-01');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (9, 'ООО "Престиж-Авто"', 'Беларусь', 'Елена Смирнова', '+7 (567) 890-12-34');
	
INSERT INTO manufacturers (id, name, country, person, phone) 
	VALUES (10, 'ЗАО "УралПромышленность"', 'Россия', 'Дмитрий Козлов', '+7 (890) 123-45-67');
	
	
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length) 
	VALUES (1, 'Хлебопечка', 3, 1500, 25, 30, 30);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length) 
	VALUES (2, 'Микроволновка', 5, 12000, 40, 35, 25);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length) 
	VALUES (3, 'Пылесос', 2, 4500, 20, 15, 30);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length) 
	VALUES (4, 'Холодильник', 8, 70000, 70, 180, 70);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length) 
	VALUES (5, 'Телевизор', 6, 15000, 60, 100, 10);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length)
	VALUES (6, 'Утюг', 4, 1500, 10, 15, 20);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length)	
	VALUES (7, 'Плита газовая', 1, 30000, 80, 85, 60);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length) 
	VALUES (8, 'Чайник электрический', 10, 1000, 15, 20, 15);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length) 
	VALUES (9, 'Фен для волос', 7, 900, 10, 10, 25);
	
INSERT INTO products (id, name, manufacturerid, weight, width, height, length) 
	VALUES (10, 'Соковыжималка', 9, 3000, 30, 40, 30);

