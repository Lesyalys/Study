--5. ������� ������ �����, ��������� ������� ���������� �� 10 �� 100 ���. ���.,
-- � ������� �� ������ 500 ���. ��. ��


DECLARE 
@SQUARE INT

SET @SQUARE = 500000

SELECT *
FROM ������ AS C
WHERE 
C.��������� BETWEEN 10 AND 100000
AND
C.������� <= @SQUARE

ORDER BY C.��������� ASC,
C.��������� DESC