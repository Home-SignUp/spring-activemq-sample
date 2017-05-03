--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  userId VARCHAR(40) PRIMARY KEY,
  productName VARCHAR(255),
  quantity INTEGER,
  status VARCHAR(15) CHECK (status IN ('CREATED','PENDING','CONFIRMED','FAILED'))
);