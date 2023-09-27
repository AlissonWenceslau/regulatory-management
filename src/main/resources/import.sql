INSERT INTO Positions (name) VALUES ('Operador de Manufatura');
INSERT INTO Positions (name) VALUES ('Operador Logístico');
INSERT INTO Positions (name) VALUES ('Supervisor');

INSERT INTO Employees (registration, first_name, last_name, indentification, code_area, phone, manager_id, position_id) VALUES ('14297','João','Silva','97199832052','47','995784432',null,3);
INSERT INTO Employees (registration, first_name, last_name, indentification, code_area, phone, manager_id, position_id) VALUES ('15925','Maria','Torres','46458339011','47','995784432',1,2);
INSERT INTO Employees (registration, first_name, last_name, indentification, code_area, phone, manager_id, position_id) VALUES ('15776','Danilo','Carrara','43328164049','47','981236345',1,1);

INSERT INTO Categories (name) VALUES ('NR11');
INSERT INTO Categories (name) VALUES ('NR12');
INSERT INTO Categories (name) VALUES ('NR35');

INSERT INTO Trainings (name, category_id) VALUES ('Operação de Paleteira Elétrica',1);
INSERT INTO Trainings (name, category_id) VALUES ('Operação e Manutenção de Máquinas',2);
INSERT INTO Trainings (name, category_id) VALUES ('Trabalho em Altura',3);
