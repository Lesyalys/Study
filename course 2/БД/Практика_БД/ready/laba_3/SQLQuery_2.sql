--2. ������� ������ ����������� �����, ��������� ������� �� ��������� 1 ���. ���.
DECLARE @COUNTHUM INT, @CUNT VARCHAR(50)
SET @COUNTHUM = 1000000
SET @CUNT = '������'

SELECT * 

FROM ������ AS C

WHERE 
	C.��������� = @CUNT
	AND
	C.��������� <= @COUNTHUM