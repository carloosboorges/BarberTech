UPDATE COMBO_TB c
SET
    valor_original = (
        SELECT COALESCE(SUM(s.valor), 0)
        FROM COMBO_SERVICO_TB cs
                 JOIN SERVICO_TB s ON s.id = cs.servico_id
        WHERE cs.combo_id = c.id
    ),
    valor_com_desconto = (
        SELECT COALESCE(SUM(s.valor), 0) * 0.9
        FROM COMBO_SERVICO_TB cs
                 JOIN SERVICO_TB s ON s.id = cs.servico_id
        WHERE cs.combo_id = c.id
    );
