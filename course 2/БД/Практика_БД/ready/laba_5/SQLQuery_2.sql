--2. ������� ���������� �� ��������� ������ � �������� � ����� �������.DECLARE @NA VARCHAR(50) = '�������� �������';
DECLARE @SA VARCHAR(50) = '����� �������';

WITH MaxPopulation AS (
    SELECT 
        ���������,
        MAX(���������) AS MaxPop
    FROM 
        ������
    WHERE 
        ��������� IN (@NA, @SA)
    GROUP BY 
        ���������
)
SELECT 
    S.�������� AS ������,
    S.�������,
    S.���������,
    S.���������
FROM 
    ������ S
INNER JOIN 
    MaxPopulation M ON S.��������� = M.��������� AND S.��������� = M.MaxPop
ORDER BY 
    S.���������;