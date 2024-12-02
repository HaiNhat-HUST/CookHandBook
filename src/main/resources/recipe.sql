CREATE TABLE recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,   -- AUTO_INCREMENT for MySQL
    name VARCHAR(255),
    cuisine_type VARCHAR(100),
    time INT,         -- Time in minutes
    calorie INT,      -- Calorie count per serving
    ingredient TEXT,  -- List of ingredients
    tutorial TEXT     -- Step-by-step tutorial
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
