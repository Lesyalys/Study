--12.Вывести список стран Африки, Северной и Южной Америки
DECLARE @C1 VARCHAR(50) = 'Африка'
DECLARE @C2 VARCHAR(50) = 'Северная Америка'
DECLARE @C3 VARCHAR(50) = 'Южная Америка'

SELECT * FROM Страны AS C
WHERE C.Континент IN (@C1,@C2,@C3)

ORDER BY C.Континент ASC