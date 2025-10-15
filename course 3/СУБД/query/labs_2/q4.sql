-- 4. —татистика по статусам автомобилей
SELECT s.STATUS_NAME, COUNT(a.id) as auto_count, 
       AVG(a.PRICE) as avg_price
FROM dbo.AUTO a
JOIN dbo.STATUS s ON a.STATUS = s.id
GROUP BY s.id, s.STATUS_NAME
ORDER BY auto_count DESC;