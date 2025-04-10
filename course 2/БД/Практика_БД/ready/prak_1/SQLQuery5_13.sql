-- Запрос с использованием сложного условия с логическими операторами AND, OR и сортировкой.

SELECT *
,CASE
	WHEN FIO = 'Лысенко Олеся Евгеньевна' THEN 'ITS ME' 
	ELSE 'OTHER'
	END AS 'FIND ME'
FROM Список_жильцов
ORDER BY 'FIND ME'