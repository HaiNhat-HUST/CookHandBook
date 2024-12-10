DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS recipes;
DROP TABLE IF EXISTS recipe_review;
DROP TABLE IF EXISTS restaurant_review;
DROP TABLE IF EXISTS favorite_recipe;
DROP TABLE IF EXISTS favorite_restaurant;
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                        role VARCHAR(15) NOT NULL;
);
CREATE TABLE restaurants (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                            address VARCHAR(255) NOT NULL,
                             owner_id INT NOT NULL,
                            phone_number VARCHAR(15) NOT NULL,
                             status VARCHAR(15) DEFAULT 'PENDING',
                             FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE restaurant_review (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         restaurant_id INT NOT NULL,
                         user_id INT NOT NULL,
                         rating INT CHECK (rating BETWEEN 1 AND 5),
                         comment VARCHAR(255) NOT NULL ,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);
CREATE TABLE recipes (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                        author_id INT NOT NULL,
                         cuisine_type VARCHAR(100),
                         time INT,
                         ingredient TEXT,
                         tutorial TEXT,
                        status VARCHAR(15) DEFAULT 'PENDING',
                        FOREIGN KEY (author_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE recipe_review (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        recipe_id INT NOT NULL,
                        user_id INT NOT NULL,
                        rating INT CHECK (rating BETWEEN 1 AND 5),
                        comment VARCHAR(255) NOT NULL ,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE
)
CREATE TABLE favorite_recipe (
                        user_id INT NOT NULL,
                        recipe_id INT NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                        FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE
)
CREATE TABLE favorite_restaurant (
                        user_id INT NOT NULL,
                        restaurant_id INT NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                        FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
)