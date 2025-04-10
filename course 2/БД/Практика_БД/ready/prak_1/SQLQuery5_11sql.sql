--Запрос с отбором по условию и сортировкой по убыванию одного из полей, 
--а также добавлением поля, содержащего для всех записей константу, определенную при конструировании запроса; 

DECLARE @CONST INT = 1;

SELECT *
,CASE
	WHEN FIO IS NOT NULL THEN @CONST
	END AS 'CONST'
FROM Список_жильцов
WHERE FIO LIKE 'А%'
ORDER BY FIO DESC