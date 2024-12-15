CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(15) DEFAULT 'USER' NOT NULL
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
);
CREATE TABLE favorite_recipe (
                                 user_id INT NOT NULL,
                                 recipe_id INT NOT NULL,
                                 FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                                 FOREIGN KEY (recipe_id) REFERENCES recipes(id) ON DELETE CASCADE
);
CREATE TABLE favorite_restaurant (
                                     user_id INT NOT NULL,
                                     restaurant_id INT NOT NULL,
                                     FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                                     FOREIGN KEY (restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);

-- Insert sample data into `users`
INSERT INTO users (email, username, password, role)
VALUES
    ('alice@example.com', 'alice123', '123456', 'USER'),
    ('bob@example.com', 'bob456', 'soccer', 'OWNER'),
    ('charlie@example.com', 'charlie789', 'TAP', 'USER'),
    ('diana@example.com', 'diana007', 'iamlampham', 'USER'),
    ('edward@example.com', 'edward88', 'FieryPhoenix', 'OWNER'),
    ('fiona@example.com', 'fiona77', 'mrsung', 'USER'),
    ('george@example.com', 'george66', 'geogre', 'OWNER'),
    ('hannah@example.com', 'hannah88', 'hannah', 'USER'),
    ('ian@example.com', 'ian999', 'ian', 'USER'),
    ('julia@example.com', 'julia55', 'julia', 'USER'),
    ('admin@cookhandbook.cysec', 'administrator', 'canyouguessmypassword', 'ADMIN');

-- Insert sample data into `restaurants`
INSERT INTO restaurants (name, address, owner_id, phone_number, status)
VALUES
    ('Gourmet Kitchen', '123 Food Lane', 2, '123-456-7890', 'APPROVED'),
    ('Pizza Palace', '456 Pizza St', 2, '987-654-3210', 'PENDING'),
    ('Burger Haven', '789 Burger Ave', 5, '555-123-4567', 'APPROVED'),
    ('Taco Fiesta', '321 Taco Blvd', 5, '444-222-1111', 'PENDING'),
    ('Sushi World', '567 Sushi Lane', 2, '333-666-9999', 'APPROVED'),
    ('Veggie Delight', '890 Green St', 7, '222-555-8888', 'APPROVED'),
    ('BBQ Heaven', '345 Grill Rd', 7, '999-333-2222', 'APPROVED'),
    ('Noodle Nook', '678 Ramen St', 5, '777-444-9999', 'APPROVED'),
    ('Seafood Paradise', '901 Ocean Ave', 7, '888-666-4444', 'PENDING'),
    ('Pancake House', '234 Breakfast Blvd', 7, '123-321-1234', 'APPROVED');

-- Insert 2 reviews for each restaurant
INSERT INTO restaurant_review (restaurant_id, user_id, rating, comment)
VALUES
    (1, 1, 5, 'Amazing food and great service!'),
    (1, 4, 4, 'Delicious but a bit pricey.'),
    (2, 3, 4, 'Good pizza but a bit expensive.'),
    (2, 6, 3, 'Average quality, but nice ambiance.'),
    (3, 4, 5, 'Best burgers in town!'),
    (3, 1, 4, 'Juicy and flavorful.'),
    (4, 7, 3, 'Tacos were decent but not exceptional.'),
    (4, 8, 4, 'Tasty but needed more spice.'),
    (5, 2, 5, 'Fresh and authentic sushi!'),
    (5, 9, 4, 'Good, but portions were small.'),
    (6, 3, 5, 'Healthy and delicious!'),
    (6, 5, 4, 'Loved the creative veggie options.'),
    (7, 4, 5, 'Perfectly cooked and sauced.'),
    (7, 10, 4, 'Great BBQ, but a bit smoky inside.'),
    (8, 9, 4, 'Authentic ramen experience!'),
    (8, 6, 5, 'Best noodles I’ve ever had.'),
    (9, 8, 5, 'Amazing seafood variety.'),
    (9, 7, 4, 'Fresh but quite pricey.'),
    (10, 2, 4, 'Perfect for breakfast lovers.'),
    (10, 1, 5, 'Fluffy pancakes and great syrup.');

-- Insert sample data into `recipes`
INSERT INTO recipes (name, author_id, cuisine_type, time, ingredient, tutorial, status)
VALUES
    ('Spaghetti Bolognese', 1, 'Italian', 45, 'Spaghetti, minced beef, tomato sauce',
     '1. Cook the minced beef in a pan until browned.
       2. Boil spaghetti until al dente.
       3. Add tomato sauce to beef and simmer.
       4. Mix spaghetti with the sauce and serve.', 'APPROVED'),
    ('Sushi Rolls', 3, 'Japanese', 30, 'Rice, nori, fish',
     '1. Prepare sushi rice and season it with vinegar.
       2. Lay nori sheet and spread rice evenly.
       3. Add fish and vegetables.
       4. Roll tightly and slice into pieces.', 'APPROVED'),
    ('Tacos Al Pastor', 5, 'Mexican', 25, 'Tortillas, pork, pineapple',
     '1. Marinate pork in spices overnight.
       2. Grill the pork until tender.
       3. Slice thinly and layer on tortillas.
       4. Add pineapple and salsa, then serve.', 'APPROVED'),
    ('Classic Cheeseburger', 4, 'American', 20, 'Buns, beef patty, cheese',
     '1. Grill the beef patty until fully cooked.
       2. Toast buns lightly on the grill.
       3. Assemble burger with cheese, lettuce, and tomato.
       4. Add your favorite sauce and enjoy.', 'APPROVED'),
    ('Vegetarian Curry', 2, 'Indian', 40, 'Vegetables, curry spices, coconut milk',
     '1. Chop vegetables into bite-sized pieces.
       2. Heat oil in a pan and add spices to release aroma.
       3. Add vegetables and cook until tender.
       4. Stir in coconut milk and simmer. Serve with rice.', 'PENDING'),
    ('Pad Thai', 6, 'Thai', 30, 'Rice noodles, shrimp, peanuts, bean sprouts',
     '1. Soak rice noodles in warm water until soft.
       2. Stir-fry shrimp in a wok with garlic.
       3. Add noodles, tamarind sauce, and bean sprouts.
       4. Top with crushed peanuts and serve.', 'APPROVED'),
    ('Chicken Alfredo Pasta', 8, 'Italian', 35, 'Pasta, chicken, cream, parmesan cheese',
     '1. Cook pasta until al dente.
       2. Sauté chicken in a pan with garlic.
       3. Add cream and parmesan cheese to create sauce.
       4. Toss pasta in the sauce and serve hot.', 'APPROVED'),
    ('Chocolate Lava Cake', 7, 'Dessert', 25, 'Chocolate, butter, sugar, eggs, flour',
     '1. Melt chocolate and butter together.
       2. Whisk eggs and sugar until fluffy.
       3. Fold in flour and melted chocolate.
       4. Pour into ramekins and bake until edges are firm but center is soft.', 'APPROVED'),
    ('Falafel Wrap', 9, 'Middle Eastern', 20, 'Chickpeas, garlic, parsley, pita bread',
     '1. Blend chickpeas, garlic, and parsley into a paste.
       2. Form into small patties and fry until golden.
       3. Stuff pita bread with falafel, lettuce, and tahini sauce.
       4. Roll tightly and serve.', 'PENDING'),
    ('Grilled Salmon', 10, 'Seafood', 25, 'Salmon, olive oil, lemon, dill',
     '1. Rub salmon with olive oil, lemon juice, and dill.
       2. Preheat grill to medium heat.
       3. Grill salmon for 4-5 minutes per side.
       4. Serve with steamed vegetables or rice.', 'APPROVED'),
    ('Shakshuka', 1, 'Mediterranean', 30, 'Tomatoes, eggs, bell peppers, spices',
     '1. Sauté onions and bell peppers in a pan.
       2. Add tomatoes and spices, simmer to make a sauce.
       3. Make small wells in the sauce and crack eggs into them.
       4. Cover and cook until eggs are set, then serve.', 'APPROVED'),
    ('Beef Stroganoff', 2, 'Russian', 40, 'Beef, sour cream, onions, mushrooms',
     '1. Slice beef thinly and brown in a pan.
       2. Sauté onions and mushrooms until soft.
       3. Stir in sour cream and beef stock to create sauce.
       4. Add beef back to the pan and simmer. Serve with pasta or rice.', 'APPROVED');

-- Insert 2 reviews for each recipe
INSERT INTO recipe_review (recipe_id, user_id, rating, comment)
VALUES
    (1, 2, 5, 'Delicious and easy to make!'),
    (1, 3, 4, 'Tastes just like home-cooked!'),
    (2, 1, 4, 'Fun to prepare but takes practice.'),
    (2, 5, 5, 'Absolutely perfect sushi rolls!'),
    (3, 6, 5, 'Authentic flavor and easy to make.'),
    (3, 4, 4, 'Great taste, loved the pineapple addition.'),
    (4, 7, 3, 'Simple but not very exciting.'),
    (4, 9, 4, 'Classic burger done right.'),
    (5, 8, 5, 'Rich and flavorful, my family loved it.'),
    (5, 10, 4, 'A bit spicy, but really delicious.'),
    (6, 2, 5, 'Amazing creamy sauce, easy to follow!'),
    (6, 3, 4, 'Loved the taste but portion was small.'),
    (7, 1, 5, 'Decadent dessert, perfect for a party.'),
    (7, 6, 4, 'Rich and gooey, but tricky to bake.'),
    (8, 5, 5, 'Healthy and filling, my go-to lunch now!'),
    (8, 7, 4, 'Great option for vegetarians.'),
    (9, 9, 5, 'Flaky and delicious, love the flavor!'),
    (9, 10, 4, 'Salmon was cooked perfectly.'),
    (10, 8, 5, 'Perfect blend of spices, a hearty dish.'),
    (10, 4, 4, 'Really tasty and easy to make.');