--10.Вывести первые 5 строк и всех академиков с таким годом присвоения звания
--из списка академиков, отсортированного по возрастанию года присвоения звания:

DECLARE @DATE INT

SET @DATE = 1889;

WITH FILTERYER AS (
 SELECT * 
 FROM Академики as A
 WHERE A.Год_присвоения_звания = @DATE),

 NO_FILTERYER AS (
	SELECT TOP 5 *
	FROM Академики as A
	ORDER BY A.Год_присвоения_звания ASC
	)

SELECT 
	N.*,
	CASE WHEN N.Год_присвоения_звания = @DATE THEN 'Да'
	ELSE 'Нет'
	END
FROM NO_FILTERYER as N
LEFT JOIN FILTERYER AS F ON N.ФИО = F.ФИО

UNION ALL

SELECT 
	F.*
	,'Да'
FROM FILTERYER AS F