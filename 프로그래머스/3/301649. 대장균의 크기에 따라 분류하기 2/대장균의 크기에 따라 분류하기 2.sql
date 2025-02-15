SELECT
    ID,
    CASE
        WHEN rank_ <= len_/4 THEN 'CRITICAL'
        WHEN rank_ <= len_/2 THEN 'HIGH'
        WHEN rank_ <= (len_/4) + (len_/2) THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM (SELECT 
        *,
        RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS rank_,
     (SELECT COUNT(*) FROM ECOLI_DATA) AS len_
      FROM ECOLI_DATA) A
ORDER BY ID;