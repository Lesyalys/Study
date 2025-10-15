-- 10. јнализ брендов по количеству продаж, общей выручке и средней цене
SELECT 
    b.id,
    b.BRANDNAME,
    COUNT(DISTINCT a.id) as total_cars,
    COUNT(DISTINCT d.id) as sold_cars,
    CASE 
        WHEN COUNT(DISTINCT a.id) > 0 
        THEN ROUND(COUNT(DISTINCT d.id) * 100.0 / COUNT(DISTINCT a.id), 2)
        ELSE 0 
    END as conversion_rate,
    SUM(CASE WHEN d.id IS NOT NULL THEN a.PRICE ELSE 0 END) as total_revenue,
    AVG(CASE WHEN d.id IS NOT NULL THEN a.PRICE ELSE NULL END) as avg_sale_price,
    AVG(a.PRICE) as avg_list_price,
    MIN(a.PRICE) as min_price,
    MAX(a.PRICE) as max_price,
    (SELECT TOP 1 s.STATUS_NAME 
     FROM dbo.AUTO a2 
     JOIN dbo.STATUS s ON a2.STATUS = s.id 
     WHERE a2.BRANDNAMEKEY = b.id 
     GROUP BY s.STATUS_NAME 
     ORDER BY COUNT(*) DESC) as most_common_status
FROM dbo.BRAND b
LEFT JOIN dbo.AUTO a ON b.id = a.BRANDNAMEKEY
LEFT JOIN dbo.DEALS d ON a.id = d.AUTO_ID
GROUP BY b.id, b.BRANDNAME
HAVING COUNT(DISTINCT a.id) > 0  -- “олько бренды с автомобил€ми
ORDER BY total_revenue DESC, sold_cars DESC;