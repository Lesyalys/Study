--5. Вывести список стран, население которых составляет от 10 до 100 млн. чел.,
-- а площадь не больше 500 тыс. кв. км


DECLARE 
@SQUARE INT

SET @SQUARE = 500000

SELECT *
FROM Страны AS C
WHERE 
C.Население BETWEEN 10 AND 100000
AND
C.Площадь <= @SQUARE

ORDER BY C.Континент ASC,
C.Население DESC