--9. ���� � ������ ���� ���� �� ���� ������, ������� ������� ������ 2 ���. ��. ��., ������� ������ ���� ����������� �����.
DECLARE @CONT VARCHAR(20) = '������'

SELECT C.* 
FROM ������ AS C
WHERE C.��������� = @CONT
AND
EXISTS (SELECT * 
		FROM ������ AS C1
		WHERE C1.��������� = @CONT
		AND
		C1.������� > 2000000
		)
ORDER BY C.������� DESC