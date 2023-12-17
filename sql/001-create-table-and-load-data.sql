-- data.sql
-- schema.sql

-- Creating the fish table
CREATE TABLE IF NOT EXISTS fish (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(255) -- 新しい color カラムを追加
);

-- Inserting sample data into the fish table
INSERT INTO fish (name, color) VALUES ('Goldfish', 'red');
INSERT INTO fish (name, color) VALUES ('Betta Fish', 'Blue');
INSERT INTO fish (name, color) VALUES ('Guppy', 'Multi-colored');
