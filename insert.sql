-- Creazione della tabella clothing_items
CREATE TABLE clothing_items (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL,
    size VARCHAR(10) NOT NULL,
    color VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    in_stock BOOLEAN NOT NULL
);

-- Inserimento di dati di esempio
INSERT INTO clothing_items (id, name, category, size, color, price, in_stock) VALUES
(UUID(), 'T-shirt Basic', 'T-shirt', 'M', 'White', 19.99, TRUE),
(UUID(), 'Jeans Skinny Fit', 'Pantaloni', 'L', 'Blue', 49.99, TRUE),
(UUID(), 'Felpa Oversize', 'Felpe', 'L', 'Black', 39.99, FALSE),
(UUID(), 'Giacca Invernale', 'Giacche', 'XL', 'Green', 89.99, TRUE),
(UUID(), 'Pantaloni da Jogging', 'Pantaloni', 'S', 'Gray', 29.99, TRUE),
(UUID(), 'Camicia Casual', 'Camicie', 'M', 'Blue', 24.99, TRUE),
(UUID(), 'T-shirt Grafica', 'T-shirt', 'S', 'Red', 22.99, FALSE);


CREATE TABLE shops (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);

-- Relazione tra shops e clothing_items
ALTER TABLE clothing_items ADD COLUMN shop_id UUID;
ALTER TABLE clothing_items ADD FOREIGN KEY (shop_id) REFERENCES shops(id);


-- Inserimento di dati di esempio nella tabella shops
INSERT INTO shops (id, name, address, city, country) VALUES
(UUID(), 'Fashion Hub', '123 Fashion St.', 'Milan', 'Italy'),
(UUID(), 'Urban Wear', '45 Trendy Ave.', 'New York', 'USA'),
(UUID(), 'Chic Boutique', '78 Style Rd.', 'Paris', 'France');

-- Recupero degli ID dei negozi per usarli nei riferimenti
SELECT * FROM shops;

-- Utilizza gli ID ottenuti dal comando sopra per associare i negozi agli articoli

-- Aggiorna clothing_items con gli ID dei negozi
UPDATE clothing_items SET shop_id = '<UUID-del-Fashion-Hub>' WHERE name IN ('T-shirt Basic', 'Jeans Skinny Fit');
UPDATE clothing_items SET shop_id = '<UUID-del-Urban-Wear>' WHERE name IN ('Felpa Oversize', 'Giacca Invernale');
UPDATE clothing_items SET shop_id = '<UUID-della-Chic-Boutique>' WHERE name IN ('Pantaloni da Jogging', 'Camicia Casual', 'T-shirt Grafica');
