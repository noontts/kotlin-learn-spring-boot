CREATE TABLE IF NOT EXISTS public.product (
                         uuid UUID PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         in_stock INT NOT NULL,
                         merchant_id UUID NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         is_delete BOOLEAN DEFAULT FALSE,
                         FOREIGN KEY (merchant_id) REFERENCES merchant(uuid)
);
