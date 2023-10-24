INSERT INTO order_via_cep (address_id, zip_code, number, street)
VALUES
(101, '12345-678', 1001, 'Wall Street'),
(102, '98765-432', 2002, 'Avenida Teste 2'),
(103, '54321-876', 3003, 'Praça Amostra 3'),
(104, '11111-111', 4004, 'Alameda Demonstração 4'),
(105, '99999-999', 5005, 'Estrada Modelo 5');

INSERT INTO order_product (product_id, description, name, quantity, value)
VALUES
(1, 'Descrição do Produto 1', 'Produto 1', 10, 25.99),
(2, 'Descrição do Produto 2', 'Produto 2', 5, 19.99),
(3, 'Descrição do Produto 3', 'Produto 3', 20, 32.50),
(4, 'Descrição do Produto 4', 'Produto 4', 15, 28.75),
(5, 'Descrição do Produto 5', 'Produto 5', 8, 22.99);

INSERT INTO order_tb (cancel_date, cancel_reason, date, discount, payment_method, `status`, subtotal_value, total_value, address_id, product_id)
VALUES
(NULL, NULL, '2023-10-18 08:30:00.123', 0.0, 'CREDIT_CARD', 'CONFIRMED', 29.98, 29.98, 101, 1),
(NULL, NULL, '2022-10-20 10:15:00.789', 0.0, 'PIX', 'SENT',  39.99,  39.99, 103, 3),
(NULL, NULL, '2023-10-21 09:00:00.234', 0.0, 'CRYPTOCURRENCY', 'CONFIRMED', 59.99, 59.99, 104, 4),
(NULL, NULL, '2023-10-22 16:20:00.567', 0.0, 'GIFT_CARD', 'CONFIRMED', 24.98, 24.98, 105, 5),
(NULL, NULL, '2023-10-22 16:20:00.567', 0.0, 'GIFT_CARD', 'CONFIRMED', 9.99, 9.99, 105, 6),
(NULL, NULL, '2023-10-21 09:00:00.234', 0.0, 'CRYPTOCURRENCY', 'CONFIRMED', 59.99, 59.99, 104, 7),
(NULL, NULL, '2023-10-22 16:20:00.567', 0.0, 'GIFT_CARD', 'CONFIRMED', 0.0, 0.0, 105, 8),
(NULL, NULL, '2023-10-22 16:20:00.567', 0.0, 'GIFT_CARD', 'CONFIRMED', 15.99, 15.99, 105, 9),
(NULL, NULL, '2023-10-21 09:00:00.234', 0.0, 'CRYPTOCURRENCY', 'CONFIRMED', 44.99, 44.99, 104, 10);
