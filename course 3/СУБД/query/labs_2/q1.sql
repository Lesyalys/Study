-- 1. Самые популярные бренды по количеству сделок
SELECT b.BRANDNAME, COUNT(d.id) as deal_count
FROM dbo.DEALS d
JOIN dbo.AUTO a ON d.AUTO_ID = a.id
JOIN dbo.BRAND b ON a.BRANDNAMEKEY = b.id
GROUP BY b.id, b.BRANDNAME
ORDER BY deal_count DESC;