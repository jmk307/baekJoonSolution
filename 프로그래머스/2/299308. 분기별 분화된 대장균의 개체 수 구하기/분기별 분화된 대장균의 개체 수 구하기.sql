SELECT
    CONCAT(quarter(differentiation_date), 'Q') quarter,
    COUNT(id) ecoli_count
FROM
    ecoli_data
GROUP BY 
    1
ORDER BY
    1;