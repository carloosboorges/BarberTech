CREATE TABLE combo_tb (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255),
                          valor DECIMAL(10,2)
);

CREATE TABLE servico_tb (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            nome_servico VARCHAR(255),
                            valor DECIMAL(10,2),
                            duracao_estimada_minutos INT
);
