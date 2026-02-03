-- adiciona as novas colunas
ALTER TABLE combo_tb
    ADD COLUMN valor_original DECIMAL(10,2);

ALTER TABLE combo_tb
    ADD COLUMN valor_com_desconto DECIMAL(10,2);


UPDATE combo_tb
SET valor_original = valor,
    valor_com_desconto = valor;

-- remove a coluna antiga
ALTER TABLE combo_tb
DROP COLUMN valor;
