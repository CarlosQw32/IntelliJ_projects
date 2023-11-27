INSERT INTO ORDER_PEDIDO (CUSTOMER_ID,STATUS_CODE_ID,CUSTOMER_COMMENTS) VALUES (1,1,'GOD');
INSERT INTO ORDER_PEDIDO (CUSTOMER_ID,STATUS_CODE_ID,CUSTOMER_COMMENTS) VALUES (2,2,'BAD');

INSERT INTO OrderStatusCode( status_code_id, description) VALUES (1,'ENTREGUE')
INSERT INTO OrderStatusCode( status_code_id, description) VALUES (2,'A CAMINHO')

INSERT INTO OrderItem( order_id, price, product_id, quantity) VALUES ( 1, 15.99, 1, 1)
INSERT INTO OrderItem( order_id, price, product_id, quantity) VALUES ( 2, 5.99, 2, 2)