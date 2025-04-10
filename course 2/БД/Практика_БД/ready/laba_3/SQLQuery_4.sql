--4. ������� ������ ����� �������� � ����� �������, 
--��������� ������� ������ 20 ���. ���.
--, ��� ����� ������, � ������� ��������� ������ 30 ���. ���

DECLARE 
@AMERICACONTHUM INT
,@AFRICACONTHUM INT
,@SQUARE INT
,@SOUTH VARCHAR(50)
,@NORTH VARCHAR(50)
,@AFRICA VARCHAR(50)

--AMERICA SETTING
SET @AMERICACONTHUM = 20000000
SET @SQUARE = 100000
SET @SOUTH = '����� �������'
SET @NORTH = '�������� �������'

--AFRICA SETTING
SET @AFRICACONTHUM = 30000000
SET @AFRICA = '������'

SELECT *
FROM ������ AS C
WHERE 
--AMERICA
C.��������� > @AMERICACONTHUM
AND
(C.��������� = @SOUTH OR C.��������� = @NORTH)

OR
--AFRICA
C.��������� > @AFRICACONTHUM
AND C.��������� = @AFRICA

ORDER BY C.��������� ASC,
C.��������� DESC