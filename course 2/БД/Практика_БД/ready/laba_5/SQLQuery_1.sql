--1. Вывести минимальную площадь стран
DECLARE @MIN FLOAT = 800

SELECT * 
FROM Страны AS C
WHERE C.Площадь <= @MIN
ORDER BY C.Название ASC
