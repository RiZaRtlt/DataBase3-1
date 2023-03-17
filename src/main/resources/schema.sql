Create TABLE CUSTOMERS (
                           id int IDENTITY(1,1),
                           name VARCHAR(50) NOT NULL,
                           surname VARCHAR(50) NOT NULL,
                           age int DEFAULT 0,
                           phone_number VARCHAR(50),
                           PRIMARY KEY(id)
);

Create TABLE ORDERS (
                        id int IDENTITY(1,1),
                        date date,
                        customer_id int,
                        product_name VARCHAR(250) NOT NULL,
                        amount int DEFAULT 0,
                        PRIMARY KEY(id),
                        FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);