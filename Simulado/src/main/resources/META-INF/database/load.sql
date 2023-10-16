INSERT INTO ORDER_PEDIDO (CUSTOMER_ID,ID,STATUS_CODE_ID,CUSTOMER_COMMENTS) VALUES (1,1,1,'GOD');
INSERT INTO ORDER_PEDIDO (CUSTOMER_ID,ID,STATUS_CODE_ID,CUSTOMER_COMMENTS) VALUES (2,2,2,'BAD');

INSERT INTO OrderStatusCode(id, status_code_id, description) VALUES (1,1,'ENTREGUE')
INSERT INTO OrderStatusCode(id, status_code_id, description) VALUES (2,2,'A CAMINHO')

INSERT INTO OrderItem(id, order_id, price, product_id, quantity) VALUES (1, 1, 15.99, 1, 1)
INSERT INTO OrderItem(id, order_id, price, product_id, quantity) VALUES (2, 2, 5.99, 2, 2)