--9. Вывести список профессоров.
DECLARE @STAT VARCHAR(20)

SET @STAT = 'профессор'

SELECT * FROM Преподаватель AS P
WHERE P.Звание = @STAT