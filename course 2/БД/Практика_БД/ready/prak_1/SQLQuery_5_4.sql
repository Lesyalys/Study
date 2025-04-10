--Вся сумма тирифных планов без повторений

SELECT DISTINCT 
SUM(T.TPLAN) AS 'SUMM ALL TPLAN'
FROM Тарифы AS T