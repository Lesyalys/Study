-- 8. Распределение автомобилей по ценовым категориям
SELECT 
    CASE 
        WHEN PRICE < 1000000 THEN 'До 1 млн'
        WHEN PRICE BETWEEN 1000000 AND 2000000 THEN '1-2 млн'
        WHEN PRICE BETWEEN 2000001 AND 5000000 THEN '2-5 млн'
        WHEN PRICE > 5000000 THEN 'Свыше 5 млн'
        ELSE 'Цена не указана'
    END as price_category,
    COUNT(*) as auto_count,
    AVG(PRICE) as avg_price,
    MIN(PRICE) as min_price,
    MAX(PRICE) as max_price
FROM dbo.AUTO
GROUP BY 
    CASE 
        WHEN PRICE < 1000000 THEN 'До 1 млн'
        WHEN PRICE BETWEEN 1000000 AND 2000000 THEN '1-2 млн'
        WHEN PRICE BETWEEN 2000001 AND 5000000 THEN '2-5 млн'
        WHEN PRICE > 5000000 THEN 'Свыше 5 млн'
        ELSE 'Цена не указана'
    END
ORDER BY MIN(COALESCE(PRICE, 0));