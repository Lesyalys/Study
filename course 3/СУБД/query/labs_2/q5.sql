-- 5. Сегментация клиентов по сумме покупок
SELECT 
    CASE 
        WHEN total_spent >= 5000000 THEN 'VIP'
        WHEN total_spent >= 2000000 THEN 'Постоянный'
        ELSE 'Стандартный'
    END as segment,
    COUNT(*) as clients_count,
    AVG(total_spent) as avg_spent
FROM (
    SELECT c.id, SUM(a.PRICE) as total_spent
    FROM dbo.CONTACT c
    JOIN dbo.PAYMENT p ON c.id = p.CONTACT_ID
    JOIN dbo.DEALS d ON p.id = d.PAYMENT_KEY
    JOIN dbo.AUTO a ON d.AUTO_ID = a.id
    GROUP BY c.id
) client_stats
GROUP BY 
    CASE 
        WHEN total_spent >= 5000000 THEN 'VIP'
        WHEN total_spent >= 2000000 THEN 'Постоянный'
        ELSE 'Стандартный'
    END;