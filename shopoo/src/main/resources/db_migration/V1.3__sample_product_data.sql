-- Inserting products for the first merchant
INSERT INTO public.product (uuid, name, description, price, in_stock, merchant_id, created_at, updated_at, is_delete)
SELECT
    uuid_generate_v4(),
    CONCAT('Product ', (ROW_NUMBER() OVER ())::text, ' for Fantastic Finds'),
    CONCAT('Description for Product ', (ROW_NUMBER() OVER ())::text, ' for Fantastic Finds'),
    ROUND((RANDOM() * 1000)::numeric, 2),
    FLOOR(RANDOM() * 100),
    '5aa6f819-1c3c-4694-b5b5-7908d4f4072f'::uuid,
    '2023-01-01 10:00:00',
    '2023-01-01 10:00:00',
    FALSE
FROM
    generate_series(1, 5);

-- Inserting products for the second merchant
INSERT INTO public.product (uuid, name, description, price, in_stock, merchant_id, created_at, updated_at, is_delete)
SELECT
    uuid_generate_v4(),
    CONCAT('Product ', (ROW_NUMBER() OVER ())::text, ' for Luxury Living'),
    CONCAT('Description for Product ', (ROW_NUMBER() OVER ())::text, ' for Luxury Living'),
    ROUND((RANDOM() * 1000)::numeric, 2),
    FLOOR(RANDOM() * 100),
    '38d3b220-e6f6-481e-b7d2-066fb3f88b9d'::uuid,
    '2023-01-02 10:00:00',
    '2023-01-02 10:00:00',
    FALSE
FROM
    generate_series(1, 5);
