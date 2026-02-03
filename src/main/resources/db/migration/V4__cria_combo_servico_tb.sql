CREATE TABLE IF NOT EXISTS COMBO_SERVICO_TB (
                                                combo_id BIGINT NOT NULL,
                                                servico_id BIGINT NOT NULL,
                                                PRIMARY KEY (combo_id, servico_id),
    CONSTRAINT fk_combo FOREIGN KEY (combo_id) REFERENCES COMBO_TB(id),
    CONSTRAINT fk_servico FOREIGN KEY (servico_id) REFERENCES SERVICO_TB(id)
    );
