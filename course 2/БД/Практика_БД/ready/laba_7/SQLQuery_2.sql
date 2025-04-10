--2. Вывести список стран с площадью больше 1 млн. кв. км., исключить страны
--с населением меньше 100 млн. чел.:

DECLARE @Q FLOAT = 1000000;   
DECLARE @H BIGINT = 10000000;   


WITH W1 AS (
    SELECT *
    FROM Страны AS C
    WHERE C.Площадь > @Q
),

W2 AS (
    SELECT *
    FROM Страны AS C1
    WHERE C1.Население < @H
)

SELECT * FROM W1
EXCEPT
SELECT * FROM W2
ORDER BY Площадь DESC,Население DESC;