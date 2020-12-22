DROP TABLE user;
CREATE TABLE
    USER
    (
        id INT(6) unsigned NOT NULL AUTO_INCREMENT,
        user_name VARCHAR(50),
        user_code VARCHAR(50) NOT NULL,
        password VARCHAR(50) NOT NULL,
        user_flag VARCHAR(20),
        email VARCHAR(50),
        sex VARCHAR(2),
        birthday DATE,
        address VARCHAR(255),
        zipcode VARCHAR(20),
        phone VARCHAR(20),
        profession VARCHAR(50),
        PRIMARY KEY (id),
        CONSTRAINT user_code UNIQUE (user_code)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8 DEFAULT COLLATE=utf8_general_ci;
