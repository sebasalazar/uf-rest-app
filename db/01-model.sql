BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE; -- 16 kb
CREATE TABLE users (
    pk bigserial NOT NULL, -- 8bytes
    email varchar(255) NOT NULL, -- 16320 bytes
    active boolean NOT NULL DEFAULT '0', -- 2 bytes
    UNIQUE (email),
    PRIMARY KEY (pk)
);
CREATE UNIQUE INDEX ON users(LOWER(TRIM(both FROM email)));


DROP TABLE IF EXISTS ufs CASCADE;
CREATE TABLE ufs (
    pk bigserial NOT NULL,
    uf_date date NOT NULL,
    uf_value numeric(999,2) NOT NULL,
    UNIQUE (uf_date),
    PRIMARY KEY (pk)
);


DROP TABLE IF EXISTS access CASCADE;
CREATE TABLE access (
    pk bigserial NOT NULL,
    user_fk bigint NOT NULL,
    uf_fk bigint NOT NULL,
    created timestamp NOT NULL DEFAULT NOW(),
    FOREIGN KEY (user_fk) REFERENCES users(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (uf_fk) REFERENCES ufs(pk) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE (user_fk, uf_fk),
    PRIMARY KEY (pk)
);

COMMIT;
