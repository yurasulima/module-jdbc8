CREATE TABLE IF NOT EXISTS worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL CHECK(length(name) >= 2 AND length(name) <= 100),
    birthday DATE CHECK(EXTRACT(YEAR FROM birthday) > 1900),
    level VARCHAR(50) NOT NULL CHECK(level IN('Trainee', 'Junior', 'Middle',  'Senior')),
    salary INT NOT NULL CHECK(salary>= 100 AND salary <=100000)
);

CREATE TABLE IF NOT EXISTS client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK(length(name) >= 2 AND length(name) <= 1000)
);

CREATE TABLE IF NOT EXISTS project (
    id IDENTITY PRIMARY KEY,
    client_id BIGINT,
    start_date DATE,
    finish_date DATE
);

CREATE TABLE IF NOT EXISTS project_worker (
    project_id INT NOT NULL,
    worker_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (worker_id) REFERENCES worker(id)
);