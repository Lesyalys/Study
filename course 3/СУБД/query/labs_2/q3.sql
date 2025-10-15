-- 3. јвтомобили по статусам с датой последней сделки
SELECT a.id, b.BRANDNAME, a.MILEAGE, a.PRICE, s.STATUS_NAME,
       MAX(d.DATA) as last_deal_date
FROM dbo.AUTO a
JOIN dbo.BRAND b ON a.BRANDNAMEKEY = b.id
JOIN dbo.STATUS s ON a.STATUS = s.id
LEFT JOIN dbo.DEALS d ON a.id = d.AUTO_ID
GROUP BY a.id, b.BRANDNAME, a.MILEAGE, a.PRICE, s.STATUS_NAME
ORDER BY last_deal_date ASC;