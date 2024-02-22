CREATE TABLE IF NOT EXISTS public.merchant (
                          uuid UUID PRIMARY KEY,
                          store_name VARCHAR(255) NOT NULL,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          phone VARCHAR(20) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          is_delete BOOLEAN DEFAULT FALSE
);
