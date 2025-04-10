--2. Вывести список африканских стран, население которых не превышает 1 млн. чел.
DECLARE @COUNTHUM INT, @CUNT VARCHAR(50)
SET @COUNTHUM = 1000000
SET @CUNT = 'Африка'

SELECT * 

FROM Страны AS C

WHERE 
	C.Континент = @CUNT
	AND
	C.Население <= @COUNTHUM