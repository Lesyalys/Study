--12.������� ������ ����� ������, �������� � ����� �������
DECLARE @C1 VARCHAR(50) = '������'
DECLARE @C2 VARCHAR(50) = '�������� �������'
DECLARE @C3 VARCHAR(50) = '����� �������'

SELECT * FROM ������ AS C
WHERE C.��������� IN (@C1,@C2,@C3)

ORDER BY C.��������� ASC