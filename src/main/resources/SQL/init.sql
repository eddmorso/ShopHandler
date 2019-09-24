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

INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('XPeria Z', 'Smartphones', 'Available', 600);
INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('IPhone 2', 'Smartphones', 'Expected', 800);
INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('Xiaomi 3', 'Smartphones', 'Absent', 300);

INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('IPad', 'Tablets', 'Available', 1200);
INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('Surface', 'Tablets', 'Expected', 1189);
INSERT INTO tech_shop (Product_title, Category, Availability, Price) VALUES ('Sumsung Tab', 'Tablets', 'Absent', 1098);

INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Three Musketeers', 'Advanture', 'Available', 200);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Moby Dick', 'Advanture', 'Expected', 189);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Tresure Island', 'Advanture', 'Absent', 98);

INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Sherlock Holmes', 'Detective', 'Available', 132);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('The Woman in white', 'Detective', 'Expected', 186);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('The murder at the Vicarage', 'Detective', 'Absent', 198);

INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Clean code', 'Programming', 'Available', 232);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Thinking in Java', 'Programming', 'Expected', 386);
INSERT INTO book_shop (Product_title, Category, Availability, Price) VALUES ('Effective Java', 'Programming', 'Absent', 498);
