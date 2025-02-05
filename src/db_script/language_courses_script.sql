CREATE DATABASE IF NOT EXISTS LanguageCourses;
USE LanguageCourses;

-- Таблица компаний
CREATE TABLE Companies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(56) NOT NULL
);

-- Таблица курсов
CREATE TABLE Courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    company_id INT,
    course_name VARCHAR(56) NOT NULL,
    price_per_month DECIMAL(10,2) NOT NULL,
    payment_method VARCHAR(56) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES Companies(id) ON DELETE CASCADE
);

-- Вставка примеров данных
INSERT INTO Companies (company_name) VALUES ('LinguaPro'), ('SpeakEasy'), ('GlobalLang');

INSERT INTO Courses (company_id, course_name, price_per_month, payment_method) 
VALUES 
    (1, 'Basic English', 50.00, 'Credit Card'),
    (1, 'Advanced Spanish', 70.00, 'PayPal'),
    (2, 'French for Beginners', 40.00, 'Bank Transfer'),
    (3, 'German Intensive', 65.00, 'Credit Card');