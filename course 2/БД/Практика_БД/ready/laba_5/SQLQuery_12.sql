--12.Вывести список континентов, 
--у которых средняя плотность среди стран с населением более 1 млн. чел. больше чем 30 чел. на кв. км

DECLARE @COUNTH BIGINT = 1000000;
DECLARE @MIN_DENSITY INT = 30;

SELECT 
    C.Континент
FROM 
    Страны AS C
WHERE 
    C.Население >= @COUNTH
GROUP BY 
    C.Континент
HAVING 
    AVG(C.Население * 1.0 / NULLIF(C.Площадь, 0)) > @MIN_DENSITY;