CREATE TABLE tb_user (
    id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(150) NOT NULL UNIQUE
);

-- Tabela de Cursos (tb_course)
CREATE TABLE tb_course (
   id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(150) NOT NULL,
   category VARCHAR(100) NOT NULL
);

-- Tabela de Tópicos (tb_topics)
CREATE TABLE tb_topics (
    id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status ENUM('NOT_ANSWERED', 'UNANSWERED', 'ANSWERED', 'CLOSED') NOT NULL DEFAULT 'NOT_ANSWERED',
    course_id int UNSIGNED NOT NULL,
    user_id int UNSIGNED NOT NULL,

    -- Relacionamentos (Chaves Estrangeiras)
    CONSTRAINT fk_topics_course FOREIGN KEY (course_id) REFERENCES tb_course(id) ON DELETE RESTRICT,
    CONSTRAINT fk_topics_user FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE RESTRICT
);

-- Tabela de Respostas (tb_answer)
CREATE TABLE tb_answer (
    id int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    solution BOOLEAN NOT NULL DEFAULT FALSE,
    topic_id int UNSIGNED NOT NULL,
    user_id int UNSIGNED NOT NULL,

    CONSTRAINT fk_answer_topic FOREIGN KEY (topic_id) REFERENCES tb_topics(id) ON DELETE CASCADE,
    CONSTRAINT fk_answer_user FOREIGN KEY (user_id) REFERENCES tb_user(id) ON DELETE RESTRICT
);
