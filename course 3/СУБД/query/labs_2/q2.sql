-- 2. Контакты с самой высокой общей стоимостью покупок
SELECT c.FIRST_NAME, c.LAST_NAME, c.EMAIL, 
       SUM(a.PRICE) as total_spent, COUNT(d.id) as purchases
FROM dbo.CONTACT c
JOIN dbo.PAYMENT p ON c.id = p.CONTACT_ID
JOIN dbo.DEALS d ON p.id = d.PAYMENT_KEY
JOIN dbo.AUTO a ON d.AUTO_ID = a.id
GROUP BY c.id, c.FIRST_NAME, c.LAST_NAME, c.EMAIL
ORDER BY total_spent DESC;