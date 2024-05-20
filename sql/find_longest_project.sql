SELECT ID AS project_id, DATEDIFF('MONTH', MIN(start_date), MAX(finish_date))
FROM project
GROUP BY ID
ORDER BY ID DESC
LIMIT 1;