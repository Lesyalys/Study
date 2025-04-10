--9. Если в Африке есть хотя бы одна страна, площадь которой больше 2 млн. кв. км., вывести список всех африканских стран.
DECLARE @CONT VARCHAR(20) = 'Африка'

SELECT C.* 
FROM Страны AS C
WHERE C.Континент = @CONT
AND
EXISTS (SELECT * 
		FROM Страны AS C1
		WHERE C1.Континент = @CONT
		AND
		C1.Площадь > 2000000
		)
ORDER BY C.Площадь DESC