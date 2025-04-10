--2. Вывести наибольшую по населению страну в Северной и Южной Америке.DECLARE @NA VARCHAR(50) = 'Северная Америка';
DECLARE @SA VARCHAR(50) = 'Южная Америка';

WITH MaxPopulation AS (
    SELECT 
        Континент,
        MAX(Население) AS MaxPop
    FROM 
        Страны
    WHERE 
        Континент IN (@NA, @SA)
    GROUP BY 
        Континент
)
SELECT 
    S.Название AS Страна,
    S.Столица,
    S.Население,
    S.Континент
FROM 
    Страны S
INNER JOIN 
    MaxPopulation M ON S.Континент = M.Континент AND S.Население = M.MaxPop
ORDER BY 
    S.Континент;