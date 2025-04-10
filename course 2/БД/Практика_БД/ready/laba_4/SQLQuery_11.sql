--11.Вывести ФИО и високосность года рождения каждого академика.

SELECT A.ФИО
,FORMAT(A.Дата_рождения,'dd/MM/yyyy') AS 'DATE'
, CASE 
	WHEN  YEAR(A.Дата_рождения) % 400 = 0 THEN 'Високосный'
	WHEN YEAR(A.Дата_рождения) % 4 = 0 THEN 'Високосный'
	ELSE 'Не високосный'
	END AS 'YEAR'
FROM Академики AS A

ORDER BY 'YEAR'
