CREATE DATABASE IF NOT EXISTS shop_handler;

USE shop_handler;

CREATE TABLE book_shop(
	Product_title varchar(255), 
	Category varchar(255), 
	Availability varchar(255),
	Price int
);

CREATE TABLE tech_shop(
	Product_title varchar(255), 
	Category varchar(255), 
	Availability varchar(255),
	Price int
);

INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('XPeria Z', 'Smartphones', 'AVAILABLE', 600);
INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('IPhone 2', 'Smartphones', 'EXPECTED', 800);
INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('Xiaomi 3', 'Smartphones', 'ABSENT', 300);

INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('IPad', 'Tablets', 'AVAILABLE', 1200);
INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('Surface', 'Tablets', 'EXPECTED', 1189);
INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('Sumsung Tab', 'Tablets', 'ABSENT', 1098);

INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Three Musketeers', 'Advanture', 'AVAILABLE', 200);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Moby Dick', 'Advanture', 'EXPECTED', 189);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Tresure Island', 'Advanture', 'ABSENT', 98);

INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Sherlock Holmes', 'Detective', 'AVAILABLE', 132);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('The Woman in white', 'Detective', 'EXPECTED', 186);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('The murder at the Vicarage', 'Detective', 'ABSENT', 198);

INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Clean code', 'Programming', 'AVAILABLE', 232);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Thinking in Java', 'Programming', 'EXPECTED', 386);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Effective Java', 'Programming', 'ABSENT', 498);
