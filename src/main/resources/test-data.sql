
INSERT INTO department (department_id, department_name, data_create, parent_department)
    VALUES (1000,'����������� 1�� ��. ���������� 1', '11.11.1998', NULL);
INSERT INTO department (department_id, department_name, data_create, parent_department)
    VALUES (1001,'����������� 2�� ��. ���������� 11', '12.11.1998', 1000);
INSERT INTO department (department_id, department_name, data_create, parent_department)
    VALUES (1002,'����������� 2�� ��. ���������� 12', '13.11.1998', 1000);
INSERT INTO department (department_id, department_name, data_create, parent_department)
    VALUES (1003,'����������� 3�� ��. ���������� 111', '09.12.1999', 1001);


INSERT INTO employee (employee_id, last_name, first_name, middle_name, gender, date_birth,
		              phone, email,	employment_date, dismissal_date, employee_position, salary, leader_flag, department_id)
              VALUES (100,'�����','�����','����������','�','10.02.1959',
	                  '359(864)321-50-05','yfymmiva-6726@yopmail.com','11.11.1998',NULL,'LEADER',80000,true,1000);
INSERT INTO employee (employee_id, last_name, first_name, middle_name, gender, date_birth,
		              phone, email,	employment_date, dismissal_date, employee_position, salary, leader_flag, department_id)
              VALUES (101,'�������','����','����������','�','04.06.1990',
	                  '5(783)893-17-27','ubibeges-9906@yopmail.com','12.11.2009',NULL,'WORKER',40000,false,1000);
INSERT INTO employee (employee_id, last_name, first_name, middle_name, gender, date_birth,
		              phone, email,	employment_date, dismissal_date, employee_position, salary, leader_flag, department_id)
              VALUES (102,'������','�������','��������','�','06.11.1964',
	                  '0(59)768-45-13','eroxace-9840@yopmail.com','04.03.1999','13.11.2009','WORKER',40000,false,1000);
INSERT INTO employee (employee_id, last_name, first_name, middle_name, gender, date_birth,
		              phone, email,	employment_date, dismissal_date, employee_position, salary, leader_flag, department_id)
              VALUES (103,'�����','������','������������','�','03.08.1962',
	                  '002(6160)938-43-99','emujuroff-5221@yopmail.com','13.11.1998',NULL,'LEADER',67000,true,1001);
INSERT INTO employee (employee_id, last_name, first_name, middle_name, gender, date_birth,
		              phone, email,	employment_date, dismissal_date, employee_position, salary, leader_flag, department_id)
              VALUES (104,'������','����','�����������','�','22.03.1988',
	                  '44(28)187-25-00','velapirott-2828@yopmail.com','13.11.1998',NULL,'LEADER',67000,true,1002);
