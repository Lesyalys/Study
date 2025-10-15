-- 6. Анализ сезонности продаж по месяцам
SELECT DATENAME(MONTH, d.DATA) as month_name,
       COUNT(d.id) as deal_count,
       ROUND(COUNT(d.id) * 100.0 / (SELECT COUNT(*) FROM dbo.DEALS), 2) as percentage
FROM dbo.DEALS d
WHERE d.DATA IS NOT NULL
GROUP BY DATENAME(MONTH, d.DATA), MONTH(d.DATA)
ORDER BY MONTH(d.DATA);