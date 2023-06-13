CREATE TABLE IF NOT EXISTS CUSTOMER (
  customer_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS TRANSACTION (
  transaction_id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT,
  transaction_date DATE,
  transaction_amount DECIMAL(10,2),
  FOREIGN KEY (customer_id) REFERENCES CUSTOMER(customer_id)
);

CREATE TABLE IF NOT EXISTS REWARDS (
    customer_id INT PRIMARY KEY,
    retail_rewards DOUBLE,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(customer_id)
);