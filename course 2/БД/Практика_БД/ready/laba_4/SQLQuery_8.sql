﻿--8. Вывести абсолютное значение функций 𝑠𝑖𝑛2 (𝜋/2) − 𝑐𝑜𝑠 (3𝜋/2) с точностью два знака после десятичной запятой

SELECT 
	FORMAT(ABS(SQUARE(SIN(PI()/2)) - COS(3*PI()/2)), 'N2') AS Result