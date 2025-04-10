SELECT 
SUM(T.TPLAN) AS 'Вся сумма тарифных планов'
FROM Тарифы AS T
WHERE T.TPLAN BETWEEN 0 AND 1500
