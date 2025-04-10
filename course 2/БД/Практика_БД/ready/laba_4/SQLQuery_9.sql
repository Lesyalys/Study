--9. Вывести количество дней до конца семестра

DECLARE @DATENOW DATE
SET @DATENOW = GETDATE()

SELECT 
MAX(S.Дата) AS 'Последний экзмаен'
,DATEDIFF(DAY,MAX(S.Дата),@DATENOW) AS 'до конца семестра'
FROM Экзамен AS S