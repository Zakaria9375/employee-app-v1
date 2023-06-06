DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
                          id BIGINT AUTO_INCREMENT  PRIMARY KEY  NOT NULL,
                          first_name varchar(150) NOT NULL,
                          last_name varchar(150) NOT NULL,
                          email varchar(150) NOT NULL,
                          PRIMARY KEY (id)
);


INSERT INTO employee (first_name, last_name, email)
VALUES
    ('John', 'Doe', 'john@example.com'),
    ('Mary', 'Smith', 'mary@example.com'),
    ('Susan', 'Johnson', 'susan@example.com');
DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       username varchar(50) NOT NULL,
                       password varchar(50) NOT NULL,
                       enabled tinyint NOT NULL,
                       PRIMARY KEY (username)
);

INSERT INTO users (username, password, enabled)
VALUES
    ('john', '{noop}test1', 1),
    ('mary', '{noop}test2', 1),
    ('susan', '{noop}test3', 1);

DROP TABLE IF EXISTS authorities;

CREATE TABLE authorities (
                             username varchar(50) NOT NULL,
                             authority varchar(50) NOT NULL,
                             CONSTRAINT authorities_pk PRIMARY KEY (username, authority),
                             CONSTRAINT authorities_fk FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO authorities (username, authority)
VALUES
    ('john', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_EMPLOYEE'),
    ('susan', 'ROLE_EMPLOYEE'),
    ('mary', 'ROLE_MANAGER'),
    ('susan', 'ROLE_MANAGER'),
    ('susan', 'ROLE_ADMIN');
