-- Inserir planos
INSERT INTO plans (id, name, max_students, price) VALUES
(1, 'Plano Básico', 50, 29.99),
(2, 'Plano Premium', 100, 49.99);

-- Inserir usuários
INSERT INTO users (id, name, email, password, cpf, date_of_birth, plan_id) VALUES
(1, 'João Silva', 'joao.silva@example.com', '$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', '123.456.789-00', '1980-01-01', 1),
(2, 'Maria Oliveira', 'maria.oliveira@example.com', '$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', '987.654.321-00', '1990-02-02', 2);

-- Inserir estudantes
INSERT INTO students (id, name, email, cpf, contact, date_of_birth, city, neighborhood, street, number, state, cep, user_id) VALUES
(1, 'Estudante Um', 'estudante.um@example.com', '111.222.333-44', '12345-6789', '2000-03-03', 'Cidade Um', 'Bairro Um', 'Rua Um', '10', 'ST', '12345-678', 1),
(2, 'Estudante Dois', 'estudante.dois@example.com', '555.666.777-88', '98765-4321', '2002-04-04', 'Cidade Dois', 'Bairro Dois', 'Rua Dois', '20', 'ST', '98765-432', 2);

-- Inserir exercícios
INSERT INTO exercises (id, description, user_id) VALUES
(1, 'Flexão de Braço', 1),
(2, 'Agachamento', 2);

-- Inserir treinos
INSERT INTO workouts (id, student_id, exercise_id, repetitions, weight, break_time, day, observations, time) VALUES
(1, 1, 1, 15, 0, 60, 'MONDAY', 'Sem observações', 30),
(2, 2, 2, 20, 0, 90, 'TUESDAY', 'Sem observações', 45);
