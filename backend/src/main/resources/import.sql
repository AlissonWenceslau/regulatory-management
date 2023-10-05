INSERT INTO Positions (name) VALUES ('Supervisor');
INSERT INTO Positions (name) VALUES ('Preparador');


INSERT INTO Employees (registration, first_name, last_name, indentification, code_area, phone, manager_id, position_id) VALUES ('14290','Alisson','Wenceslau','996872155','47','974327563',null,1);
INSERT INTO Employees (registration, first_name, last_name, indentification, code_area, phone, manager_id, position_id) VALUES ('13898','João','Silva','97654345','47','987654321',1,2);
INSERT INTO Employees (registration, first_name, last_name, indentification, code_area, phone, manager_id, position_id) VALUES ('13520','Manuel','Carvalho','97654345','47','987654321',1,2);

INSERT INTO Categories (name) VALUES ('NR11');
INSERT INTO Categories (name) VALUES ('NR12');

INSERT INTO Trainings (name, category_id) VALUES ('Operação de Paleteira Elétrica',1);
INSERT INTO Trainings (name, category_id) VALUES ('Operação de Talha Elétrica',1);
INSERT INTO Trainings (name, category_id) VALUES ('Operação e Manutenção de Máquinas',2);

INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2022-04-03T00:00:00Z','2025-04-03T00:00:00Z',0,1,1);
INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2022-05-12T00:00:00Z','2025-05-12T00:00:00Z',0,1,1);

INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2019-05-12T00:00:00Z','2022-05-12T00:00:00Z',1,2,1);
INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2022-06-03T00:00:00Z','2025-06-03T00:00:00Z',0,2,1);
INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2023-06-13T00:00:00Z','2026-06-13T00:00:00Z',0,2,2);
INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2023-07-18T00:00:00Z','2026-07-18T00:00:00Z',0,2,3);

INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2023-06-13T00:00:00Z','2026-06-13T00:00:00Z',0,3,2);
INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2022-05-03T00:00:00Z','2025-05-03T00:00:00Z',0,3,1);
INSERT INTO Records (start_date, end_date, status, employee_id, training_id) VALUES ('2023-07-18T00:00:00Z','2026-07-18T00:00:00Z',0,3,3);
