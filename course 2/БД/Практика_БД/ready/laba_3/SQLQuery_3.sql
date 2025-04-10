--3. Вывести список стран, население которых больше 5 млн. чел., а площадь меньше 100 тыс. кв. км., и они расположены не в Европе.

DECLARE 
@CONTHUM INT
,@SQUARE INT
,@CONTINENT VARCHAR(50)

SET @CONTHUM = 5000000
SET @SQUARE = 100000
SET @CONTINENT = 'Европа'

SELECT *
FROM Страны AS C
WHERE C.Население > @CONTHUM
AND
C.Площадь < @SQUARE
AND
C.Континент != @CONTINENT