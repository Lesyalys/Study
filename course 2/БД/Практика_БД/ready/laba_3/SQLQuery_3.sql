--3. ������� ������ �����, ��������� ������� ������ 5 ���. ���., � ������� ������ 100 ���. ��. ��., � ��� ����������� �� � ������.

DECLARE 
@CONTHUM INT
,@SQUARE INT
,@CONTINENT VARCHAR(50)

SET @CONTHUM = 5000000
SET @SQUARE = 100000
SET @CONTINENT = '������'

SELECT *
FROM ������ AS C
WHERE C.��������� > @CONTHUM
AND
C.������� < @SQUARE
AND
C.��������� != @CONTINENT