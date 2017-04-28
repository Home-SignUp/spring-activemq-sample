--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email VARCHAR(50)
);


--http://stackoverflow.com/questions/9361227/how-to-replace-enum-type-in-h2-databse
--DROP TABLE orders IF EXISTS;

CREATE TABLE orders (
  orderId VARCHAR(40) PRIMARY KEY,
  productName VARCHAR(255),
  quantity INTEGER,
  status VARCHAR(15) CHECK (status IN ('CREATED','PENDING','CONFIRMED','FAILED'))
);