DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;

CREATE TABLE department(
        department_id SERIAL PRIMARY KEY ,
        department_name varchar(50) NOT NULL UNIQUE ,
        data_create date NOT NULL ,
        parent_department  INTEGER REFERENCES department(department_id) ON DELETE CASCADE
);

CREATE TABLE employee(
        employee_id SERIAL PRIMARY KEY ,
        last_name varchar(40) NOT NULL ,
        first_name varchar(40) NOT NULL ,
        middle_name varchar(40),
        gender varchar(20) NOT NULL ,
        date_birth date NOT NULL ,
        phone varchar(40) NOT NULL ,
        email  varchar(40) NOT NULL ,
        employment_date timestamptz NOT NULL ,
        dismissal_date timestamptz ,
        employee_position varchar(40) NOT NULL ,
        salary money NOT NULL ,
        leader_flag BOOL,
        department_id INTEGER NOT NULL REFERENCES department (department_id)
);