--4. Вывести список стран Северной и Южной Америки, 
--население которых больше 20 млн. чел.
--, или стран Африки, у которых население больше 30 млн. чел

DECLARE 
@AMERICACONTHUM INT
,@AFRICACONTHUM INT
,@SQUARE INT
,@SOUTH VARCHAR(50)
,@NORTH VARCHAR(50)
,@AFRICA VARCHAR(50)

--AMERICA SETTING
SET @AMERICACONTHUM = 20000000
SET @SQUARE = 100000
SET @SOUTH = 'Южная Америка'
SET @NORTH = 'Северная Америка'

--AFRICA SETTING
SET @AFRICACONTHUM = 30000000
SET @AFRICA = 'Африка'

SELECT *
FROM Страны AS C
WHERE 
--AMERICA
C.Население > @AMERICACONTHUM
AND
(C.Континент = @SOUTH OR C.Континент = @NORTH)

OR
--AFRICA
C.Население > @AFRICACONTHUM
AND C.Континент = @AFRICA

ORDER BY C.Континент ASC,
C.Население DESC