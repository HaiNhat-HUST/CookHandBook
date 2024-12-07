DROP TABLE IF EXISTS reviews;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS recipes;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);
CREATE TABLE restaurants (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    owner_id INT NOT NULL,
    total_comments INT DEFAULT 0,
    total_reviews INT DEFAULT 0,
    average_rating FLOAT DEFAULT 0,
    FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TABLE reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT NOT NULL,
    user_id INT NOT NULL,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);
CREATE TABLE recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    cuisine_type VARCHAR(100),
    time INT,
    calorie INT,
    ingredient TEXT,
    tutorial TEXT
);

INSERT INTO recipes (id, name, cuisine_type, time, calorie, ingredient, tutorial) VALUES
(1, 'Pasta Carbonara', 'Italian', 30, 500, 'Pasta, eggs, pancetta, Parmesan cheese',
 '1. Cook the pasta in salted boiling water.\n2. In a pan, cook the pancetta until crispy.\n3. Whisk eggs and cheese together in a bowl.\n4. Toss pasta with pancetta and egg mixture.'),

(2, 'Chicken Curry', 'Indian', 60, 600, 'Chicken, curry powder, onions, tomatoes, garlic, ginger, coconut milk',
 '1. Heat oil in a pan and sauté onions, garlic, and ginger.\n2. Add chicken and brown it.\n3. Add curry powder, tomatoes, and coconut milk, then simmer for 40 minutes.'),

(3, 'Sushi', 'Japanese', 45, 300, 'Sushi rice, nori, salmon, avocado, cucumber, soy sauce',
 '1. Cook sushi rice and let it cool.\n2. Cut vegetables and fish into strips.\n3. Lay nori on a bamboo mat, spread rice, and add fillings.\n4. Roll tightly and slice into pieces.'),

(4, 'Tacos', 'Mexican', 20, 250, 'Taco shells, ground beef, lettuce, tomatoes, cheese, sour cream',
 '1. Cook ground beef with taco seasoning.\n2. Fill taco shells with beef, lettuce, tomatoes, cheese, and sour cream.'),

(5, 'Spaghetti Bolognese', 'Italian', 90, 700, 'Ground beef, onions, tomatoes, garlic, pasta, red wine, herbs',
 '1. Sauté onions and garlic in a pan.\n2. Add ground beef and cook until browned.\n3. Add tomatoes, red wine, and herbs, then simmer for 60 minutes.\n4. Cook pasta and serve with sauce.'),

(6, 'Caesar Salad', 'American', 15, 180, 'Lettuce, croutons, Parmesan cheese, Caesar dressing',
 '1. Toss lettuce with dressing.\n2. Add croutons and Parmesan cheese, and serve.'),

(7, 'Beef Stew', 'American', 120, 800, 'Beef, carrots, potatoes, onions, broth, herbs',
 '1. Brown beef in a pot.\n2. Add vegetables and broth.\n3. Simmer for 2 hours until beef is tender.'),

(8, 'Vegetable Stir Fry', 'Chinese', 30, 250, 'Broccoli, carrots, bell peppers, soy sauce, ginger, garlic',
 '1. Heat oil in a wok.\n2. Add garlic and ginger, then stir-fry vegetables for 5 minutes.\n3. Add soy sauce and stir-fry for 10 more minutes.'),

(9, 'Margarita Pizza', 'Italian', 90, 700, 'Pizza dough, tomatoes, mozzarella, basil',
 '1. Roll out pizza dough and spread with tomato sauce.\n2. Add mozzarella cheese and bake at 475°F for 15 minutes.\n3. Add fresh basil before serving.'),

(10, 'Chocolate Cake', 'American', 60, 400, 'Flour, cocoa powder, sugar, eggs, butter, vanilla extract',
 '1. Preheat oven to 350°F.\n2. Mix dry ingredients and wet ingredients separately.\n3. Combine and bake for 30-40 minutes.\n4. Let cool, frost with chocolate icing.');

INSERT INTO users (id, username, email, password_hash) VALUES
(1, 'john_doe', 'john@example.com', 'password123'),
(2, 'jane_smith', 'jane@example.com', 'password123'),
(3, 'michael_brown', 'michael@example.com', 'password123'),
(4, 'sarah_jones', 'sarah@example.com', 'password123'),
(5, 'emma_clark', 'emma@example.com', 'password123');

INSERT INTO restaurants (id, name, owner_id, total_comments, total_reviews, average_rating) VALUES
(1, 'Italian Bistro', 1, 10, 5, 4.5),
(2, 'Curry Palace', 2, 20, 15, 4.8),
(3, 'Sushi Spot', 3, 5, 4, 4.2),
(4, 'Taco Heaven', 4, 8, 6, 4.7),
(5, 'Sweet Treats', 5, 12, 10, 4.9);


INSERT INTO reviews (id, restaurant_id, user_id, rating, comment, created_at) VALUES
(1, 1, 2, 5, 'Amazing pasta and great service!', '2024-12-01 12:00:00'),
(2, 1, 3, 4, 'Delicious food but a bit pricey.', '2024-12-02 13:00:00'),
(3, 2, 4, 5, 'Best curry in town!', '2024-12-03 18:30:00'),
(4, 2, 1, 4, 'Great flavors but slow service.', '2024-12-04 19:00:00'),
(5, 3, 5, 5, 'Sushi was fresh and beautifully presented.', '2024-12-05 20:00:00'),
(6, 4, 3, 5, 'Tacos were amazing!', '2024-12-06 15:00:00'),
(7, 4, 2, 4, 'Good food but limited options.', '2024-12-06 16:00:00'),
(8, 5, 1, 5, 'The chocolate cake was heavenly!', '2024-12-07 14:00:00'),
(9, 5, 4, 5, 'Delicious desserts and great ambiance.', '2024-12-07 15:00:00'),
(10, 5, 5, 4, 'Great place for a sweet treat!', '2024-12-07 16:00:00');
