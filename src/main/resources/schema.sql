CREATE SEQUENCE IF NOT EXISTS global_seq START WITH 100000;

CREATE TABLE IF NOT EXISTS users
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR                           NOT NULL,
    password   VARCHAR                           NOT NULL,
    email      VARCHAR                           NOT NULL,
    registered TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR NOT NULL,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS pubs
(
    id      VARCHAR PRIMARY KEY          NOT NULL,
    address VARCHAR                      NOT NULL,
    name    VARCHAR                      NOT NULL,
    type    VARCHAR                      NOT NULL,
    rating  DOUBLE PRECISION DEFAULT 0.0 NOT NULL
);

CREATE TABLE IF NOT EXISTS votes
(
    id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id   INTEGER   NOT NULL,
    pub_id    VARCHAR   NOT NULL,
    date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (pub_id) REFERENCES pubs (id)
);
CREATE UNIQUE INDEX votes_unique_user_pub_datetime_idx ON votes (user_id, pub_id, date_time);