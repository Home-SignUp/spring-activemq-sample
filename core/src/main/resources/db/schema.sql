--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id VARCHAR(40) PRIMARY KEY,
  publicId INTEGER,
  status VARCHAR(15) CHECK (status IN ('CREATED','PENDING','CONFIRMED','FAILED'))
);