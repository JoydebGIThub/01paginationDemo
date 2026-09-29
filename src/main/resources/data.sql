INSERT INTO products (name, category, price)
VALUES ('Laptop', 'Electronics', 75000);

INSERT INTO products (name, category, price)
VALUES ('Mobile Phone', 'Electronics', 35000);

INSERT INTO products (name, category, price)
VALUES ('Keyboard', 'Accessories', 1500);

INSERT INTO products (name, category, price)
VALUES ('Mouse', 'Accessories', 800);

INSERT INTO products (name, category, price)
VALUES ('Monitor', 'Electronics', 18000);

INSERT INTO products (name, category, price)
VALUES ('Headphones', 'Accessories', 2500);

INSERT INTO products (name, category, price)
VALUES ('Tablet', 'Electronics', 28000);

INSERT INTO products (name, category, price)
VALUES ('Webcam', 'Accessories', 3500);

INSERT INTO products (name, category, price)
VALUES ('Printer', 'Office', 12000);

INSERT INTO products (name, category, price)
VALUES ('Chair', 'Furniture', 8500);

INSERT INTO products (name, category, price)
VALUES ('Desk', 'Furniture', 15000);

INSERT INTO products (name, category, price)
VALUES ('USB Cable', 'Accessories', 500);

INSERT INTO products (name, category, price)
VALUES ('Power Bank', 'Electronics', 2200);

INSERT INTO products (name, category, price)
VALUES ('Smart Watch', 'Electronics', 6500);

INSERT INTO products (name, category, price)
VALUES ('Microphone', 'Accessories', 5500);

INSERT INTO products (name, category, price)
SELECT 'Products ' || X,
       CASE WHEN MOD(X, 2) = 0 THEN 'Electronics' ELSE 'Books' END,
       X * 50
FROM SYSTEM_RANGE(1, 25);