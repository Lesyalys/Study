--12.Вывести список студентов, не сдавших ни одного экзамена в указанной дате.

DECLARE @START_DATE DATE = '2015-06-05';
DECLARE @END_DATE DATE = '2015-06-10';

SELECT 
    S.Рег_номер
    ,S.Фамилия
FROM 
    Студент S
WHERE 
    NOT EXISTS (
        SELECT 1 
        FROM Экзамен E 
        WHERE E.Рег_номер = S.Рег_номер
        AND E.Дата BETWEEN @START_DATE AND @END_DATE
    )
ORDER BY 
    S.Фамилия;