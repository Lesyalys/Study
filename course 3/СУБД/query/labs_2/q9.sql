-- 9.10 самых дорогих автомобилей с полной информацией
SELECT TOP 10
    a.id,
    b.BRANDNAME,
    a.MILEAGE,
    a.PRICE,
    s.STATUS_NAME,
    (SELECT COUNT(*) FROM dbo.DEALS d WHERE d.AUTO_ID = a.id) as deal_count,
    (SELECT MAX(DATA) FROM dbo.DEALS d WHERE d.AUTO_ID = a.id) as last_deal_date
FROM dbo.AUTO a
JOIN dbo.BRAND b ON a.BRANDNAMEKEY = b.id
JOIN dbo.STATUS s ON a.STATUS = s.id
WHERE a.PRICE IS NOT NULL
ORDER BY a.PRICE DESC;