INSERT INTO state (name)
VALUES ("full"),
       ("half"),
       ("empty");

INSERT INTO label (name)
VALUES ("promo"),
       ("nouveau"),
       ("best seller"),
       ("prix bas");

INSERT INTO product (name, code, description, price, state_id)
VALUES ("Dr Pepper", "DP", "Une bouteille de 1L de Dr Pepper", 2, 1),
       ("Ice Tea", "IT", "Une bouteille de 1L de Ice Tea", 1.5, 1),
       ("Orangina", "OR", "Une bouteille de 1L d'Orangina", 2.5, 2),
       ("San Pellegrino", "SP", "Une bouteille de 1L de San Pellegrino", 3.5, 3);

INSERT INTO product_label (product_id, label_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 4),
       (4, 3),
       (4, 4);



